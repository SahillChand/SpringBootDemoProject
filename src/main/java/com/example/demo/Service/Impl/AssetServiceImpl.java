package com.example.demo.Service.Impl;

import com.example.demo.Dao.AssetDetailsRepo;
import com.example.demo.Dao.AssetPricesRepo;
import com.example.demo.Dao.CustomerRepo;
import com.example.demo.Service.AssetService;
import com.example.demo.protos.*;
import com.example.demo.utils.LoggedInUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetPricesRepo assetPricesRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private AssetDetailsRepo assetDetailsRepo;

    @Override
    public AssetTradeResponseDTO handleBuyService(AssetTradeRequestDTO assetTradeRequestDTO) throws Exception{
        LoggedInUserDetails loggedInUserDetails = new LoggedInUserDetails();
        AssetTradeRequestEntity assetTradeRequestEntity=AssetTradeRequestEntity.newBuilder().setAsset(assetTradeRequestDTO.getAsset()).setCurrency(assetTradeRequestDTO.getCurrency()).setWeightUnit(assetTradeRequestDTO.getWeightUnit()).build();
        double current_asset_rate = assetPricesRepo.fetchCurrentRate(assetTradeRequestEntity);
        double current_balance = customerRepo.fetchBalance(loggedInUserDetails.getCurrentLoggedInUsername());
        if(current_balance<current_asset_rate*assetTradeRequestDTO.getQuantity())
            throw new Exception("Insufficient Balance");
        AssetBuyRequestEntity assetBuyRequestEntity=AssetBuyRequestEntity
                .newBuilder()
                .setAsset(assetTradeRequestDTO.getAsset())
                        .setCurrency(assetTradeRequestDTO.getCurrency())
                                .setWeightUnit(assetTradeRequestDTO.getWeightUnit())
                                        .setUsername(loggedInUserDetails.getCurrentLoggedInUsername())
                                                .setWeightGain(assetTradeRequestDTO.getQuantity())
                                                        .setAmountDeduct(current_asset_rate*assetTradeRequestDTO.getQuantity())
                                                                .build();

        handleBuyTrade(assetBuyRequestEntity);
        return null;
    }

    @Override
    @Transactional
    public void handleBuyTrade(AssetBuyRequestEntity assetBuyRequestEntity){

        //Decrease balance from customers.
        UpdateBalanceRequestEntity updateBalanceRequestEntity = UpdateBalanceRequestEntity
                .newBuilder()
                .setUsername(assetBuyRequestEntity.getUsername())
                .setBalance(assetBuyRequestEntity.getAmountDeduct())
                .build();

        customerRepo.updateBalance(updateBalanceRequestEntity);
        //Update user_details

        assetDetailsRepo.updateDetails(assetBuyRequestEntity);
    }

    @Override
    public AssetTradeResponseDTO handleSellService(AssetTradeRequestDTO assetTradeRequestDTO) throws Exception {
        LoggedInUserDetails loggedInUserDetails = new LoggedInUserDetails();
        AssetTradeRequestEntity assetTradeRequestEntity=AssetTradeRequestEntity.newBuilder().setAsset(assetTradeRequestDTO.getAsset()).setCurrency(assetTradeRequestDTO.getCurrency()).setWeightUnit(assetTradeRequestDTO.getWeightUnit()).build();
        double current_asset_rate = assetPricesRepo.fetchCurrentRate(assetTradeRequestEntity);
        double available_amount = assetDetailsRepo.fetchAvailableAssetQuantity(loggedInUserDetails.getCurrentLoggedInUsername(),assetTradeRequestDTO.getAsset());
        System.out.println(available_amount+" "+assetTradeRequestDTO.getQuantity());
        if(available_amount<assetTradeRequestDTO.getQuantity())
            throw new Exception("Insufficient Balance");
        AssetBuyRequestEntity assetBuyRequestEntity = AssetBuyRequestEntity.newBuilder().setAsset(assetTradeRequestDTO.getAsset()).setCurrency(assetTradeRequestDTO.getCurrency()).setWeightUnit(assetTradeRequestDTO.getWeightUnit()).setUsername(loggedInUserDetails.getCurrentLoggedInUsername()).setWeightGain(-1*assetTradeRequestDTO.getQuantity()).setAmountDeduct(-1*current_asset_rate*assetTradeRequestDTO.getQuantity()).build();
        handleSellTrade(assetBuyRequestEntity);
        return null;
    }

    @Override
    @Transactional
    public void handleSellTrade(AssetBuyRequestEntity assetBuyRequestEntity) {

        UpdateBalanceRequestEntity updateBalanceRequestEntity = UpdateBalanceRequestEntity
                .newBuilder()
                .setUsername(assetBuyRequestEntity.getUsername())
                .setBalance(assetBuyRequestEntity.getAmountDeduct())
                .build();

        customerRepo.updateBalance(updateBalanceRequestEntity);
        //Update user_details

        assetDetailsRepo.updateDetails(assetBuyRequestEntity);
    }
}

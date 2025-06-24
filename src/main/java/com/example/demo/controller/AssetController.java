package com.example.demo.controller;

import com.example.demo.Service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.protos.AssetTradeRequestDTO;
import com.example.demo.protos.AssetTradeResponseDTO;

@RestController
@RequestMapping("/assets")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @PatchMapping("/buy")
    public AssetTradeResponseDTO handleAssetBuy(@RequestBody AssetTradeRequestDTO assetTradeRequestDTO) throws Exception{

        if(!assetTradeRequestDTO.getAsset().equals("XAG") && !assetTradeRequestDTO.getAsset().equals("XAU"))
            throw new Exception("Invalid Asset Input");
        else if(!assetTradeRequestDTO.getCurrency().equals("INR") && !assetTradeRequestDTO.getCurrency().equals("PKR"))
            throw new Exception("Invalid Currency Input");
        else if(!assetTradeRequestDTO.getWeightUnit().equals("g") && !assetTradeRequestDTO.getWeightUnit().equals("kg"))
            throw new Exception("Invalid Weight_unit Input");
        else if(assetTradeRequestDTO.getQuantity()<=0)
            throw new Exception("Invalid Quantity Input");

        return assetService.handleBuyService(assetTradeRequestDTO);
    }

    @PatchMapping("/sell")
    public AssetTradeResponseDTO handleAssetSell(@RequestBody AssetTradeRequestDTO assetTradeRequestDTO) throws Exception{

        if(!assetTradeRequestDTO.getAsset().equals("XAG") && !assetTradeRequestDTO.getAsset().equals("XAU"))
            throw new Exception("Invalid Asset Input");
        else if(!assetTradeRequestDTO.getCurrency().equals("INR") && !assetTradeRequestDTO.getCurrency().equals("PKR"))
            throw new Exception("Invalid Currency Input");
        else if(!assetTradeRequestDTO.getWeightUnit().equals("g") && !assetTradeRequestDTO.getWeightUnit().equals("kg"))
            throw new Exception("Invalid Weight_unit Input");
        else if(assetTradeRequestDTO.getQuantity()<=0)
            throw new Exception("Invalid Quantity Input");

        return assetService.handleSellService(assetTradeRequestDTO);
    }

}

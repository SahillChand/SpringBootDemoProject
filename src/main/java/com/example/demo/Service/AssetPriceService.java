package com.example.demo.Service;

import com.example.demo.Dao.AssetPrices;
import com.example.demo.Dao.AssetPricesRepo;
import com.example.demo.Dao.Customer;
import com.example.demo.Dao.CustomerRepo;
import com.example.demo.Model.RealPrices;
import com.example.demo.Model.Trade;
import com.example.demo.Static.Statics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;

@Service
public class AssetPriceService {

    @Autowired
    private AssetPricesRepo assetPricesRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private Statics statics;

    @Autowired
    private RestTemplate restTemplate;

    public int updateAssetPrice(AssetPrices assetPrices) throws Exception{
        return assetPricesRepo.updateAssetPrice(assetPrices);
    }

    public void buyAsset(Trade trade) throws Exception{
        if(trade.getWeight_unit()!=null){
           Customer customer= customerRepo.getCustomer("Sahil");
           if(customer.getBalance()< trade.getAmount()*assetPricesRepo.getAssetPrice(trade.getAsset())){
               throw new Exception("Insufficient Balance");
           }
           else{
               customerRepo.updateBalance(new Customer("Sahil","",customer.getBalance()-trade.getAmount()*assetPricesRepo.getAssetPrice(trade.getAsset())));

           }
        }
        else{

        }
    }


    @Scheduled(fixedRate = 10000)
    public void updateCurrentPrice() throws Exception{
        String urlGold=statics.getCurrentGoldPriceUrl();
        String urlSilver=statics.getCurrentSilverPriceUrl();
        RealPrices responseGold= restTemplate.getForObject(urlGold, RealPrices.class);
        RealPrices responseSilver=restTemplate.getForObject(urlSilver,RealPrices.class);
        //System.out.println(responseGold);
        assetPricesRepo.updateAssetPrice(new AssetPrices("GOLD",responseGold.getAsk(),responseGold.getBid(),"g",new Timestamp(System.currentTimeMillis())));
        assetPricesRepo.updateAssetPrice(new AssetPrices("SILVER",responseSilver.getAsk(),responseSilver.getBid(),"g",new Timestamp(System.currentTimeMillis())));
    }
}

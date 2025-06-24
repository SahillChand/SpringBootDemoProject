package com.example.demo.schedule;

import com.example.demo.Dao.AssetPricesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import com.example.demo.Static.Statics;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.demo.Static.Assets;
import com.example.demo.Static.Currency;
import com.example.demo.Static.Weight_Unit;
import com.example.demo.utils.UrlBuilder;
import com.example.demo.Model.RealPricesRecord;

@Service
public class RegularUpdatePriceScheduler {

    @Autowired
    private Statics statics;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AssetPricesRepo assetPricesRepo;

    private UrlBuilder urlBuilder=new UrlBuilder();

    @Scheduled(fixedRate = 5000)
    public void updateCurrentPrice() throws Exception{
        for(Assets asset:Assets.values()){
            for(Currency currency:Currency.values()){
                for(Weight_Unit weightUnit:Weight_Unit.values()){
                    String url=urlBuilder.urlBuilder(asset.name(),currency.name(),weightUnit.name());
                    RealPricesRecord realPricesRecord = restTemplate.getForObject(url,RealPricesRecord.class);
                    assetPricesRepo.updateAssetPrice(realPricesRecord,asset.name(),currency.name(),weightUnit.name());
                }
            }
        }
    }
}

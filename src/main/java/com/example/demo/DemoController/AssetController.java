package com.example.demo.DemoController;

import com.example.demo.Dao.AssetPrices;
import com.example.demo.Service.AssetPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.proto.assets.AssetPricesProto;
import org.springframework.web.bind.annotation.*;
import com.google.protobuf.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
//import com.google.protobuf.util.Timestamps;

@RestController
@RequestMapping("/assets")
public class AssetController {

    @Autowired
    private AssetPriceService asService;

    @GetMapping("/getObject")
    public void getObject() {
        LocalDateTime localDateTime=LocalDateTime.now();
        AssetPricesProto temp = AssetPricesProto.newBuilder()
                .setAsset("GOLD")
                .setAsk(2)
                .setBid(3)
                .setWeightUnit("g")
                .setLastUpdated(convertLocalDateTimeToProtoTimeStamp(localDateTime))
                .build();
        System.out.println(temp);
    }

    public static Timestamp convertLocalDateTimeToProtoTimeStamp(LocalDateTime localDateTime) {
        Instant instant = localDateTime.toInstant(ZoneOffset.UTC);

        return Timestamp.newBuilder()
                .setSeconds(instant.getEpochSecond())
                .setNanos(instant.getNano())
                .build();
    }

    /*
    @PatchMapping("/buy")
    public void buyAsset(@RequestBody Trade trade){
        asService.
    }
    */
    @PutMapping("/updatePrice")
    public int updatePrice(@RequestBody AssetPrices assetPrices) throws Exception{
        return asService.updateAssetPrice(assetPrices);
    }

}

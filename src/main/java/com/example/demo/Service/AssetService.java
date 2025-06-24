package com.example.demo.Service;

import com.example.demo.protos.AssetBuyRequestEntity;
import com.example.demo.protos.AssetTradeRequestDTO;
import com.example.demo.protos.AssetTradeResponseDTO;

public interface AssetService {
    public AssetTradeResponseDTO handleBuyService(AssetTradeRequestDTO assetTradeRequestDTO) throws Exception;

    public void handleBuyTrade(AssetBuyRequestEntity assetBuyRequestEntity);

    public AssetTradeResponseDTO handleSellService(AssetTradeRequestDTO assetTradeRequestDTO) throws Exception;

    public void handleSellTrade(AssetBuyRequestEntity assetBuyRequestEntity);

}

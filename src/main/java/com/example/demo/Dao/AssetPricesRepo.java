package com.example.demo.Dao;

import java.sql.*;

import com.example.demo.Model.Trade;
import com.example.demo.Static.Statics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AssetPricesRepo {

    @Autowired
    private JdbcTemplate template;

    @Autowired
    private Statics statics;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    public Double getAssetPrice(String asset) throws Exception{
        String sql=statics.getAskValue();
        Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
        PreparedStatement preparedStatement =con.prepareStatement(sql);
        preparedStatement.setString(1,asset);
        ResultSet resultSet = preparedStatement.executeQuery();
        Double current_Ask_Value=0D;
        while(resultSet.next()){
            current_Ask_Value=resultSet.getDouble(1);
        }
        System.out.println(current_Ask_Value);
        return current_Ask_Value;
    }

    public int updateAssetPrice(AssetPrices assetPrices) throws Exception{
        String sql=statics.getUpdateAssetPrice();
        Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
        PreparedStatement preparedStatement =con.prepareStatement(sql);
        preparedStatement.setDouble(1,assetPrices.getAsk());
        preparedStatement.setDouble(2,assetPrices.getBid());
        preparedStatement.setTimestamp(3,new Timestamp(System.currentTimeMillis()));
        preparedStatement.setString(4,assetPrices.getAsset());
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public void buyAsset(Trade trade){

    }
}

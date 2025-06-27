package com.example.demo.Dao;

import java.sql.*;

import com.example.demo.Static.Statics;
import com.example.demo.Model.RealPricesRecord;
import com.example.demo.protos.AssetTradeRequestEntity;
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
        double current_Ask_Value=0D;
        while(resultSet.next()){
            current_Ask_Value=resultSet.getDouble(1);
        }
        preparedStatement.close();
        con.close();
        return current_Ask_Value;
    }

    public int updateAssetPrice(RealPricesRecord realPricesRecord, String asset, String currency, String weight_unit){
        String sql=statics.getUpdateAssetPrice();
        try {
            Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setDouble(1, realPricesRecord.getAsk());
            preparedStatement.setDouble(2, realPricesRecord.getBid());
            preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            if(asset.equals("XAU"))
                preparedStatement.setString(4, "GOLD");
            else if(asset.equals("XAG"))
                preparedStatement.setString(4, "SILVER");
            preparedStatement.setString(5, currency);
            preparedStatement.setString(6, weight_unit);
            int result = preparedStatement.executeUpdate();
            preparedStatement.close();
            con.close();
            return result;
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            return -1;
        }
    }

    public double fetchCurrentAskRate(AssetTradeRequestEntity assetTradeRequestEntity){
        String sql=statics.getFetchCurrentRateSQL();
        try {
            Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            if(assetTradeRequestEntity.getAsset().equals("XAU"))
                preparedStatement.setString(1,"GOLD");
            else if(assetTradeRequestEntity.getAsset().equals("XAG"))
                preparedStatement.setString(1,"SILVER");
            preparedStatement.setString(2,assetTradeRequestEntity.getCurrency());
            preparedStatement.setString(3,assetTradeRequestEntity.getWeightUnit());
            ResultSet resultSet = preparedStatement.executeQuery();
            double current_Ask_Value = 0D;
            while (resultSet.next()) {
                current_Ask_Value = resultSet.getDouble(1);
            }
            preparedStatement.close();
            con.close();
            return current_Ask_Value;
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            return 0;
        }
    }

    public double fetchCurrentBidRate(AssetTradeRequestEntity assetTradeRequestEntity){
        String sql=statics.getFetchCurrentBidRateSQL();
        try {
            Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            if(assetTradeRequestEntity.getAsset().equals("XAU"))
                preparedStatement.setString(1,"GOLD");
            else if(assetTradeRequestEntity.getAsset().equals("XAG"))
                preparedStatement.setString(1,"SILVER");
            preparedStatement.setString(2,assetTradeRequestEntity.getCurrency());
            preparedStatement.setString(3,assetTradeRequestEntity.getWeightUnit());
            ResultSet resultSet = preparedStatement.executeQuery();
            double current_Bid_Value = 0;
            while (resultSet.next()) {
                current_Bid_Value = resultSet.getDouble(1);
            }
            preparedStatement.close();
            con.close();
            return current_Bid_Value;
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            return 0;
        }
    }
}

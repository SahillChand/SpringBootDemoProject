package com.example.demo.Dao;

import com.example.demo.Static.Statics;
import com.example.demo.protos.AssetBuyRequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.demo.Static.Assets;

import java.sql.*;

@Repository
public class AssetDetailsRepo {

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

    public double fetchAvailableAssetQuantity(String username,String asset){
        String sql = statics.getFetchAvailableAssetQuantity();

        try{
            Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
            PreparedStatement preparedStatement =con.prepareStatement(sql);
            preparedStatement.setString(1,username);
            if(asset.equals("XAG"))
                preparedStatement.setString(2,"SILVER");
            else if(asset.equals("XAU"))
                preparedStatement.setString(2,"GOLD");
            ResultSet resultSet = preparedStatement.executeQuery();
            double current_asset_quantity=0D;
            while(resultSet.next()){
                current_asset_quantity=resultSet.getDouble(1);
            }
            return current_asset_quantity;
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            return -1;
        }
    }

    public void updateDetails(AssetBuyRequestEntity assetBuyRequestEntity){
        String sql = statics.getUpdateUserDetailsSQL();

        try{
            Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
            PreparedStatement preparedStatement =con.prepareStatement(sql);
            preparedStatement.setDouble(1,assetBuyRequestEntity.getWeightGain());
            preparedStatement.setDouble(2,assetBuyRequestEntity.getAmountDeduct());
            preparedStatement.setString(3,assetBuyRequestEntity.getUsername());
            if(assetBuyRequestEntity.getAsset().equals("XAG"))
                preparedStatement.setString(4,"SILVER");
            else if(assetBuyRequestEntity.getAsset().equals("XAU"))
                preparedStatement.setString(4,"GOLD");
            int rows_affected = preparedStatement.executeUpdate();
            System.out.println("Rows Affected:"+rows_affected);
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void addCustomerToAssetDetails(String username){
        String sql = statics.getAddCustomerToAssetDetails();

        try{
            Connection con = DriverManager.getConnection(url,dbUsername,dbPassword);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,username);
            for(Assets assets: Assets.values()){
                if(assets.name().equals("XAG"))
                    preparedStatement.setString(2,"SILVER");
                else if(assets.name().equals("XAU"))
                    preparedStatement.setString(2,"GOLD");
                preparedStatement.executeUpdate();
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}

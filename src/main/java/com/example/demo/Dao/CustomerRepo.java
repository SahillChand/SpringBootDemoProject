package com.example.demo.Dao;

import com.example.demo.Static.Statics;
import com.example.demo.protos.SignupRequestEntity;
import com.example.demo.protos.SignupResponseDTO;
import com.example.demo.protos.UpdateBalanceRequestDTO;
import com.example.demo.protos.UpdateBalanceRequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class CustomerRepo {

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

    public SignupRequestEntity fetchCustomer(String username){
        String sql= statics.getCustomers();

        try{
            Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            SignupRequestEntity signupRequestEntity=null;
            while (resultSet.next()) {
                signupRequestEntity=SignupRequestEntity.newBuilder()
                        .setUsername(resultSet.getString("username"))
                        .setPassword(resultSet.getString("password"))
                        .setBalance(resultSet.getDouble("balance"))
                        .build();
            }
            con.close();
            return signupRequestEntity;
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public double fetchBalance(String username){
        String sql= statics.getFetchBalanceSQL();

        try{
            Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            double current_balance=0D;
            while (resultSet.next()) {
                current_balance = resultSet.getDouble(1);
            }
            con.close();
            return current_balance;
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }

    public SignupResponseDTO addCustomer(SignupRequestEntity signupRequestEntity){

        String sql= statics.getAddCustomer();
        try{
            Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
            PreparedStatement preparedStatement =con.prepareStatement(sql);
            preparedStatement.setString(1,signupRequestEntity.getUsername());
            preparedStatement.setString(2,signupRequestEntity.getPassword());
            preparedStatement.setDouble(3,signupRequestEntity.getBalance());
            int rowsAffected = preparedStatement.executeUpdate();
            SignupResponseDTO signupResponseDTO=null;
            SignupRequestEntity current_Customer=fetchCustomer(signupRequestEntity.getUsername());
            signupResponseDTO=SignupResponseDTO.newBuilder().setUsername(current_Customer.getUsername()).setPassword(current_Customer.getPassword()).setBalance(current_Customer.getBalance()).setSuccessMessage("Customer Created Successfully").build();
            return signupResponseDTO;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int deleteCustomer(String username){
        String sql=statics.getDeleteCustomer();

        try {
            Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, username);
            int result = preparedStatement.executeUpdate();
            return result;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }

    public int updateBalance(UpdateBalanceRequestEntity updateBalanceRequestEntity){
        String sql=statics.getUpdateBalance();
        SignupRequestEntity patchCustomer=fetchCustomer(updateBalanceRequestEntity.getUsername());
        try {
            Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setDouble(1, updateBalanceRequestEntity.getBalance());
            preparedStatement.setString(2, updateBalanceRequestEntity.getUsername());
            int result = preparedStatement.executeUpdate();
            return result;
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
            return 0;
        }
    }

    public int updateCustomerBalance(UpdateBalanceRequestEntity updateBalanceRequestEntity){
        String sql=statics.getUpdateCustomerBalance();
        SignupRequestEntity patchCustomer=fetchCustomer(updateBalanceRequestEntity.getUsername());
        try {
            Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setDouble(1, updateBalanceRequestEntity.getBalance());
            preparedStatement.setString(2, updateBalanceRequestEntity.getUsername());
            int result = preparedStatement.executeUpdate();
            return result;
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
            return 0;
        }
    }

}

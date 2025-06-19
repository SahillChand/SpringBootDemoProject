package com.example.demo.Dao;

import com.example.demo.Static.Statics;
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

    public Customer getCustomer(String username) throws Exception{
        String sql= statics.getCustomers();

            Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
            PreparedStatement preparedStatement =con.prepareStatement(sql);
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer current_customer=new Customer();
            while(resultSet.next()){
                current_customer.setUsername(resultSet.getString(1));
                current_customer.setPassword(resultSet.getString(2));
                current_customer.setBalance(resultSet.getDouble(3));
            }
            con.close();
            if(current_customer.getUsername()==null){
                throw new Exception(username+" does not exist");
            }
            return current_customer;
    }

    public int addCustomer(Customer customer){
        String sql= statics.getAddCustomer();
        try{
            Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
            PreparedStatement preparedStatement =con.prepareStatement(sql);
            preparedStatement.setString(1,customer.getUsername());
            preparedStatement.setString(2,customer.getPassword());
            preparedStatement.setDouble(3,customer.getBalance());
            int result = preparedStatement.executeUpdate();
            return result;
        }
        catch (SQLException e) {
            System.out.println("Error Occurred");
            return 0;
        }
    }

    public int deleteCustomer(String username) throws Exception{
        String sql=statics.getDeleteCustomer();
        Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
        PreparedStatement preparedStatement =con.prepareStatement(sql);
        preparedStatement.setString(1,username);
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public int updateBalance(Customer customer) throws Exception{
        String sql=statics.getUpdateBalance();
        Customer patchCustomer=getCustomer(customer.getUsername());
        if(customer.getPassword()!=null)
            patchCustomer.setPassword(customer.getPassword());
        if(customer.getBalance()!=null)
            patchCustomer.setBalance(customer.getBalance());
        Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
        PreparedStatement preparedStatement =con.prepareStatement(sql);
        preparedStatement.setDouble(1,patchCustomer.getBalance());
        preparedStatement.setString(2,patchCustomer.getUsername());
        int result = preparedStatement.executeUpdate();
        return result;
    }
}

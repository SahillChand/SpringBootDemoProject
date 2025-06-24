package com.example.demo.Dao;

import com.example.demo.Static.Statics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class AuthoritiesRepo {

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

    public void addCustomerToAuthorities(String username){
        String sql = statics.getAddCustomerToAuthorities();

        try{
            Connection con = DriverManager.getConnection(url,dbUsername,dbPassword);
            PreparedStatement preparedStatement =con.prepareStatement(sql);
            preparedStatement.setString(1,username);
            int rows_Affected = preparedStatement.executeUpdate();
            System.out.println("Rows Affected"+rows_Affected);
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}

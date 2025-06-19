package com.example.demo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    @Autowired
    private JdbcTemplate template;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    public Student getStudent(int id){
        String sql="SELECT * FROM student WHERE id=?";
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement =con.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Student> list=new ArrayList<>();
            while(resultSet.next()){
                Student temp=new Student();
                temp.setId(resultSet.getInt(1));
                temp.setFirst_name(resultSet.getString(2));
                temp.setLast_name(resultSet.getString(3));
                temp.setEmail(resultSet.getString(4));
                list.add(temp);
                System.out.println(temp);
            }
            return list.getLast();
        } catch (SQLException e) {
            System.out.println("Error Occurred");
        }
        /*
        return template.queryForObject(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student temp=new Student();
                temp.setId(rs.getInt("id"));
                temp.setFirst_name(rs.getString("first_name"));
                temp.setLast_name(rs.getString("last_name"));
                temp.setEmail(rs.getString("email"));
                return temp;
            }
        }, id);
        */
        return new Student();
    }

    public int add(Student student){
        String sql="INSERT INTO Student VALUES (?,?,?,?)";

        //Student oldStudent=getStudent(student.getId());
        //System.out.println(student.getId());
        //if(oldStudent!=null){
        //    throw new invalidSQLException("Invalid SQL Query");
        //}
        int rows_affected=template.update(sql,student.getId(),student.getFirst_name(),student.getLast_name(),student.getEmail());
        return rows_affected;
    }

    public int update(Student student,int id){
        String updateStudentSQL="UPDATE Student SET id=?, first_name=?, last_name=?, email=? WHERE id=?";

        Student oldStudent=getStudent(id);

        return template.update(updateStudentSQL,student.getId(),student.getFirst_name(),student.getLast_name(),student.getEmail(),id);
    }

    public int modify(Student student,int id){
        return update(student,id);
    }

}

package com.sq018.crudservlet.dao;

import com.sq018.crudservlet.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/crudservletdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
        } catch(ClassNotFoundException e){
            System.out.println("ClassNotFoundException was caught :: " + e);
        } catch (SQLException e) {
            System.out.println("SQLException was caught :: " + e);
        }
        return con;
    }

    public static List<User> getAllUsers(){
        List<User> list = new ArrayList<>();

        try{
            Connection con= UserDAO.getConnection();

            PreparedStatement ps = con.prepareStatement("select * from user");

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setCountry(rs.getString(5));
                list.add(user);
            }
            con.close();
        } catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

}

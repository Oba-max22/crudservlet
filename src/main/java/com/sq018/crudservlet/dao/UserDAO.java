package com.sq018.crudservlet.dao;

import com.sq018.crudservlet.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UserDAO {

    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/crudservletdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","password");
        } catch(ClassNotFoundException e){
            System.out.println("ClassNotFoundException was caught :: " + e);
        } catch (SQLException e) {
            System.out.println("SQLException was caught :: " + e);
        }
        return con;
    }

    public static List<User> getAllUsers(){
        List<User> list = new ArrayList<>();

        try(Connection con= UserDAO.getConnection()){

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
            rs.close();
        } catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public static int saveUser(User user) throws SQLException {
        int status = 0;
        try (Connection con = UserDAO.getConnection()) {
            PreparedStatement ps = con.prepareStatement("insert into user (name,password,email,country) values (?,?,?,?)");

            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getCountry());

            status = ps.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public static User getUserByID(int id) throws SQLException {
        User user = new User();
        try (Connection con = UserDAO.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select * from user where id=?");
            ps.setInt(1, id);

            ResultSet rs  = ps.executeQuery();

            rs.next();

            user.setId(rs.getInt(1));
            user.setName(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setEmail(rs.getString(4));
            user.setCountry(rs.getString(5));

        } catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static int updateUser(User user) {
        int status = 0;

        try (Connection con = UserDAO.getConnection()) {
            PreparedStatement ps = con.prepareStatement("update user set name=?,password=?,email=?,country=? where id=?");
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getCountry());
            ps.setInt(5, user.getId());

            status = ps.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        }

        return status;
    }

    public static void deleteUser(int id) {

        try (Connection con = UserDAO.getConnection()) {
            PreparedStatement ps = con.prepareStatement("delete from user where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.daos;

import com.ecommerce.beans.User;
import com.ecommerce.utilities.DatabaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sallam
 */
public class DaoUser {

    DatabaseConnection connection;

    public void insertUser(User user) {
        try {
            connection = DatabaseConnection.getInstance();
            PreparedStatement ps = connection.getConnection()
                    .prepareStatement("insert into users values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setDate(4, (Date) user.getBirthDate());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getJob());
            ps.setString(7, user.getAddress());
            ps.setDouble(8, user.getCreditLimit());
            ps.setString(9, user.getProfileImage());
            ps.setString(10, user.getPhone());
            ps.setString(11, user.getPrivilege());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> usersList = new ArrayList<>();

        try {
            connection = DatabaseConnection.getInstance();
            Statement statement = connection.getConnection().createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
//            PreparedStatement ps = connection.getConnection()
//                    .prepareStatement("select * from admin.users");
//            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setBirthDate(rs.getDate("birth_date"));
                user.setPassword(rs.getString("password"));
                user.setJob(rs.getString("job"));
                user.setAddress(rs.getString("address"));
                user.setCreditLimit(rs.getDouble("credit_limit"));
//                user.setProfileImage(rs.getString("profile_image"));
                user.setPhone(rs.getString("phone"));
                user.setPrivilege(rs.getString("privilege"));
                usersList.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usersList;
    }

}
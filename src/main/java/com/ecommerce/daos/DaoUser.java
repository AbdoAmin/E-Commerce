/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.daos;

import com.ecommerce.beans.User;
import com.ecommerce.beans.UserLogin;
import com.ecommerce.utilities.DatabaseConnection;
import com.ecommerce.utilities.DatabaseHelper;
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

    public User signIn(UserLogin user) {
        User userSignIn = new User();

        try {
            connection = DatabaseConnection.getInstance();
            PreparedStatement ps = connection.getConnection()
                    .prepareStatement("SELECT * FROM USERS WHERE EMAIL= ? AND PASSWORD= ?");

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
//            boolean next = rs.next();
            if (rs.next()) {
                userSignIn.setUserId(rs.getInt(DatabaseHelper.USER.ID));
                userSignIn.setFirstName(rs.getString(DatabaseHelper.USER.FIRST_NAME));
                userSignIn.setLastName(rs.getString(DatabaseHelper.USER.LAST_NAME));
                userSignIn.setEmail(rs.getString("email"));
                userSignIn.setAddress(rs.getString("address"));
                userSignIn.setJob(rs.getString("job"));
                userSignIn.setBirthDate(rs.getDate("birth_date"));
                userSignIn.setJob(rs.getString("job"));
                userSignIn.setAddress(rs.getString("address"));
                userSignIn.setCreditLimit(rs.getDouble("credit_limit"));
//                user.setProfileImage(rs.getString("profile_image"));
                userSignIn.setPhone(rs.getString("phone"));
                userSignIn.setPrivilege(rs.getString("privilege"));
                
                PreparedStatement ps1 = connection.getConnection()
                    .prepareStatement("SELECT CATEGORY_ID FROM USER_INTERESTES WHERE USER_ID=?");
                
                ps1.setInt(1, userSignIn.getUserId());
                
                ResultSet interstsResultSet = ps1.executeQuery();
                
                ArrayList<Integer> interests = new ArrayList<>();
                while(interstsResultSet.next()){
                    interests.add(interstsResultSet.getInt("CATEGORY_ID"));
                }
                userSignIn.setInterests(interests);
            }
            connection.close();
            return userSignIn;

        } catch (SQLException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean signUp(User user) {
        try {
            connection = DatabaseConnection.getInstance();
            PreparedStatement ps = connection.getConnection()
                    .prepareStatement("insert into users values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

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
            int executeUpdate = ps.executeUpdate();

            connection.close();
            return executeUpdate >0;

        } catch (SQLException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    public ArrayList<User> getAllUsers() {
        
        ArrayList<User> usersList = new ArrayList<>();
        try {
            connection = DatabaseConnection.getInstance();
            Statement statement = connection.getConnection().createStatement();
            ResultSet rs = statement.executeQuery("select * from users");

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
                
                //add the category list.
                PreparedStatement ps1 = connection.getConnection()
                    .prepareStatement("SELECT CATEGORY_ID FROM USER_INTERESTES WHERE USER_ID=?");
                
                ps1.setInt(1, user.getUserId());
                
                ResultSet interstsResultSet = ps1.executeQuery();
                
                ArrayList<Integer> interests = new ArrayList<>();
                while(interstsResultSet.next()){
                    interests.add(interstsResultSet.getInt("CATEGORY_ID"));
                }
                user.setInterests(interests);
                usersList.add(user);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usersList;
    }
    
    //don't use it...under maintainence
    public int removeCategory(int userID, int categoryID) {
        //TODO
//        user.getInterests().remove(Integer.valueOf(categoryID_ToBeRemoved));
        int executeUpdate = 0;
        connection = DatabaseConnection.getInstance();
        try {
            PreparedStatement ps = connection.getConnection()
                    .prepareStatement("delete from USER_INTERESTES where USER_ID=? and CATEGORY_ID=?");
            
            ps.setInt(1, userID);
            ps.setInt(2, categoryID);
            
            executeUpdate= ps.executeUpdate();
            connection.close();
            return executeUpdate;
        } catch (SQLException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return executeUpdate;
    }
    
    public boolean updateUser(User user){
        try {
            connection = DatabaseConnection.getInstance();
            String sqlUsers = 
                    "update " + DatabaseHelper.USER.TABLE_NAME + " set "
                    + DatabaseHelper.USER.FIRST_NAME + " = ? " + " , "
                    + DatabaseHelper.USER.LAST_NAME + " = ? " + " , "
                    + DatabaseHelper.USER.EMAIL + " = ? " + " , "
                    + DatabaseHelper.USER.BIRTH_DATE + " = ? " + " , "
                    + DatabaseHelper.USER.JOB + " = ? " + " , "
                    + DatabaseHelper.USER.ADDRESS + " = ? " + " , "
                    + DatabaseHelper.USER.CREDIT_LIMIT + " = ? " + " , "
                    + DatabaseHelper.USER.PHONE + " = ? " + " , "
                    + DatabaseHelper.USER.PRIVILEGE + " = ? " 
                    + "where " + DatabaseHelper.USER.ID + " = ?";
            
            PreparedStatement ps2 = connection.getConnection().prepareStatement(sqlUsers);
            
            ps2.setString(1, user.getFirstName());
            ps2.setString(2, user.getLastName());
            ps2.setString(3, user.getEmail());
            ps2.setDate(4, (Date)user.getBirthDate());
            ps2.setString(5, user.getJob());
            ps2.setString(6, user.getAddress());
            ps2.setDouble(7, user.getCreditLimit());
            ps2.setString(8, user.getPhone());
            ps2.setString(9, user.getPrivilege());
            ps2.setInt(10, user.getUserId());
            int executeUpdate2 = ps2.executeUpdate();
 
            //delete all old interests, then put the new ones.
            String sqlDelete = "delete from " + DatabaseHelper.USER_INTERESTS.TABLE_NAME 
                    + " where " + DatabaseHelper.USER.ID + " =?";
            
            PreparedStatement ps = connection.getConnection().prepareStatement(sqlDelete);
            ps.setInt(1, user.getUserId());
            
            int executeUpdate = ps.executeUpdate();
            
            String sqlInsertInterests = "insert into " + DatabaseHelper.USER_INTERESTS.TABLE_NAME 
                    + " ("+ DatabaseHelper.USER_INTERESTS.USER_ID + ", "+ DatabaseHelper.USER_INTERESTS.CATEGORY_ID
                    + ")" +" values(?, ?)";
            for(Integer i : user.getInterests()){
                PreparedStatement ps3 = connection.getConnection().prepareStatement(sqlInsertInterests);
                ps3.setInt(1, user.getUserId());
                ps3.setInt(2, i);
                
                ps3.executeUpdate();
            }
            connection.close();
            return ((executeUpdate2 > 0) && (executeUpdate > 0));
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public User getUserByEmail(String email){
        
        try {
            connection = DatabaseConnection.getInstance();
            PreparedStatement ps = connection.getConnection()
                    .prepareStatement("SELECT * FROM USERS WHERE EMAIL= ?");
            
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            User user = new User();

            if(rs.next()){
                
                user.setUserId(rs.getInt(DatabaseHelper.USER.ID));
                user.setFirstName(rs.getString(DatabaseHelper.USER.FIRST_NAME));
                user.setLastName(rs.getString(DatabaseHelper.USER.LAST_NAME));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setJob(rs.getString("job"));
                user.setBirthDate(rs.getDate("birth_date"));
                user.setJob(rs.getString("job"));
                user.setAddress(rs.getString("address"));
                user.setCreditLimit(rs.getDouble("credit_limit"));
//                user.setProfileImage(rs.getString("profile_image"));
                user.setPhone(rs.getString("phone"));
                user.setPrivilege(rs.getString("privilege"));
                
                PreparedStatement ps1 = connection.getConnection()
                    .prepareStatement("SELECT CATEGORY_ID FROM USER_INTERESTES WHERE USER_ID=?");
                
                ps1.setInt(1, user.getUserId());
                
                ResultSet interstsResultSet = ps1.executeQuery();
                
                ArrayList<Integer> interests = new ArrayList<>();
                while(interstsResultSet.next()){
                    interests.add(interstsResultSet.getInt("CATEGORY_ID"));
                }
                user.setInterests(interests);
            }
            connection.close();
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

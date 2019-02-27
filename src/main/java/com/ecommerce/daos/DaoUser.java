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
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sallam
 */
public class DaoUser {

    DatabaseConnection connection;

    public int getLastUserId() {
        int userId = -1;
        try {

            connection = DatabaseConnection.getInstance();
            Statement statement = connection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select " + DatabaseHelper.USER.ID
                    + " from  " + DatabaseHelper.USER.TABLE_NAME
                    + " where " + DatabaseHelper.USER.ID
                    + " = "
                    + " ( select max ( " + DatabaseHelper.USER.ID + " )"
                    + " from " + DatabaseHelper.USER.TABLE_NAME + " )");
            if (resultSet.next()) {
                userId = resultSet.getInt(DatabaseHelper.USER.ID);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userId;
    }

    public User signIn(UserLogin user) {
        User userSignIn = null;

        try {
            String sql = "SELECT * FROM " + DatabaseHelper.USER.TABLE_NAME
                    + " WHERE " + DatabaseHelper.USER.EMAIL + " = ? AND " + DatabaseHelper.USER.PASSWORD + " = ?";
            connection = DatabaseConnection.getInstance();
            PreparedStatement ps = connection.getConnection()
                    .prepareStatement(sql);

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                userSignIn = new User();
                userSignIn.setUserId(rs.getInt(DatabaseHelper.USER.ID));
                userSignIn.setFirstName(rs.getString(DatabaseHelper.USER.FIRST_NAME));
                userSignIn.setLastName(rs.getString(DatabaseHelper.USER.LAST_NAME));
                userSignIn.setEmail(rs.getString(DatabaseHelper.USER.EMAIL));
                userSignIn.setAddress(rs.getString(DatabaseHelper.USER.ADDRESS));
                userSignIn.setJob(rs.getString(DatabaseHelper.USER.JOB));
                userSignIn.setBirthDate(rs.getString(DatabaseHelper.USER.BIRTH_DATE));
                userSignIn.setCreditLimit(rs.getDouble(DatabaseHelper.USER.CREDIT_LIMIT));
                userSignIn.setProfileImage(Base64.getEncoder().encodeToString(
                        rs.getBytes(DatabaseHelper.USER.PROFILE_IMAGE)));
                userSignIn.setPhone(rs.getString(DatabaseHelper.USER.PHONE));
                userSignIn.setPrivilege(rs.getString(DatabaseHelper.USER.PRIVILEGE));

                PreparedStatement ps1 = connection.getConnection()
                        .prepareStatement(
                                "SELECT CATEGORY_ID FROM USER_INTERESTES "
                                + "WHERE " + DatabaseHelper.USER.ID + " = ?");
                ps1.setInt(1, userSignIn.getUserId());

                ResultSet interstsResultSet = ps1.executeQuery();

                ArrayList<Integer> interests = new ArrayList<>();
                while (interstsResultSet.next()) {
                    interests.add(interstsResultSet.getInt(
                            DatabaseHelper.USER_INTERESTS.CATEGORY_ID));
                }
                userSignIn.setInterests(interests);
            }
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userSignIn;
    }

    public boolean signUp(User user, InputStream inputStream, int size) {
        try {
            connection = DatabaseConnection.getInstance();
            PreparedStatement ps = connection.getConnection()
                    .prepareStatement("insert into " + DatabaseHelper.USER.TABLE_NAME + " ( "
                            + DatabaseHelper.USER.FIRST_NAME + " , "
                            + DatabaseHelper.USER.LAST_NAME + " , "
                            + DatabaseHelper.USER.EMAIL + " , "
                            + DatabaseHelper.USER.BIRTH_DATE + " , "
                            + DatabaseHelper.USER.PASSWORD + " , "
                            + DatabaseHelper.USER.JOB + " , "
                            + DatabaseHelper.USER.ADDRESS + " , "
                            + DatabaseHelper.USER.CREDIT_LIMIT + " , "
                            + DatabaseHelper.USER.PROFILE_IMAGE + " , "
                            + DatabaseHelper.USER.PHONE + " , "
                            + DatabaseHelper.USER.PRIVILEGE + " ) "
                            + " VALUES"
                            + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getBirthDate());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getJob());
            ps.setString(7, user.getAddress());
            ps.setDouble(8, user.getCreditLimit());
            ps.setBinaryStream(9, inputStream, size);

            ps.setString(10, user.getPhone());
            ps.setString(11, user.getPrivilege());
            int executeUpdate = ps.executeUpdate();

            connection.close();
            return executeUpdate > 0;

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
                user.setBirthDate(rs.getString("birth_date"));
                user.setPassword(rs.getString("password"));
                user.setJob(rs.getString("job"));
                user.setAddress(rs.getString("address"));
                user.setCreditLimit(rs.getDouble("credit_limit"));
                user.setProfileImage(Base64.getEncoder().encodeToString(
                        rs.getBytes(DatabaseHelper.USER.PROFILE_IMAGE)));
                user.setPhone(rs.getString("phone"));
                user.setPrivilege(rs.getString("privilege"));

                //add the category list.
                PreparedStatement ps1 = connection.getConnection()
                        .prepareStatement("SELECT CATEGORY_ID FROM USER_INTERESTES WHERE USER_ID=?");

                ps1.setInt(1, user.getUserId());

                ResultSet interstsResultSet = ps1.executeQuery();

                ArrayList<Integer> interests = new ArrayList<>();
                while (interstsResultSet.next()) {
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

            executeUpdate = ps.executeUpdate();
            connection.close();
            return executeUpdate;
        } catch (SQLException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return executeUpdate;
    }

    public boolean updateUser(User user, InputStream inputStream, int size) {
        try {
            connection = DatabaseConnection.getInstance();
            String sqlUsers
                    = "update " + DatabaseHelper.USER.TABLE_NAME + " set "
                    + DatabaseHelper.USER.FIRST_NAME + " = ? " + " , "
                    + DatabaseHelper.USER.LAST_NAME + " = ? " + " , "
                    + DatabaseHelper.USER.EMAIL + " = ? " + " , "
                    + DatabaseHelper.USER.BIRTH_DATE + " = ? " + " , "
                    + DatabaseHelper.USER.JOB + " = ? " + " , "
                    + DatabaseHelper.USER.ADDRESS + " = ? " + " , "
                    + DatabaseHelper.USER.CREDIT_LIMIT + " = ? " + " , "
                    + DatabaseHelper.USER.PROFILE_IMAGE + " = ? " + " , "
                    + DatabaseHelper.USER.PHONE + " = ? " + " , "
                    + DatabaseHelper.USER.PRIVILEGE + " = ? "
                    + "where " + DatabaseHelper.USER.ID + " = ?";

            PreparedStatement ps2 = connection.getConnection().prepareStatement(sqlUsers);

            ps2.setString(1, user.getFirstName());
            ps2.setString(2, user.getLastName());
            ps2.setString(3, user.getEmail());
            ps2.setString(4, user.getBirthDate());
            ps2.setString(5, user.getJob());
            ps2.setString(6, user.getAddress());
            ps2.setDouble(7, user.getCreditLimit());
            ps2.setBinaryStream(8, inputStream, size);
            ps2.setString(9, user.getPhone());
            ps2.setString(10, user.getPrivilege());
            ps2.setInt(11, user.getUserId());
            int executeUpdate2 = ps2.executeUpdate();

            //delete all old interests, then put the new ones.
            String sqlDelete = "delete from " + DatabaseHelper.USER_INTERESTS.TABLE_NAME
                    + " where " + DatabaseHelper.USER.ID + " =?";

            PreparedStatement ps = connection.getConnection().prepareStatement(sqlDelete);
            ps.setInt(1, user.getUserId());

            int executeUpdate = ps.executeUpdate();

            String sqlInsertInterests = "insert into " + DatabaseHelper.USER_INTERESTS.TABLE_NAME
                    + " (" + DatabaseHelper.USER_INTERESTS.USER_ID + ", " + DatabaseHelper.USER_INTERESTS.CATEGORY_ID
                    + ")" + " values(?, ?)";
            for (Integer i : user.getInterests()) {
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

    public User getUserByEmail(String email) {

        try {
            connection = DatabaseConnection.getInstance();
            PreparedStatement ps = connection.getConnection()
                    .prepareStatement("SELECT * FROM USERS WHERE EMAIL= ?");

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            User user = new User();

            if (rs.next()) {
                user.setUserId(rs.getInt(DatabaseHelper.USER.ID));
                user.setFirstName(rs.getString(DatabaseHelper.USER.FIRST_NAME));
                user.setLastName(rs.getString(DatabaseHelper.USER.LAST_NAME));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setJob(rs.getString("job"));
                user.setBirthDate(rs.getString("birth_date"));
                user.setJob(rs.getString("job"));
                user.setAddress(rs.getString("address"));
                user.setCreditLimit(rs.getDouble("credit_limit"));
                user.setProfileImage(Base64.getEncoder().encodeToString(
                        rs.getBytes(DatabaseHelper.USER.PROFILE_IMAGE)));
                user.setPhone(rs.getString("phone"));
                user.setPrivilege(rs.getString("privilege"));

                PreparedStatement ps1 = connection.getConnection()
                        .prepareStatement("SELECT CATEGORY_ID FROM USER_INTERESTES WHERE USER_ID=?");

                ps1.setInt(1, user.getUserId());

                ResultSet interstsResultSet = ps1.executeQuery();

                ArrayList<Integer> interests = new ArrayList<>();
                while (interstsResultSet.next()) {
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

    public boolean updateUserCreditLimit(int userId, double moneyPaid) {
        try {
            connection = DatabaseConnection.getInstance();
            String sqlUsers
                    = "update " + DatabaseHelper.USER.TABLE_NAME + " set "
                    + DatabaseHelper.USER.CREDIT_LIMIT + " = " + DatabaseHelper.USER.CREDIT_LIMIT + " -? "
                    + "where " + DatabaseHelper.USER.ID + " = ?";

            PreparedStatement ps2 = connection.getConnection().prepareStatement(sqlUsers);

            ps2.setDouble(1, moneyPaid);
            ps2.setInt(2, userId);
            int executeUpdate2 = ps2.executeUpdate();
            connection.close();
            return ((executeUpdate2 > 0));

        } catch (SQLException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}

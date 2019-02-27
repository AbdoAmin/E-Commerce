/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.daos;

import com.ecommerce.utilities.DatabaseConnection;
import com.ecommerce.utilities.DatabaseHelper;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdo Amin
 */
public class DaoProductImages {

    DatabaseConnection dataBaseConnection;

    public DaoProductImages(DatabaseConnection dataBaseConnection) {
        this.dataBaseConnection = dataBaseConnection;
    }

    public DaoProductImages() {
    }

    public List<String> getProductImages(int productId) {
        List<String> products = new ArrayList<>();
        try {
            Connection connection = dataBaseConnection.getConnection();
            String sql
                    = "SELECT " + DatabaseHelper.ProductImages.IMAGE + " FROM "
                    + DatabaseHelper.ProductImages.TABLE_NAME
                    + " where " + DatabaseHelper.ProductImages.PRODUCT_ID + " = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products.add(
                        Base64.getEncoder().encodeToString(
                                resultSet.getBytes(DatabaseHelper.ProductImages.IMAGE)));
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoProductImages.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public boolean deleteProductImage(int productImageId) {
        try {
            Connection connection = dataBaseConnection.getConnection();
            String sql
                    = "DELETE From "
                    + DatabaseHelper.ProductImages.TABLE_NAME
                    + " where " + DatabaseHelper.ProductImages.ID + " = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, productImageId);
            boolean value = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            dataBaseConnection.close();
            return value;
        } catch (SQLException ex) {
            Logger.getLogger(DaoProductImages.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteProductImages(int productId) {
        try {
            DatabaseConnection dc = DatabaseConnection.getInstance();
            Connection connection = dc.getConnection();
            String sql
                    = "DELETE FROM "
                    + DatabaseHelper.ProductImages.TABLE_NAME
                    + " where " + DatabaseHelper.ProductImages.PRODUCT_ID + " = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, productId);
            
            boolean execute = preparedStatement.executeUpdate() >0;
            preparedStatement.close();
            dc.close();
            return execute;
        } catch (SQLException ex) {
            Logger.getLogger(DaoProductImages.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean insertProductImage(int productId, InputStream inputStream, int size) {
        try {
            DatabaseConnection dataBaseConnection = DatabaseConnection.getInstance();
            Connection connection = dataBaseConnection.getConnection();
            String sql
                    = "INSERT INTO "
                    + DatabaseHelper.ProductImages.TABLE_NAME
                    + " (" + DatabaseHelper.ProductImages.PRODUCT_ID + "," + DatabaseHelper.ProductImages.IMAGE + ") "
                    + "VALUES( ? , ? )";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, productId);
            preparedStatement.setBinaryStream(2, inputStream, size);
            boolean a=preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            dataBaseConnection.close();
            return a;
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoProductImages.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateProductImage(int productImageId, InputStream inputStream, int size) {
        try {
            Connection connection = dataBaseConnection.getConnection();
            String sql
                    = "UPDATE "
                    + DatabaseHelper.ProductImages.TABLE_NAME
                    + " SET " + DatabaseHelper.ProductImages.IMAGE + " = ?"
                    + " WHERE " + DatabaseHelper.ProductImages.ID + " = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBinaryStream(1, inputStream, size);
            preparedStatement.setInt(2, productImageId);
            boolean value = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            dataBaseConnection.close();
            return value;
        } catch (SQLException ex) {
            Logger.getLogger(DaoProductImages.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}

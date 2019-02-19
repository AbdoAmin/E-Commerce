/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.daos;

import com.ecommerce.utilities.DatabaseConnection;
import com.ecommerce.utilities.DatabaseHelper;
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
        } catch (SQLException ex) {
            Logger.getLogger(DaoProductImages.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

}

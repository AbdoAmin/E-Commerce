/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.daos;

import com.ecommerce.beans.Product;
import com.ecommerce.utilities.DataBaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ashraf_R
 */
public class DaoProduct {

    Connection connection;

    public DaoProduct() {
        DataBaseConnection dataBaseConnection = DataBaseConnection.getInstance();
        connection = dataBaseConnection.getConnection();
        System.out.println("connection is done");
    }

    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCTS");
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getInt("PRODUCT_ID"));
                product.setName(resultSet.getString("PRODUCT_NAME"));
                product.setPrice(resultSet.getInt("PRICE"));
                product.setDiscount(resultSet.getDouble("DISCOUNT"));
                product.setCategoryId(resultSet.getInt("CATEGORY_ID"));
                product.setQuantity(resultSet.getInt("QUANTITY"));
                products.add(product);
            }
        } catch (SQLException ex) {
            System.out.println("jmdf,.gsk/sdkfj");
            Logger.getLogger(DaoProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }
}

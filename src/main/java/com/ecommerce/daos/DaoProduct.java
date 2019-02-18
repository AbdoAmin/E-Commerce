/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.daos;

import com.ecommerce.beans.Product;
import com.ecommerce.utilities.DatabaseConnection;
import com.ecommerce.utilities.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        try {
            DatabaseConnection dataBaseConnection = DatabaseConnection.getInstance();
            Connection connection = dataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCTS");
            setOnList(resultSet, products, dataBaseConnection);
            dataBaseConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public List<Product> getProducts(int categoryId) {
        List<Product> products = new ArrayList<>();
        try {
            DatabaseConnection dataBaseConnection = DatabaseConnection.getInstance();
            Connection connection = dataBaseConnection.getConnection();
            String sql
                    = "SELECT * FROM " + DatabaseHelper.PRODUCT.TABLE_NAME
                    + " where " + DatabaseHelper.PRODUCT.CATEGORY_ID + " = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, categoryId);
            setOnList(preparedStatement.executeQuery(), products, dataBaseConnection);
            dataBaseConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public List<Product> getProducts(String productName) {
        List<Product> products = new ArrayList<>();
        try {
            DatabaseConnection dataBaseConnection = DatabaseConnection.getInstance();
            Connection connection = dataBaseConnection.getConnection();
            String sql
                    = "SELECT * FROM " + DatabaseHelper.PRODUCT.TABLE_NAME
                    + "where " + DatabaseHelper.PRODUCT.NAME + " = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + productName + "%");
            setOnList(preparedStatement.executeQuery(), products, dataBaseConnection);
            dataBaseConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    private void setOnList(ResultSet resultSet, List<Product> products, DatabaseConnection dataBaseConnection) {
        try {
            while (resultSet.next()) {
                Product product = new Product();
                int productId = resultSet.getInt("PRODUCT_ID");
                product.setProductId(productId);
                product.setName(resultSet.getString("PRODUCT_NAME"));
                product.setPrice(resultSet.getInt("PRICE"));
                product.setDiscount(resultSet.getDouble("DISCOUNT"));
                product.setCategoryId(resultSet.getInt("CATEGORY_ID"));
                product.setQuantity(resultSet.getInt("QUANTITY"));
                /**
                 * Get all Product Images converted into String
                 * @para dataBaseConnection for pass the same Object
                 */
                product.setProductImages(
                        new DaoProductImages(dataBaseConnection)
                                .getProductImages(productId));
                products.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int addProduct(Product product) {
        int rowEffect = 0;
        try {
            DatabaseConnection dataBaseConnection = DatabaseConnection.getInstance();
            Connection connection = dataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql
                    = "INSERT INTO " + DatabaseHelper.PRODUCT.TABLE_NAME
                    + " ( " + DatabaseHelper.PRODUCT.NAME + ", "
                    + DatabaseHelper.PRODUCT.PRICE + ", "
                    + DatabaseHelper.PRODUCT.DISCOUNT + ", "
                    + DatabaseHelper.PRODUCT.QUANTITY + ", "
                    + DatabaseHelper.PRODUCT.CATEGORY_ID + ")"
                    + " VALUES"
                    + " ('" + product.getName() + "',"
                    + product.getPrice() + ","
                    + product.getDiscount() + ","
                    + product.getQuantity() + ","
                    + product.getCategoryId() + ")";
            rowEffect = statement.executeUpdate(sql);
            dataBaseConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowEffect;
    }

    public int updateProduct(Product product) {
        int rowEffect = 0;
        try {
            DatabaseConnection dataBaseConnection = DatabaseConnection.getInstance();
            Connection connection = dataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql
                    = "update INTO " + DatabaseHelper.PRODUCT.TABLE_NAME
                    + " ( " + DatabaseHelper.PRODUCT.NAME + ", "
                    + DatabaseHelper.PRODUCT.PRICE + ", "
                    + DatabaseHelper.PRODUCT.DISCOUNT + ", "
                    + DatabaseHelper.PRODUCT.QUANTITY + ", "
                    + DatabaseHelper.PRODUCT.CATEGORY_ID + ")"
                    + " VALUES"
                    + " ('" + product.getName() + "',"
                    + product.getPrice() + ","
                    + product.getDiscount() + ","
                    + product.getQuantity() + ","
                    + product.getCategoryId() + ")";
            rowEffect = statement.executeUpdate(sql);
            dataBaseConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowEffect;
    }
}

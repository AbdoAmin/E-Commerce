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
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM " + DatabaseHelper.PRODUCT.TABLE_NAME
                    + " WHERE "
                    + DatabaseHelper.PRODUCT.QUANTITY + " != 0 "
                    + " ORDER BY " + DatabaseHelper.PRODUCT.DISCOUNT + " DESC");
            setOnList(resultSet, products, dataBaseConnection);
            dataBaseConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public List<Product> getAllProductWithDiscount() {
        List<Product> products = new ArrayList<>();
        try {
            DatabaseConnection dataBaseConnection = DatabaseConnection.getInstance();
            Connection connection = dataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCTS"
                    + " WHERE "
                    + DatabaseHelper.PRODUCT.DISCOUNT + " > 0 "
                    + " AND "
                    + DatabaseHelper.PRODUCT.QUANTITY + "!= 0 "
                    + " ORDER BY " + DatabaseHelper.PRODUCT.DISCOUNT + " DESC ");
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
                    + " where " + DatabaseHelper.PRODUCT.CATEGORY_ID + " = ? "
                    + " AND "
                    + DatabaseHelper.PRODUCT.QUANTITY + "!= 0 "
                    + "ORDER BY " + DatabaseHelper.PRODUCT.DISCOUNT + " DESC ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, categoryId);
            setOnList(preparedStatement.executeQuery(), products, dataBaseConnection);
            dataBaseConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public List<Product> getProducts(int categoryId, String productName) {
        List<Product> products = new ArrayList<>();
        try {
            DatabaseConnection dataBaseConnection = DatabaseConnection.getInstance();
            Connection connection = dataBaseConnection.getConnection();
            String sql
                    = "SELECT * FROM " + DatabaseHelper.PRODUCT.TABLE_NAME
                    + " where " + DatabaseHelper.PRODUCT.CATEGORY_ID + " = ? "
                    + " AND UPPER( "
                    + DatabaseHelper.PRODUCT.NAME + " ) LIKE ? "
                    + " AND "
                    + DatabaseHelper.PRODUCT.QUANTITY + "!= 0 "
                    + "ORDER BY " + DatabaseHelper.PRODUCT.DISCOUNT + " DESC ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, categoryId);
            preparedStatement.setString(2, "%" + productName + "%");
            setOnList(preparedStatement.executeQuery(), products, dataBaseConnection);
            dataBaseConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public List<Product> getProductsOfInterest(int userId) {
        List<Product> products = new ArrayList<>();
        try {
            DatabaseConnection dataBaseConnection = DatabaseConnection.getInstance();
            Connection connection = dataBaseConnection.getConnection();
            String sql
                    = "SELECT * FROM " + DatabaseHelper.PRODUCT.TABLE_NAME
                    + " , " + DatabaseHelper.USER_INTERESTS.TABLE_NAME
                    + " where " + DatabaseHelper.PRODUCT.TABLE_NAME + "."
                    + DatabaseHelper.PRODUCT.CATEGORY_ID + " = "
                    + DatabaseHelper.USER_INTERESTS.TABLE_NAME + "."
                    + DatabaseHelper.USER_INTERESTS.CATEGORY_ID
                    + " AND "
                    + DatabaseHelper.USER_INTERESTS.USER_ID + " = ? "
                    + " AND "
                    + DatabaseHelper.PRODUCT.QUANTITY + "!= 0 "
                    + "ORDER BY " + DatabaseHelper.PRODUCT.DISCOUNT + " DESC ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
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
                    + " where UPPER( "
                    + DatabaseHelper.PRODUCT.NAME + " ) LIKE ? "
                    + " AND "
                    + DatabaseHelper.PRODUCT.QUANTITY + "!= 0 "
                    + "ORDER BY " + DatabaseHelper.PRODUCT.DISCOUNT + " DESC ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + productName + "%");
            setOnList(preparedStatement.executeQuery(), products, dataBaseConnection);
            dataBaseConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public Product getProduct(int productId) {
        List<Product> products = new ArrayList<>();
        try {
            DatabaseConnection dataBaseConnection = DatabaseConnection.getInstance();
            Connection connection = dataBaseConnection.getConnection();
            String sql
                    = "SELECT * FROM " + DatabaseHelper.PRODUCT.TABLE_NAME
                    + " where " + DatabaseHelper.PRODUCT.ID + " = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, productId);
            setOnList(preparedStatement.executeQuery(), products, dataBaseConnection);
            dataBaseConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products.get(0);
    }

    private void setOnList(ResultSet resultSet, List<Product> products, DatabaseConnection dataBaseConnection) {
        try {
            while (resultSet.next()) {
                Product product = new Product();
                int productId = resultSet.getInt(DatabaseHelper.PRODUCT.ID);
                product.setId(productId);
                product.setName(resultSet.getString(DatabaseHelper.PRODUCT.NAME));
                product.setPrice(resultSet.getInt(DatabaseHelper.PRODUCT.PRICE));
                product.setDiscount(resultSet.getDouble(DatabaseHelper.PRODUCT.DISCOUNT));
                product.setCategoryId(resultSet.getInt(DatabaseHelper.PRODUCT.CATEGORY_ID));
                product.setQuantity(resultSet.getInt(DatabaseHelper.PRODUCT.QUANTITY));
                product.setDescription(resultSet.getString(DatabaseHelper.PRODUCT.DESCRIPTION));
                /**
                 * Get all Product Images converted into String
                 *
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
        int productId = -1;
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
                    + DatabaseHelper.PRODUCT.CATEGORY_ID + ", "
                    + DatabaseHelper.PRODUCT.DESCRIPTION + ")"
                    + " VALUES"
                    + " ('" + product.getName() + "','"
                    + product.getPrice() + "','"
                    + product.getDiscount() + "','"
                    + product.getQuantity() + "','"
                    + product.getCategoryId() + "','"
                    + product.getDescription() + "')";
            int executeUpdate = statement.executeUpdate(sql);
            dataBaseConnection.close();
            if (executeUpdate > 0) {
                productId = getLastProductAdded();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productId;
    }

    private int getLastProductAdded() {
        int productId = -1;
        try {
            DatabaseConnection dataBaseConnection = DatabaseConnection.getInstance();
            Connection connection = dataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select " + DatabaseHelper.PRODUCT.ID
                    + " from " + DatabaseHelper.PRODUCT.TABLE_NAME
                    + " where " + DatabaseHelper.PRODUCT.ID
                    + " = "
                    + " ( select max ( " + DatabaseHelper.PRODUCT.ID + " )"
                    + " from " + DatabaseHelper.PRODUCT.TABLE_NAME + ")");
            if (resultSet.next()) {
                productId = resultSet.getInt(DatabaseHelper.PRODUCT.ID);
            }
            dataBaseConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productId;
    }

    public int updateProduct(Product product) {
        int rowEffect = 0;
        try {
            DatabaseConnection dataBaseConnection = DatabaseConnection.getInstance();
            Connection connection = dataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql
                    = "UPDATE " + DatabaseHelper.PRODUCT.TABLE_NAME
                    + " SET "
                    + DatabaseHelper.PRODUCT.NAME + " = '" + product.getName() + "' , "
                    + DatabaseHelper.PRODUCT.PRICE + " = " + product.getPrice() + " , "
                    + DatabaseHelper.PRODUCT.DISCOUNT + " = " + product.getDiscount() + " , "
                    + DatabaseHelper.PRODUCT.QUANTITY + " = " + product.getQuantity() + " , "
                    + DatabaseHelper.PRODUCT.DESCRIPTION + " = '" + product.getDescription() + "' , "
                    + DatabaseHelper.PRODUCT.CATEGORY_ID + " = " + product.getCategoryId()
                    + " WHERE " + DatabaseHelper.PRODUCT.ID + " = " + product.getId();
            rowEffect = statement.executeUpdate(sql);
            dataBaseConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowEffect;
    }

    public int setProductQuantity(int productId, int productQuantity) {
        int rowEffect = 0;
        try {
            DatabaseConnection dataBaseConnection = DatabaseConnection.getInstance();
            Connection connection = dataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql
                    = "UPDATE "
                    + DatabaseHelper.PRODUCT.TABLE_NAME
                    + " SET "
                    + DatabaseHelper.PRODUCT.QUANTITY + " = "
                    + productQuantity
                    + " where "
                    + DatabaseHelper.PRODUCT.ID + " = " + productId;
            rowEffect = statement.executeUpdate(sql);
            dataBaseConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowEffect;
    }
}

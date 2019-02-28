/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.daos;

import com.ecommerce.beans.Category;
import com.ecommerce.utilities.DatabaseConnection;
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
 * @author Abdo Amin
 */
public class DAOCategories {

    DatabaseConnection databaseConnection;

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        databaseConnection = DatabaseConnection.getInstance();
        try {
            Statement s = databaseConnection.getConnection().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Categories");
            while (rs.next()) {
                categories.add(new Category(rs.getInt("CATEGORY_ID"), rs.getString("CATEGORY_NAME")));
            }
            databaseConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }

    public boolean insertCategory(String categoryName) {
        databaseConnection = DatabaseConnection.getInstance();
        try {
            PreparedStatement s = databaseConnection.getConnection()
                    .prepareStatement("INSERT INTO Categories (CATEGORY_NAME) VALUES(?)");
            s.setString(1, categoryName);
            int result = s.executeUpdate();
            databaseConnection.close();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateCategory(Category category) {
        databaseConnection = DatabaseConnection.getInstance();
        try {
            PreparedStatement s = databaseConnection.getConnection()
                    .prepareStatement("UPDATE Categories SET CATEGORY_NAME = ? WHERE CATEGORY_ID = ?");
            s.setString(1, category.getCategoryName());
            s.setInt(2, category.getCategoryId());
            int result = s.executeUpdate();
            databaseConnection.close();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteCategory(int categoryId) {
        databaseConnection = DatabaseConnection.getInstance();
        try {
            //TODO Delete interest and product
            PreparedStatement s = databaseConnection.getConnection()
                    .prepareStatement("DELETE FROM Categories WHERE CATEGORY_ID=?");
            s.setInt(1, categoryId);
            int result = s.executeUpdate();
            databaseConnection.close();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean deleteCategory(String categoryName) {
        databaseConnection = DatabaseConnection.getInstance();
        try {
            //TODO Delete interest and product
            PreparedStatement s = databaseConnection.getConnection()
                    .prepareStatement("DELETE FROM Categories WHERE CATEGORY_NAME=?");
            s.setString(1, categoryName);
            int result = s.executeUpdate();
            databaseConnection.close();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
     public String getCategoryName(int categoryId) {
        databaseConnection = DatabaseConnection.getInstance();
        try {
            PreparedStatement s = databaseConnection.getConnection()
                    .prepareStatement("SELECT CATEGORY_NAME FROM Categories WHERE CATEGORY_ID=?");
            s.setInt(1, categoryId);
            ResultSet result = s.executeQuery();
            boolean found=result.next();
            databaseConnection.close();
            return found? result.getString("CATEGORY_NAME"):"";
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
     
     public String getCategoryID(String categoryName) {
        databaseConnection = DatabaseConnection.getInstance();
        try {
            PreparedStatement s = databaseConnection.getConnection()
                    .prepareStatement("SELECT CATEGORY_ID  FROM Categories WHERE CATEGORY_NAME=?");
            s.setString(1, categoryName);
            ResultSet result = s.executeQuery();
            boolean found=result.next();
            databaseConnection.close();
            return found? result.getString("CATEGORY_NAME"):"";
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

}

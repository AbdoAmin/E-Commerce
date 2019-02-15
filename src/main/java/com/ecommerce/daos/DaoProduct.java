/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.daos;

import com.ecommerce.beans.Product;
import com.ecommerce.utilities.DataBaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
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
    }

    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        try {
            connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DaoProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

}

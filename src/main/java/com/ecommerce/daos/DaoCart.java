/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.daos;

import com.ecommerce.beans.Cart;
import com.ecommerce.utilities.DataBaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tahoon
 */
public class DaoCart
{
    DataBaseConnection connection;
    
    public ArrayList<Cart> getUserCart(int userId) {
        ArrayList<Cart> userCart = new ArrayList<>();
        connection = DataBaseConnection.getInstance();
        Statement s;
        try {
            s = connection.getConnection().createStatement();      
            
            ResultSet rs = s.executeQuery("select * From carts where user_id=?");
            while (rs.next()) {
                Cart cart = new Cart();
                cart.setCartId(rs.getInt("cart_id"));
                cart.setUserId(rs.getInt(2));
                cart.setProductId(rs.getInt(3));
                cart.setQuantity(rs.getInt(4));
                userCart.add(cart);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userCart;        
    }
    
     public boolean addCart(Cart cart) {
            connection = DataBaseConnection.getInstance();
        try {
         
            PreparedStatement pst=connection.getConnection().prepareStatement("insert into carts (cart_id,user_id,product_id,quantity)Values (?,?,?,?)");         
            pst.setInt(1, cart.getCartId());
            pst.setInt(2, cart.getUserId());
            pst.setInt(3, cart.getProductId());
            pst.setInt(4, cart.getQuantity());
            int executeUpdate = pst.executeUpdate();
            connection.close();
            if (executeUpdate > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
     public boolean deleteCart (int cartId){
         connection = DataBaseConnection.getInstance();
         PreparedStatement pst;
        try {
            pst = connection.getConnection().prepareStatement("delete From carts where cart_id=?");                  
            pst.setInt(1, cartId);
            int executeUpdate = pst.executeUpdate();
            connection.close();
            if (executeUpdate > 0) {
                return true;
            }
       } catch (SQLException ex) {
            Logger.getLogger(DaoCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
     public boolean deleteUserCart (int userId){
          connection = DataBaseConnection.getInstance();
         PreparedStatement pst;
       
        try {                  
            pst = connection.getConnection().prepareStatement("delete From carts where user_id=?");
        
            pst.setInt(1, userId);
            int executeUpdate = pst.executeUpdate();
            connection.close();
            if (executeUpdate > 0) {
                return true;
            }
            } catch (SQLException ex) {
            Logger.getLogger(DaoCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
     }
     
      public boolean editQantity(int quantity, int userId, int productId) {
      
           connection = DataBaseConnection.getInstance();
              PreparedStatement pst;
        try {
            pst = connection.getConnection().prepareStatement("update carts set quantity=? where user_id=? and product_id=?");
            pst.setInt(1, quantity);
            pst.setInt(2, userId);
            pst.setInt(3, productId);

            int executeUpdate  = pst.executeUpdate();
            connection.close();
            if (executeUpdate > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoCart.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return false;
    }
      
      
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.daos;

import com.ecommerce.beans.Cart;
import com.ecommerce.beans.CartItem;
import com.ecommerce.beans.Product;
import com.ecommerce.utilities.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tahoon
 */
public class DaoCart {

    DatabaseConnection connection;

    public boolean buyAllInCart(int userId) {
        DaoOrderHistory daoOrderHistory = new DaoOrderHistory();
        DaoProduct daoProduct = new DaoProduct();
        DaoUser daoUser = new DaoUser();
        Cart cart = getUserCart(userId);
        List<CartItem> cartItems = cart.getCartItems();
        if (daoOrderHistory.addUserHistory(userId, cartItems)) {
            for (int i = 0; i < cartItems.size(); i++) {
                daoProduct.setProductQuantity(cartItems.get(i).getProduct().getId(), cartItems.get(i).getProduct().getQuantity()-cartItems.get(i).getQuantity());
            }
            daoUser.updateUserCreditLimit(userId, cart.getTotalPrice());
            deleteUserCart(userId);
        }

        return true;
    }

    public boolean addCart(Cart cart) {
        connection = DatabaseConnection.getInstance();
        try {
            PreparedStatement pst = connection.getConnection().prepareStatement("insert into carts (user_id,product_id,quantity)Values (?,?,?)");
            pst.setInt(1, cart.getUserId());
            pst.setInt(2, cart.getProductId());
            pst.setInt(3, cart.getQuantity());
            int executeUpdate = pst.executeUpdate();
            pst.close();
            connection.close();
            if (executeUpdate > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteCart(int cartId) {
        connection = DatabaseConnection.getInstance();
        PreparedStatement pst;
        try {
            pst = connection.getConnection().prepareStatement("delete From carts where cart_id=?");
            pst.setInt(1, cartId);
            int executeUpdate = pst.executeUpdate();
            pst.close();
            connection.close();
            if (executeUpdate > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteUserCart(int userId) {
        connection = DatabaseConnection.getInstance();
        PreparedStatement pst;

        try {
            pst = connection.getConnection().prepareStatement("delete From carts where user_id=?");

            pst.setInt(1, userId);
            int executeUpdate = pst.executeUpdate();
            pst.close();
            connection.close();
            if (executeUpdate > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoCart.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean deleteProductFromCart(int userId, int productId) {
        connection = DatabaseConnection.getInstance();
        PreparedStatement pst;

        try {
            pst = connection.getConnection().prepareStatement("delete From carts where user_id=? and PRODUCT_ID=? ");

            pst.setInt(1, userId);
            pst.setInt(2, productId);
            int executeUpdate = pst.executeUpdate();
            pst.close();
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

        connection = DatabaseConnection.getInstance();
        PreparedStatement pst;
        try {
            pst = connection.getConnection().prepareStatement("update carts set quantity=? where user_id=? and product_id=?");
            pst.setInt(1, quantity);
            pst.setInt(2, userId);
            pst.setInt(3, productId);

            int executeUpdate = pst.executeUpdate();
            pst.close();
            connection.close();
            if (executeUpdate > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Cart getUserCart(int userId) {
        connection = DatabaseConnection.getInstance();
        PreparedStatement pst;
        Cart cart = new Cart();
        try {
            pst = connection.getConnection().prepareStatement("SELECT CART_ID,"
                    + "       P.QUANTITY PRODUCT_QUANTITY,"
                    + "       C.PRODUCT_ID,"
                    + "       PRODUCT_NAME,"
                    + "       PRICE,"
                    + "       DISCOUNT,"
                    + "       DESCRIPTION,"
                    + "       C.QUANTITY,"
                    + "       I.IMAGE"
                    + "  FROM CARTS C, PRODUCTS P, (SELECT inn.PRODUCT_ID, inn.IMAGE"
                    + "                               FROM (SELECT t.PRODUCT_ID,"
                    + "                                            t.IMAGE,"
                    + "                                            ROW_NUMBER ()"
                    + "                                            OVER (PARTITION BY t.PRODUCT_ID"
                    + "                                                  ORDER BY t.PRODUCT_ID)"
                    + "                                               num"
                    + "                                       FROM PRODUCT_IMAGES t) inn"
                    + "                              WHERE inn.num = 1) I"
                    + " WHERE     C.USER_ID = ?"
                    + "       AND C.PRODUCT_ID = P.PRODUCT_ID"
                    + "       AND C.PRODUCT_ID = I.PRODUCT_ID");
            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt("PRODUCT_ID"), rs.getString("PRODUCT_NAME"),
                        rs.getInt("PRICE"), rs.getDouble("DISCOUNT"), rs.getString("DESCRIPTION"),
                        rs.getInt("PRODUCT_QUANTITY"),
                        Base64.getEncoder().encodeToString(
                                rs.getBytes("IMAGE")));
                CartItem item = new CartItem(product, rs.getInt("QUANTITY"));
                cart.addItem(item);
            }
            pst.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cart;
    }
}

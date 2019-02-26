/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.daos;

import com.ecommerce.beans.CartItem;
import com.ecommerce.beans.OrderHistory;
import com.ecommerce.utilities.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tahoon
 */
public class DaoOrderHistory {

    ResultSet rs;
    DatabaseConnection databaseConnection;

    public OrderHistory getUserHistory(int usrId) {
        OrderHistory history = new OrderHistory();

        databaseConnection = DatabaseConnection.getInstance();
        try {
            PreparedStatement pst = databaseConnection.getConnection()
                    .prepareStatement("select * From ORDER_HISTORY where user_id = ? ");

            pst.setInt(1, usrId);
            rs = pst.executeQuery();
            if (rs.next()) {
                history.setOrederHistoryId(rs.getInt(1));
                history.setOrederDate(rs.getString(2));
                history.setUserId(rs.getInt(3));
            }
            databaseConnection.close();
            return history;
        } catch (SQLException ex) {
            Logger.getLogger(DaoOrderHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean addUserHistory(OrderHistory history) {
        databaseConnection = DatabaseConnection.getInstance();

        PreparedStatement pst;

        try {
            pst = databaseConnection.getConnection()
                    .prepareStatement("insert into ORDER_HISTORY ( ORDER_DATE , USER_ID) Values (?,?)");
            pst.setString(1, history.getOrederDate());
            pst.setInt(2, history.getUserId());

            int executeUpdate = pst.executeUpdate();
            databaseConnection.close();
            if (executeUpdate > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoOrderHistory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    public int getLastUserHistoryInsertedId() {
        databaseConnection = DatabaseConnection.getInstance();

        PreparedStatement pst;

        try {
            pst = databaseConnection.getConnection()
                    .prepareStatement("insert into ORDER_HISTORY ( ORDER_DATE , USER_ID) Values (?,?)");
            pst.setString(1, history.getOrederDate());
            pst.setInt(2, history.getUserId());

            int executeUpdate = pst.executeUpdate();
            databaseConnection.close();
            if (executeUpdate > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoOrderHistory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean addItemsHistory(int historyId, ArrayList<CartItem> item) {
        databaseConnection = DatabaseConnection.getInstance();

        PreparedStatement pst;

        try {
            for (int i = 0; i < item.size(); i++) {
                pst = databaseConnection.getConnection()
                        .prepareStatement("insert into ORDER_ITEMS ( ORDER_HISTORY_ID, PRODUCT_ID , QUANTITY) Values (?,?,?)");
                pst.setInt(1, historyId);
                pst.setInt(2, item.get(i).getProduct().getId());
                pst.setInt(3, item.get(i).getQuantity());

                int executeUpdate = pst.executeUpdate();
                if (executeUpdate == 0) {
                    databaseConnection.close();
                    return false;
                }
            }
            databaseConnection.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DaoOrderHistory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    /**
     * ...................//ToDo in "Admin" .................
     *
     * @return
     */
    public ArrayList<OrderHistory> getAllOrdersHistory() {
        ArrayList<OrderHistory> arrList = new ArrayList();
        databaseConnection = DatabaseConnection.getInstance();

        PreparedStatement pst;
        try {
            pst = databaseConnection.getConnection()
                    .prepareStatement("select * From ORDER_HISTORY");
            rs = pst.executeQuery();

            while (rs.next()) {
                OrderHistory history = new OrderHistory();
                history.setOrederHistoryId(rs.getInt(1));
                history.setOrederDate(rs.getString(2));
                history.setUserId(rs.getInt(3));
                arrList.add(history);
            }
            databaseConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoOrderHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrList;
    }
}

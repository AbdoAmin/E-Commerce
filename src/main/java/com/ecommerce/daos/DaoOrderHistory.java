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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
                history.setOrderHistoryId(rs.getInt(1));
                history.setOrderDate(rs.getString(2));
                history.setUserId(rs.getInt(3));
            }
            pst.close();
            databaseConnection.close();
            return history;
        } catch (SQLException ex) {
            Logger.getLogger(DaoOrderHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //TODO PL Queary
    public boolean addUserHistory(int userId,List<CartItem> item) {
        databaseConnection = DatabaseConnection.getInstance();

        PreparedStatement pst;

        try {
            pst = databaseConnection.getConnection()
                    .prepareStatement("insert into ORDER_HISTORY ( ORDER_DATE , USER_ID) Values (SYSDATE,?)");
            pst.setInt(1, userId);

            int executeUpdate = pst.executeUpdate();
            if (executeUpdate > 0) {
                addItemsHistory(getLastUserHistoryInsertedId(databaseConnection),item,databaseConnection);
                pst.close();
                databaseConnection.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoOrderHistory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    private int getLastUserHistoryInsertedId(DatabaseConnection databaseConnection) {
        int productId = -1;
        try {
            Statement statement = databaseConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select ORDER_HISTORY_ID " 
                    + " from ORDER_HISTORY " 
                    + " where ORDER_HISTORY_ID " 
                    + " = "
                    + " ( select max ( ORDER_HISTORY_ID )"
                    + " from ORDER_HISTORY )");
            if (resultSet.next()) {
                productId = resultSet.getInt("ORDER_HISTORY_ID");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productId;
    }

    public boolean addItemsHistory(int historyId, List<CartItem> item,DatabaseConnection databaseConnection) {

        PreparedStatement pst;
        try {
            for (int i = 0; i < item.size(); i++) {
                pst = databaseConnection.getConnection()
                        .prepareStatement("insert into ORDER_ITEMS ( ORDER_HISTORY_ID, PRODUCT_ID , QUANTITY) Values (?,?,?)");
                pst.setInt(1, historyId);
                pst.setInt(2, item.get(i).getProduct().getId());
                pst.setInt(3, item.get(i).getQuantity());
                pst.executeUpdate();
            }
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
                history.setOrderHistoryId(rs.getInt(1));
                history.setOrderDate(rs.getString(2));
                history.setUserId(rs.getInt(3));
                arrList.add(history);
            }
            pst.close();
            databaseConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoOrderHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrList;
    }
}

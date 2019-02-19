/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.daos;

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
            rs.next();
            history.setOrederHistoryId(rs.getInt(1));
            history.setOrederDate(rs.getString(2));
            history.setUserId(rs.getInt(3));

            databaseConnection.close();
            return history;
            } catch (SQLException ex) {
            Logger.getLogger(DaoOrderHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return null;   
     }
    
    
    
     public boolean addUserHistory(OrderHistory history) {
        databaseConnection = DatabaseConnection.getInstance();
        
        PreparedStatement pst ;
        
        try {
            pst = databaseConnection.getConnection()
                    .prepareStatement("insert into ORDER_HISTORY (ORDER_HISTORY_ID , ORDER_DATE , USER_ID) Values (?,?,?)");     
            pst.setInt(1, history.getOrederHistoryId());
            pst.setString(2,history.getOrederDate());
            pst.setInt(3, history.getUserId());

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

     
     
     /**
     * ...................//ToDo in "Admin" .................
     * @return
     */
    public ArrayList <OrderHistory> getAllOrdersHistory()  {
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
             return arrList;
             } catch (SQLException ex) {
            Logger.getLogger(DaoOrderHistory.class.getName()).log(Level.SEVERE, null, ex);
        }     
            return null;
    }

}

     
     

    


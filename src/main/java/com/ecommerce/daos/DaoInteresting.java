/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.daos;

import com.ecommerce.utilities.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sallam
 */
public class DaoInteresting {

    DatabaseConnection connection;
    public boolean insertInterestingToUser(int userID, int categoryId) {
        try {
            connection = DatabaseConnection.getInstance();
            PreparedStatement ps = connection.getConnection()
                    .prepareStatement("insert into USER_INTERESTES ( USER_ID , CATEGORY_ID) "
                            + " VALUES"
                            + "(?, ?)");

            ps.setInt(1, userID);
            ps.setInt(2, categoryId);
            int executeUpdate = ps.executeUpdate();
            ps.close();
            connection.close();
            return executeUpdate > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DaoInteresting.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

   
}

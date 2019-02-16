/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdo Amin
 */
public class DatabaseConnection {

    private static ArrayList<DatabaseConnection> instance = new ArrayList<>();
    private final static int MaxConcurrencyUser = 10;
    private int currentUsageNumber;
    private Connection con;

    /**
     * @this currentUsageNumber for
     */
    private DatabaseConnection(){
        try {
            this.currentUsageNumber = 0;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "admin", "admin");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This Abdo'sTon extends Singleton, give single object for @field
     * MaxConcurrencyUser , create new object when first get full.
     */
    public static DatabaseConnection getInstance() {
        DatabaseConnection temp = null;
        if (instance.isEmpty()) {
            synchronized (DatabaseConnection.class) {
                if (instance.isEmpty()) {
                    temp = new DatabaseConnection();
                    instance.add(temp);
                }
            }
        } else {
            for (DatabaseConnection inst : instance) {
                if (inst.currentUsageNumber < MaxConcurrencyUser) {
                    inst.currentUsageNumber++;
                    return inst;
                }
            }
            temp = new DatabaseConnection();
            instance.add(temp);
            temp.currentUsageNumber++;
            return temp;
        }
        temp.currentUsageNumber++;
        return temp;
    }

    /**
     * @this isEmptySpace just for ensure from when remove all object keep at
     * lest one has space to use
     *
     * This else if for give the next object info about the previous that it has
     * space
     */
    public static void removeNotInUse() {
        boolean isEmptySpace = false;
        Iterator<DatabaseConnection> it = instance.iterator();
        if (it.next().currentUsageNumber < MaxConcurrencyUser) {
            isEmptySpace = true;//to skip first item /* It's singletone must keep one object ,maaaaaan */
        }
        for (; it.hasNext();) {
            DatabaseConnection inst = it.next();
            if (inst.currentUsageNumber == 0 && isEmptySpace) {
                instance.remove(inst);
            } else if (inst.currentUsageNumber < MaxConcurrencyUser) {
                isEmptySpace = true;
            }
        }
    }

    /**
     * @this con , give you ability to operate DB.
     */
    public Connection getConnection() {
        return con;
    }

}

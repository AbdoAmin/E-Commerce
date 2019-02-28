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
 *
 * This class for get connection use:
 *      DatabaseConnection example =DatabaseConnection.getInstance();
 *      example.getConnection()."Query" ;
 *      example.close();
 */
public class DatabaseConnection {

    private static final ArrayList<DatabaseConnection> INSTANCES = new ArrayList<>();
    private static final int MAX_CONCURRENCY_USERS = 10;
    private int currentUsageNumber;
    private Connection con;

    /**
     * @this currentUsageNumber for calculate free space of usage.
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
     * @return DatabaseConnection
     */
    public static DatabaseConnection getInstance() {
        if (INSTANCES.isEmpty()) {
            synchronized (DatabaseConnection.class) {
                if (INSTANCES.isEmpty()) {
                    DatabaseConnection temp = new DatabaseConnection();
                    INSTANCES.add(temp);
                }
            }
        } else {
            for (DatabaseConnection inst : INSTANCES) {
                if (inst.currentUsageNumber < MAX_CONCURRENCY_USERS) {
                    inst.currentUsageNumber++;
                    return inst;
                }
            }
            DatabaseConnection temp = new DatabaseConnection();
            INSTANCES.add(temp);
            temp.currentUsageNumber++;
            return temp;
        }
        //double check for space too
        if (INSTANCES.get(0).currentUsageNumber < MAX_CONCURRENCY_USERS) {
            INSTANCES.get(0).currentUsageNumber++;
            return INSTANCES.get(0);
        } else {
            return getInstance();
        }
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
        Iterator<DatabaseConnection> it = INSTANCES.iterator();
        if (it.next().currentUsageNumber < MAX_CONCURRENCY_USERS) {
            isEmptySpace = true;//to skip first item /* It's singletone must keep one object ,maaaaaan */
        }
        for (; it.hasNext();) {
            DatabaseConnection inst = it.next();
            if (inst.currentUsageNumber == 0 && isEmptySpace) {
                try {
                    inst.getConnection().close();
                    INSTANCES.remove(inst);
                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (inst.currentUsageNumber < MAX_CONCURRENCY_USERS) {
                isEmptySpace = true;
            }
        }
    }

    /**
     * @return Connection
     * @this con , give you ability to operate DB.
     */
    public Connection getConnection() {
        return con;
    }
    
    public void close() {
        currentUsageNumber--;
        if(currentUsageNumber>=0){
            removeNotInUse();
        }
    }

}

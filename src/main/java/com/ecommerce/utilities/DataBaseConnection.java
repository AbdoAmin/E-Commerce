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

/**
 *
 * @author Abdo Amin
 *
 * This class for get connection use: Connection inAppConection =
 * DataBaseConnection.getInstance();
 */
public class DataBaseConnection {

    private static final ArrayList<DataBaseConnection> instance = new ArrayList<>();
    private static final int MAX_CONCURRENCY_USERS = 10;
    private int currentUsageNumber;
    private Connection con;

    /**
     * @this currentUsageNumber for calculate free space of usage.
     */
    private DataBaseConnection() throws ClassNotFoundException, SQLException {
        this.currentUsageNumber = 0;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "admin", "admin");
    }

    /**
     * This Abdo'sTon extends Singleton, give single object for @field
     * MaxConcurrencyUser , create new object when first get full.
     */
    public static Connection getInstance() throws ClassNotFoundException, SQLException {

        if (instance.isEmpty()) {
            synchronized (DataBaseConnection.class) {
                if (instance.isEmpty()) {
                    DataBaseConnection temp = new DataBaseConnection();
                    instance.add(temp);
                }
            }
        } else {
            for (DataBaseConnection inst : instance) {
                if (inst.currentUsageNumber < MAX_CONCURRENCY_USERS) {
                    inst.currentUsageNumber++;
                    return inst.getConnection();
                }
            }
            DataBaseConnection temp = new DataBaseConnection();
            instance.add(temp);
            temp.currentUsageNumber++;
            return temp.getConnection();
        }
        //double check for space too
        if (instance.get(0).currentUsageNumber < MAX_CONCURRENCY_USERS) {
            instance.get(0).currentUsageNumber++;
            return instance.get(0).getConnection();
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
        Iterator<DataBaseConnection> it = instance.iterator();
        if (it.next().currentUsageNumber < MAX_CONCURRENCY_USERS) {
            isEmptySpace = true;//to skip first item /* It's singletone must keep one object ,maaaaaan */
        }
        for (; it.hasNext();) {
            DataBaseConnection inst = it.next();
            if (inst.currentUsageNumber == 0 && isEmptySpace) {
                instance.remove(inst);
            } else if (inst.currentUsageNumber < MAX_CONCURRENCY_USERS) {
                isEmptySpace = true;
            }
        }
    }

    /**
     * @this con , give you ability to operate DB.
     */
    private Connection getConnection() {
        return con;
    }

}

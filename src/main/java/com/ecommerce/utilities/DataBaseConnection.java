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
 */
public class DataBaseConnection {

    private static ArrayList<DataBaseConnection> instance = new ArrayList<>();
    private final static int MaxConcurrencyUser = 10;
    private int currentUsageNumber;
    private Connection con;

    /**
     * @this currentUsageNumber for
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
    public static DataBaseConnection getInstance() throws ClassNotFoundException, SQLException {
        DataBaseConnection temp = null;
        if (instance.isEmpty()) {
            synchronized (DataBaseConnection.class) {
                if (instance.isEmpty()) {
                    temp = new DataBaseConnection();
                    instance.add(temp);
                }
            }
        } else {
            for (DataBaseConnection inst : instance) {
                if (inst.currentUsageNumber < MaxConcurrencyUser) {
                    inst.currentUsageNumber++;
                    return inst;
                }
            }
            temp = new DataBaseConnection();
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
        Iterator<DataBaseConnection> it = instance.iterator();
        if (it.next().currentUsageNumber < MaxConcurrencyUser) {
            isEmptySpace = true;//to skip first item /* It's singletone must keep one object ,maaaaaan */
        }
        for (; it.hasNext();) {
            DataBaseConnection inst = it.next();
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

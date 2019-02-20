/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.beans;

/**
 *
 * @author Ashraf_R
 */
public class OrderHistory {
    private int orederHistoryId;
    private String orederDate;
    private int userId;

    public int getOrederHistoryId() {
        return orederHistoryId;
    }

    public void setOrederHistoryId(int orederHistoryId) {
        this.orederHistoryId = orederHistoryId;
    }

    public String getOrederDate() {
        return orederDate;
    }

    public void setOrederDate(String orederDate) {
        this.orederDate = orederDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
}

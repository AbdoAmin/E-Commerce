/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.beans;

import java.text.NumberFormat;
import java.util.Locale;


/**
 * This entity represents a collection of products with a specified quantity.
 *
 * @author Tahoon
 */
public class LineItem {

    private int lineItemId;
    private Product product;
    private int quantity = 1;

    public LineItem() {}

    public int getLineItemId() {
        return lineItemId;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    //to know the total price of products in my catr
    public double getTotalPrice() {
         return product.getPrice()* quantity; 
      
    }

    /*
   * this fucken lines in method getTotalPriceCurrencyFormat()
   * to get price of all products and put a sign of dollar or sterlleng 
   * or any fucken 3omla .. it just for decor man
     */
    public String getTotalPriceCurrencyFormat() {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.UK);
        return currencyFormat.format(getTotalPrice());
    }

    public void setLineItemId(int lineItemId) {
        this.lineItemId = lineItemId;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}

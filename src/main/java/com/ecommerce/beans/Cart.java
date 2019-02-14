/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.beans;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * this class for Cart that customer can fill it or Remove line items from it.
 * 
 * @author Ashraf_R
 */
public class Cart {

   // private int cartId;
//    private int userId;
//    private int productId;
//    private int quantity;

    private List<LineItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

//    public Cart(int cartId){
//        this.cartId = cartId;
//    }

//    public Cart(int cartId, int userId, int productId, int quantity) {
//        this.cartId = cartId;
//        this.userId = userId;
//        this.productId = productId;
//        this.quantity = quantity;
//    }

//    public int getCartId() {
//        return cartId;
//    }

//    public void setCartId(int cartId) {
//        this.cartId = cartId;
//    }

//    public int getUserId() {
//        return userId;
//    }

//    public void setUserId(int userId) {
//        this.userId = userId;
//    }

//    public int getProductId() {
//        return productId;
//    }

//    public void setProductId(int productId) {
//        this.productId = productId;
//    }

//    public int getQuantity() {
//        return quantity;
//    }

//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }

    public List<LineItem> getItems() {
        return items;
    }

    public void setItems(List<LineItem> items) {
        this.items = items;
    }

    /*
     * @return The amount of LineItem objects in the cart
     */
    public int getSize() {
        return items.size();
    }

    /*
     * @return The total price for the items in the cart
     */
    public double getTotalPrice() {
        double total = 0.0;
        for (LineItem i : items) {
            total += i.getTotalPrice();
        }

        return total;
    }

    /*
     * @return Formatted String which represents the total price for a cart
     * this fucken lines in method getTotalPriceCurrencyFormat()
     * to get price of all products and put a sign of dollar or sterlleng 
     * or any fucken 3omla .. it just for decor man
     */
    public String getTotalPriceCurrencyFormat() {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.UK);
        double totalPrice = getTotalPrice();
        return currencyFormat.format(totalPrice);
    }

    /*
     * Add a line item into the cart if it's not already there. "Otherwise" man
     * the quantity will be increased.
     *
     * @param lineItem The line item to be added to the cart
     */
    public void addItem(LineItem lineItem) {
        int itemCode = lineItem.getProduct().getProductId();
        int quantities = lineItem.getQuantity();

        for (LineItem i : items) {
            if (i.getProduct().getProductId()==itemCode) {
                // already exists man
                i.setQuantity(quantities);
                return;
            }
        }

        items.add(lineItem);
    }

    /*
     * Removes items if it exists in the cart
     *
     * @param lineItem The line item to be removed
     */
    public void removeItem(LineItem lineItem) {
        int itemCode = lineItem.getProduct().getProductId();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().getProductId()==itemCode) {
                items.remove(i);
                return;
            }
        }
    }
}

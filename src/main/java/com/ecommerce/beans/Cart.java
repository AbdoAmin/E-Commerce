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
 * this class for Cart that customer can fill it or Remove line CartItems from it.
 *
 * @author Ashraf_R
 */
public class Cart {
    
    private int cartId;
    private int userId;
    private int productId;
    private int quantity;
    
    private List<CartItem> cartItems;

    public Cart(int userId, int productId, int quantity) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Cart() {
        cartItems = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return cartItems;
    }

    public void setItems(List<CartItem> items) {
        this.cartItems = items;
    }

    /*
     * @return The amount of CartItem objects in the cart
     */
    public int getSize() {
        return cartItems.size();
    }

    /*
     * @return The total price for the CartItems in the cart
     */
    public double getTotalPrice() {
        double total = 0.0;
        for (CartItem i : cartItems) {
            total += i.getTotalPrice();
        }

        return total;
    }

    /*
     * @return Formatted String which represents the total price for a cart
     * this lines in method getTotalPriceCurrencyFormat()
     * to get price of all products and put a sign of dollar or sterlleng 
     * or any currency .. it just for decor man
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
    public void addItem(CartItem item) {
        int itemCode = item.getProduct().getId();

        for (CartItem i : cartItems) {
            if (i.getProduct().getId() == itemCode) {
                // already exists man
                i.incremantQuantity();
                return;
            }
        }
        cartItems.add(item);
    }

    /*
     * Removes CartItems if it exists in the cart
     *
     * @param lineItem The line item to be removed
     */
    public void removeItem(CartItem cartItem) {
        int itemCode = cartItem.getProduct().getId();
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getProduct().getId() == itemCode) {
                cartItems.remove(i);
                return;
            }
        }
    }
 
    
    //////////////////////////
     public Cart(int cartId)
    {
        this.cartId = cartId;
    }

    public Cart(int cartId, int userId, int productId, int quantity) {
        this.cartId = cartId;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getCartId() {
        return cartId;
    }

    public int getUserId() {
        return userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
    
}

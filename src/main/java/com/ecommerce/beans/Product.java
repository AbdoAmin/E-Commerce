/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.beans;

/**
 * This entity represents a single product in the store, which have its id,
 * a name and a price, quantities , discount and category.
 * 
 * @author Ashraf_R
 */
public class Product {

    private int productId;
    private String name;
    private double price;
    private double discount;
    private int quantity;
    private int categoryId;
    
   
    public Product() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
   

    public Product(int productId, int quantityProduct, String productName, double price) {
        this.productId = productId;
        this.quantity = quantityProduct;
        this.name = productName;
        this.price = price;
    }

   
}

    


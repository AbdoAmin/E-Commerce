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
    private String productName;
    private double price;
    private double discount;
    private int quantity_product;
    private int categoryId;
    
   
    public Product() {}

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
    

    public int getQuantity_product() {
        return quantity_product;
    }

    public void setQuantity_product(int quantity_product) {
        this.quantity_product = quantity_product;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
   

    public Product(int productId, int quantity_product, String productName, double price) {
        this.productId = productId;
        this.quantity_product = quantity_product;
        this.productName = productName;
        this.price = price;
    }

   
}

    


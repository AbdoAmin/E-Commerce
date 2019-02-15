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
    private int quantityProduct;
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
    

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
   

    public Product(int productId, int quantityProduct, String productName, double price) {
        this.productId = productId;
        this.quantityProduct = quantityProduct;
        this.productName = productName;
        this.price = price;
    }

   
}

    


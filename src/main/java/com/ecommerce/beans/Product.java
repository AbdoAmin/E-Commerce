/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.beans;

import java.util.List;

/**
 * This entity represents a single product in the store, which have its id, a
 * name and a price, quantities , discount and category.
 *
 * @author Ashraf_R
 */
public class Product {

    private int id;
    private String name;
    private String description;
    private double price;
    private double discount;
    private int quantity;
    private int categoryId;
    private List<String> productImages;

    public Product() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int productId) {
        this.id = productId;
    }

    public List<String> getProductImages() {
        return productImages;
    }

    public String getMainProductImage() {
        if (productImages != null) {
            if (!productImages.isEmpty()) {
                return productImages.get(0);
            }
        }
        return "Default Image"; //TODO
    }

    public void setProductImages(List<String> productImages) {
        this.productImages = productImages;
    }

    public Product(int productId, int quantityProduct, String productName, double price) {
        this.id = productId;
        this.quantity = quantityProduct;
        this.name = productName;
        this.price = price;
    }

}

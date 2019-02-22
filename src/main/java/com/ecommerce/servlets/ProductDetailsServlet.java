/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.servlets;

import com.ecommerce.beans.Category;
import com.ecommerce.beans.Product;
import com.ecommerce.daos.DAOCategories;
import com.ecommerce.daos.DaoProduct;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Abdo Amin
 */
@WebServlet(name = "ProductDetailsServlet", urlPatterns = {"/ProductDetailsServlet"})
public class ProductDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter("productID");
        DaoProduct daoProduct = new DaoProduct();
        Product product;
        if (productId != null) {
            product = daoProduct.getProduct(Integer.valueOf(productId));
            req.setAttribute("product", product);
        } 
        //Deprecated must remove soon,Competabilty
        DAOCategories dAOCategories = new DAOCategories();
        List<Category> allCategories = dAOCategories.getAllCategories();
        req.setAttribute("categories", allCategories);
        
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.servlets;

import com.ecommerce.beans.Cart;
import com.ecommerce.beans.User;
import com.ecommerce.daos.DaoCart;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Abdo Amin
 */
@WebServlet(name = "BuyServlet", urlPatterns = {"/BuyServlet"})
public class BuyServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DaoCart dAOCart = new DaoCart();
        String productId = request.getParameter("id");
        String productQuantity = request.getParameter("quantity");
        int userId = ((User) request.getSession().getAttribute("user")).getUserId();
        if (productId != null && productQuantity != null) {
            dAOCart.addCart(new Cart(userId,Integer.valueOf(productId),Integer.valueOf(productQuantity)));
        }
        
        Cart cart = dAOCart.getUserCart(userId);
        request.getSession().setAttribute("myCart", cart);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}

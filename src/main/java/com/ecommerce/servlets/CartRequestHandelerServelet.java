/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.servlets;

import com.ecommerce.beans.User;
import com.ecommerce.daos.DaoCart;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Abdo Amin
 */
@WebServlet(name = "CartRequestHandelerServelet", urlPatterns = {"/CartRequestHandelerServelet"})
public class CartRequestHandelerServelet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DaoCart daoCart = new DaoCart();
        String productIdToDelete = request.getParameter("productIdToDelete");
        String buy = request.getParameter("buy");
        User user = (User) request.getSession().getAttribute("user");
        if (productIdToDelete != null) {
            daoCart.deleteProductFromCart(user.getUserId(), Integer.valueOf(productIdToDelete));
            //forword mycart
        }
        if (buy != null) {
            daoCart.buyAllInCart(user.getUserId());
            user.setCreditLimit(user.getCreditLimit()-Double.valueOf(buy));
            request.getSession().setAttribute("user", user);
            //forword mycart
        }
        request.getRequestDispatcher("MyCart.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}

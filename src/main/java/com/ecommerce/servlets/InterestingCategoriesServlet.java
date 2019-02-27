/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.servlets;

import com.ecommerce.beans.User;
import com.ecommerce.daos.DaoInteresting;
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
@WebServlet(name = "InterestingCategoriesServlet", urlPatterns = {"/InterestingCategoriesServlet"})
public class InterestingCategoriesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String paramSizeString = request.getParameter("size");
        String userId = request.getParameter("userId");

        if (paramSizeString != null && userId != null) {
            DaoInteresting daoInteresting = new DaoInteresting();
            int paramSize = Integer.valueOf(paramSizeString);
            System.err.println("userddddddddddddddddddddddddddddddddddddddddddddddddddd id :" + userId);
            int id = Integer.valueOf(userId);
            if (paramSize > 0) {
                for (int i = 0; i < paramSize; i++) {
                    String categoreIDString = request.getParameter("c" + i);
                    if (categoreIDString != null) {
                        int categoreID = Integer.valueOf(categoreIDString);

                        System.err.println("Categori id :" + categoreID);
                        
                        daoInteresting.insertInterestingToUser(id, categoreID);
                    }
                }
            }
        }
        response.sendRedirect("login.jsp");

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

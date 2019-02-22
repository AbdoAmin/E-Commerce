/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.servlets.admin;

import com.ecommerce.beans.OrderHistory;
import com.ecommerce.daos.DaoOrderHistory;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tahoon
 */
@WebServlet(name = "GetAllHistoryServlet", urlPatterns = {"/GetAllHistoryServlet"})
public class GetAllHistoryServlet extends HttpServlet {

      
    DaoOrderHistory history;
   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                history=new DaoOrderHistory();
                ArrayList <OrderHistory> allHistoryAdmin;
                allHistoryAdmin = history.getAllOrdersHistory();
                request.setAttribute("history", allHistoryAdmin);
                System.out.println("ggggggggggggaflkgjjjjjjjjjjjjjjggggggggggggggggggggggggggggggggggggggggggggggg"+allHistoryAdmin.size());
                
        }

}
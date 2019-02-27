/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.servlets.admin;

import com.ecommerce.daos.DAOCategories;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ashraf_R
 */
@WebServlet(name = "AddCategoryServlet", urlPatterns = {"/AddCategoryServlet"})
public class AddCategoryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName = req.getParameter("categoryName");
        if (categoryName != null) {
            DAOCategories dAOCategories = new DAOCategories();
            if (dAOCategories.insertCategory(categoryName)) {
                req.getRequestDispatcher("addProduct.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("addCategory.jsp?error");
            }
        } else {
            resp.sendRedirect("addCategory.jsp?error");
        }
    }

}

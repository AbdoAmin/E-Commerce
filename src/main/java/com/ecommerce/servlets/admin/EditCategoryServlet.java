/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.servlets.admin;

import com.ecommerce.beans.Category;
import com.ecommerce.beans.Product;
import com.ecommerce.daos.DAOCategories;
import com.ecommerce.daos.DaoProduct;
import com.ecommerce.daos.DaoProductImages;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Ashraf_R
 */
@WebServlet(name = "EditCategoryServlet", urlPatterns = {"/EditCategoryServlet"})
public class EditCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String categoryId = req.getParameter("categoryId");
        if (categoryId != null) {
            DAOCategories dAOCategories = new DAOCategories();
            Category category = new Category();
            category.setCategoryId(Integer.parseInt(categoryId));
            category.setCategoryName(dAOCategories.getCategoryName(Integer.parseInt(categoryId)));
            req.setAttribute("category", category);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String categoryId = req.getParameter("categoryId");
        String categoryName = req.getParameter("categoryName");
        if (categoryId != null && categoryName != null) {
            DAOCategories dAOCategories = new DAOCategories();
            Category category = new Category();
            category.setCategoryId(Integer.parseInt(categoryId));
            category.setCategoryName(categoryName);
            if (dAOCategories.updateCategory(category)) {
                resp.sendRedirect("editCategory.jsp");
            } else {
                resp.sendRedirect("editCategory.jsp?error");
            }
        } else {
            resp.sendRedirect("editCategory.jsp?error");
        }
    }
}

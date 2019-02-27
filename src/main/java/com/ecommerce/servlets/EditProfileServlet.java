/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.servlets;

import com.ecommerce.beans.User;
import com.ecommerce.daos.DaoUser;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author Sallam
 */
@WebServlet(name = "EditProfileServlet", urlPatterns = {"/EditProfileServlet"})
public class EditProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoUser daoUser = new DaoUser();
        User user = (User) request.getSession().getAttribute("user");
        System.out.println(user.getEmail());

        String day = null, month = null, year = null;
        // user profile image 
        DiskFileItemFactory factory = new DiskFileItemFactory();

        ServletFileUpload upload = new ServletFileUpload(factory);

        List<FileItem> items;
        InputStream inputStream = null;
        int size = 0;
        try {
            items = upload.parseRequest(request);
            Iterator<FileItem> iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = iter.next();
                if (!item.isFormField()) {
                    inputStream = item.getInputStream();
                    size = (int) item.getSize();
                } else {
                    if (item.getFieldName().equals("firstName")) {
                        user.setFirstName(item.getString());
                    } else if (item.getFieldName().equals("lastName")) {
                        user.setLastName(item.getString());
                    } else if (item.getFieldName().equals("UserEmail")) {
                        user.setEmail(item.getString());
                    } else if (item.getFieldName().equals("UserPassword")) {
                        user.setPassword(item.getString());
                    } else if (item.getFieldName().equals("address")) {
                        user.setAddress(item.getString());
                    } else if (item.getFieldName().equals("phone")) {
                        user.setPhone(item.getString());
                    } else if (item.getFieldName().equals("job")) {
                        user.setJob(item.getString());
                    } else if (item.getFieldName().equals("day")) {
                        day = item.getString();
                    } else if (item.getFieldName().equals("month")) {
                        month = item.getString();
                    } else if (item.getFieldName().equals("year")) {
                        year = item.getString();
                    }
                }
            }
            user.setBirthDate(day + "/" + month + "/" + year);
            boolean signUp = daoUser.updateUser(user, inputStream, size);
            response.sendRedirect("index.jsp");
        } catch (FileUploadException ex) {
            Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response); //To change body of generated methods, choose Tools | Templates.
    }

}

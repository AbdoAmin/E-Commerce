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
 * @author Ashraf_R
 */
@WebServlet(name = "SignUpServlet", urlPatterns = {"/SignUpServlet"})
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoUser daoUser = new DaoUser();
        User user = new User();
        String day = null, month = null, year = null;
        user.setPrivilege("user");
        user.setCreditLimit(1000.0);
        // user profile image 
        DiskFileItemFactory factory = new DiskFileItemFactory();

        ServletFileUpload upload = new ServletFileUpload(factory);

        List<FileItem> items;
        InputStream inputStream = null;
        int size = 0;
        try {
            items = upload.parseRequest(req);
            Iterator<FileItem> iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = iter.next();
                if (!item.isFormField()) {
                    inputStream = item.getInputStream();
                    size = (int) item.getSize();
                } else {
                    if (item.getFieldName().equals("firstName")) {
                        user.setFirstName(item.getString());
                    }else if(item.getFieldName().equals("lastName")) {
                        user.setLastName(item.getString());
                    }else if(item.getFieldName().equals("UserEmail")) {
                        user.setEmail(item.getString());
                    }else if(item.getFieldName().equals("UserPassword")) {
                        user.setPassword(item.getString());
                    }else if(item.getFieldName().equals("address")) {
                        user.setAddress(item.getString());
                    }else if(item.getFieldName().equals("phone")) {
                        user.setPhone(item.getString());
                    }else if(item.getFieldName().equals("job")) {
                        user.setJob(item.getString());
                    }else if(item.getFieldName().equals("day")) {
                        day = item.getString();
                    }else if(item.getFieldName().equals("month")) {
                       month = item.getString();
                    }else if(item.getFieldName().equals("year")) {
                        year = item.getString();
                    }
                }
            }
            user.setBirthDate(day + "/" + month + "/" + year);
            if(daoUser.signUp(user, inputStream, size)){
                resp.sendRedirect("Interesting.jsp?userId="+daoUser.getLastUserId());
//                req.getRequestDispatcher().forward(req, resp);
            }else{
                req.getRequestDispatcher("register.jsp?error").forward(req, resp);
            }
        } catch (FileUploadException ex) {
                req.getRequestDispatcher("register.jsp?error").forward(req, resp);
        }
    }
}

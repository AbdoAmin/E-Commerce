/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.utilities;

import com.ecommerce.beans.User;
import com.ecommerce.beans.UserLogin;
import com.ecommerce.daos.DaoUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sallam
 */
@WebServlet(name = "JustForTesting", urlPatterns = {"/JustForTesting"})
public class JustForTesting extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        DaoUser daoUser = new DaoUser();
        
        UserLogin user = new UserLogin();
        user.setEmail(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        
        User user2 = daoUser.signIn(user);
        if(user2!=null){
            out.println(user2.getFirstName() + "<br/>");
//            for(Integer i : user2.getInterests()){
//                out.println(i + "<br/>");
//            }
        }else
            out.println("Doesn't exist");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.servlets;

import com.ecommerce.beans.Product;
import com.ecommerce.beans.User;
import com.ecommerce.beans.UserLogin;
import com.ecommerce.daos.DaoProduct;
import com.ecommerce.daos.DaoUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sallam
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoUser daoUser = new DaoUser();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserLogin userLogin = new UserLogin();
        userLogin.setEmail(email);
        userLogin.setPassword(password);

        PrintWriter out = response.getWriter();
        out.println(userLogin.getEmail());
        out.println(userLogin.getPassword());

        User user;
        user = daoUser.signIn(userLogin);

        //TODO: put the user object transfer to index.jsp code here
//        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//        rd.include(request, response);
        out.println();
        if (user != null) {
            if (user.getPrivilege().equalsIgnoreCase("admin")) {
                response.sendRedirect("admin.jsp");
            } else {
                DaoProduct daoProduct = new DaoProduct();

                HttpSession session = request.getSession(true);
                session.setAttribute("user", user);
                session.setMaxInactiveInterval(30 * 60);

                ArrayList<Product> productsOfInterest = (ArrayList<Product>) daoProduct.getProductsOfInterest(user.getUserId());

                session.setAttribute("productsOfInterest", productsOfInterest);
                request.getSession().setAttribute("err", "false");

                response.sendRedirect("index.jsp");
            }
//            request.getRequestDispatcher("index.jsp").include(request, response);
        } else {
            //TODO: redirect to an error page 
            //or tell the user that the email or the password he/she entered is worng!
//            HttpSession session = request.getSession(true);
            
//            session.setAttribute("err", "true");

            response.sendRedirect("login.jsp?myparam=invalid");

        }
//            response.sendRedirect("index.jsp");

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.servlets;

import com.ecommerce.beans.Cart;
import com.ecommerce.daos.DaoCart;
import com.ecommerce.beans.Product;
import com.ecommerce.beans.User;
import com.ecommerce.beans.UserLogin;
import com.ecommerce.daos.DaoProduct;
import com.ecommerce.daos.DaoUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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


        User user = daoUser.signIn(userLogin);
        if (user != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(30 * 60);
            
            if (user.getPrivilege().equalsIgnoreCase("admin")) {
                response.sendRedirect("admin.jsp");
            } else {
        
            DaoProduct daoProduct = new DaoProduct();

            //Abdo Edit Ew3a..
            DaoCart dAOCart = new DaoCart();
            Cart cart = dAOCart.getUserCart(user.getUserId());
            request.getSession().setAttribute("myCart", cart);

            ArrayList<Product> productsOfInterest = (ArrayList<Product>) daoProduct.getProductsOfInterest(user.getUserId());

            session.setAttribute("productsOfInterest", productsOfInterest);
            response.sendRedirect("index.jsp");
        }
        } else {
            response.sendRedirect("login.jsp?error=invalid");
        }
    }
}

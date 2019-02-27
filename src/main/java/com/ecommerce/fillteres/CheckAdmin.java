/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.fillteres;

import com.ecommerce.beans.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tahoon
 */
@WebFilter(filterName = "CheckAdmin",urlPatterns = {"/TempHistory.jsp","/editProduct.jsp"
        ,"/addProduct.jsp","/addCategory.jsp"
        ,"/admin.jsp","/adminSideBar.jsp","/editCategory.jsp"})
public class CheckAdmin implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response ,FilterChain chain) throws IOException, ServletException {

        User user = (User) ((HttpServletRequest) request).getSession().getAttribute("user");
       // User user = new User();
       /// /////////////////   user = null 
         if (user != null && user.getPrivilege().equalsIgnoreCase("admin")) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect("/E-Commerce/error.html");
        }

    
    }

    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

}

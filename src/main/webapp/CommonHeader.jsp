<%-- 
    Document   : CommonHeader
    Created on : Feb 22, 2019, 12:41:25 AM
    Author     : Abdo Amin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="header">
    <div class="container">
        <!--/*modified by sallam..added a condition to display the welcome div*/-->
        <c:if test="${pageContext.session.getAttribute(user)!=null}">
            <div id="welcomeLine" class="row">
                <div class="span6">Welcome!<strong> User</strong></div>
                <div class="span6">
                    <div class="pull-right">
                        <a href="product_summary.html"><span class="">Fr</span></a>
                        <a href="product_summary.html"><span class="">Es</span></a>
                        <span class="btn btn-mini">En</span>
                        <a href="product_summary.html"><span>&pound;</span></a>
                        <span class="btn btn-mini">$155.00</span>
                        <a href="product_summary.html"><span class="">$</span></a>
                        <a href="product_summary.html"><span class="btn btn-mini btn-primary"><i
                                    class="icon-shopping-cart icon-white"></i> [ 3 ] Itemes in your cart </span> </a>
                    </div>
                </div>
            </div>
        </c:if>
        <!-- Navbar ================================================== -->
        <div id="logoArea" class="navbar">
            <a id="smallScreen" data-target="#topMenu" data-toggle="collapse" class="btn btn-navbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <div class="navbar-inner">
                <a class="brand" href="index.html"><img src="themes/images/logo.png" alt="Bootsshop" /></a>
                <form class="form-inline navbar-search" method="post" action="products.html">
                    <input id="srchFld" class="srchTxt" type="text" />
                    <select class="srchTxt">
                        <option>All</option>
                        <option>CLOTHES </option>
                        <option>FOOD AND BEVERAGES </option>
                        <option>HEALTH & BEAUTY </option>
                        <option>SPORTS & LEISURE </option>
                        <option>BOOKS & ENTERTAINMENTS </option>
                    </select>
                    <button type="submit" id="submitButton" class="btn btn-primary">Go</button>
                </form>
                <ul id="topMenu" class="nav pull-right">
                    <li class=""><a href="special_offer.jsp">Specials Offer</a></li>
                    <li class=""><a href="contact.html">Contact</a></li>
                    <!--/*modify by sallam..added the condition*/-->
                    <li class="">
                        <c:if test="${user==null}">
                            <a role="button" style="padding-right:0" href="${pageContext.request.contextPath}/login.jsp">
                                <span class="btn btn-large btn-success" >Login</span>
                            </a>
                        </c:if>
                        <c:if test="${user!=null}">
                            <a href="LogOutServlet" role="button" style="padding-right:0">
                                <span class="btn btn-large btn-success">Logout</span>
                            </a>
                        </c:if>  
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<%-- 
    Document   : CommonHeader
    Created on : Feb 22, 2019, 12:41:25 AM
    Author     : Abdo Amin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<div id="header">
    <div class="container">
        <!--/*modified by sallam..added a condition to display the welcome div*/-->
        <c:if test="${user!= null}">
            <div id="welcomeLine" class="row">
                <div class="span6">Welcome!
                    <strong> ${user.firstName} ${user.lastName}</strong>
                </div>
                <div class="span6">
                    <div class="pull-right">
                        <span class="btn btn-mini">${user.creditLimit} $</span>
                        <a href="MyCart.jsp"><span class="btn btn-mini btn-primary">
                                <i class="icon-shopping-cart icon-white"></i>
                                ${fn:length(sessionScope.myCart.cartItems)} Item
                                <c:if test="${fn:length(sessionScope.myCart.cartItems)>1}">s</c:if>
                                in your cart </span> </a>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${user == null}">
            <div id="welcomeLine" class="row">
                <div class="span6"><strong>         </strong></div>
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
                <a class="brand" href="index.jsp"><img src="themes/images/logo.png" alt="Bootsshop" /></a>
                <form class="form-inline navbar-search" method="GET" action="index.jsp">
                    <input id="srchFld" class="srchTxt" type="text" name="productName" style="height: 30 !important;padding-left: 30;" />
                    <select class="srchTxt" name="category">
                        <option value="-1">All</option>
                        <c:forEach items="${categories}" var="category">
                            <option value="${category.categoryId}">${category.categoryName}</option>
                        </c:forEach>
                    </select>
                    <button type="submit" id="submitButton" class="btn btn-primary">Go</button>
                </form>
                <ul id="topMenu" class="nav pull-right">
                    <li class=""><a href="special_offer.jsp">Specials Offer</a></li>
                    <li class=""><a href="contact.jsp">Contact</a></li>
                    <!--/*modify by sallam..added the condition*/-->
                    <li class="">
                        <c:if test="${user==null}">
                            <a role="button" style="padding-right:0"
                                href="${pageContext.request.contextPath}/login.jsp">
                                <span class="btn btn-large btn-success">Login</span>
                            </a>
                        </c:if>
                        <c:if test="${user!=null}">
                            <a href="LogOutServlet" role="button" style="padding-right:0"><span
                                    class="btn btn-large btn-success">Logout</span></a>
                        </c:if>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
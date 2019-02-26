<%-- 
    Document   : CommonBody
    Created on : Feb 22, 2019, 12:44:45 AM
    Author     : Abdo Amin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${empty categories}">
    <jsp:include page="/CategoriesServelet" /> 
</c:if>



<div id="sidebar" class="span3">
    <c:if test="${!empty sessionScope.user}">
        <div class="well well-small">
            <a id="myCart" href="MyCart.jsp">
                <img src="themes/images/ico-cart.png" alt="cart">
                ${fn:length(sessionScope.myCart.cartItems)} Item<c:if test="${fn:length(sessionScope.myCart.cartItems)>1}">s</c:if> 
                    in your cart  
                    <span class="badge badge-warning pull-right">$${sessionScope.myCart.totalPrice}</span>
                </a>
            </div>
    </c:if>

    <ul id="sideManu" class="nav nav-tabs nav-stacked">
        <!-- MODIFY Abdo print categories as list -->
        <c:forEach items="${categories}" var="category">
            <li>
                <a href="${pageContext.request.contextPath}/index.jsp?category=${category.categoryId}">
                    ${category.categoryName}</a>
            </li>
        </c:forEach>
        <!-- MODIFY Abdo print categories as list -->
    </ul>
    <br />
</div>



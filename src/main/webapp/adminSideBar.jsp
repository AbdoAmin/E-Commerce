<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="sidebar" class="span3">
    <ul id="sideManu" class="nav nav-tabs nav-stacked">
        <li><a href="${pageContext.request.contextPath}/addProduct.jsp">Castomers Profiles</a></li>
        <li><a href="${pageContext.request.contextPath}/addProduct.jsp">order history</a></li>
        <li><a href="${pageContext.request.contextPath}/addProduct.jsp">Add product</a></li> 
        <li><a href="${pageContext.request.contextPath}/editProduct.jsp">Edit product</a></li>
        <li><a href="${pageContext.request.contextPath}/addCategory.jsp">Add Category</a></li>
        <li><a href="${pageContext.request.contextPath}/editCategory.jsp">Edit Catefory</a></li>
    </ul>
    <br />
</div>
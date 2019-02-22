<%-- 
    Document   : CommonBody
    Created on : Feb 22, 2019, 12:44:45 AM
    Author     : Abdo Amin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/CategoriesServelet" /> 

<div id="sidebar" class="span3">
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
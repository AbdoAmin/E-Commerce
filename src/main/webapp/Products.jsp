<%-- 
    Document   : Product
    Created on : Feb 22, 2019, 2:11:12 PM
    Author     : Abdo Amin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div class="tab-content">
    <div class="tab-pane  active" id="blockView">
        <ul class="thumbnails">

            <c:forEach items="${products}" var="product" varStatus="loop">
                <c:url var="thisURL" value="product_details.jsp" scope="request">
                    <c:param name="productID" value="${product.id}"/>
                </c:url>
                <li class="span3">
                    <div class="thumbnail" >
                        <c:if test="${product.discount>0.00}">
                            <fmt:parseNumber var = "dis" integerOnly = "true" 
                                             type = "number" value = "${product.discount*100}" />
                            <i class="discount">-${dis}%</i>
                        </c:if>
                        <a href="<c:out value="${thisURL}"/>"><img src="data:image/jpeg;base64,${product.mainProductImage}"
                                                                   alt="" style="height: 250px;"/>
                        </a>
                        <div class="caption">
                            <h5>${product.name}</h5>
                            <h4 style="text-align:center">
                                <!--<a class="btn" href="<c:out value="${thisURL}"/>"> <i class="icon-zoom-in"></i></a>--> 
                                <a class="btn btn-primary" href="<c:out value="${thisURL}"/>">
                                    <c:set var="product" value="${product}" scope="request"/>
                                    <jsp:include page="/ShowPriceDiscount.jsp" />
                                </a>
                            </h4>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
        <hr class="soft"/>
    </div>
</div>

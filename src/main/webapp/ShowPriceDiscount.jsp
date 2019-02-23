<%-- 
    Document   : ShowPriceDiscount
    Created on : Feb 22, 2019, 10:55:54 PM
    Author     : Abdo Amin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!--MODIFY Abdo Add Price discount--> 
<fmt:parseNumber var = "baseNumber" integerOnly = "true" 
                 type = "number" value = "${product.price}" />
<fmt:parseNumber var = "dicimalNumber" integerOnly = "true" 
                 type = "number" value = "${(product.price-baseNumber)*100}" />
<fmt:parseNumber var = "baseDiscountNumber" integerOnly = "true" 
                 type = "number" value = "${product.price-(product.price*product.discount)}" />
<fmt:parseNumber var = "dicimalDiscountNumber" integerOnly = "true" 
                 type = "number" value = "${(product.price-(product.price*product.discount)-baseDiscountNumber)*100}" />

<c:choose>
    <c:when test="${product.discount!=0.00}">
        <div class="style-3">
            <del>
                <span class="amount">$${baseNumber},<sup>
                        <c:choose>
                            <c:when test="${dicimalNumber==0}">
                                <c:out value="00"/>
                            </c:when>    
                            <c:otherwise>
                                <c:out value="${dicimalNumber}"/>
                            </c:otherwise>
                        </c:choose>
                    </sup></span>
            </del>
            <ins>
                <span class="amount">$${baseDiscountNumber},<sup>
                        <c:choose>
                            <c:when test="${dicimalDiscountNumber==0}">
                                <c:out value="00"/>
                            </c:when>    
                            <c:otherwise>
                                <c:out value="${dicimalDiscountNumber}"/>
                            </c:otherwise>
                        </c:choose>
                    </sup></span>
            </ins>
        </div>
    </c:when>    
    <c:otherwise>
        <div class="style-3">
            <ins>
                <span class="amount">$${baseNumber},
                    <sup><c:choose>
                            <c:when test="${dicimalNumber==0}">
                                <c:out value="00"/>
                            </c:when>    
                            <c:otherwise>
                                <c:out value="${dicimalNumber}"/>
                            </c:otherwise>
                        </c:choose>
                    </sup></span>
            </ins>
        </div>
    </c:otherwise>
</c:choose>

<!--MODIFY Abdo Add Price discount-->  

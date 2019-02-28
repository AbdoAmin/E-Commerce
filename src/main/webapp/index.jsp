<%-- 
    Document   : index1
    Created on : Feb 22, 2019, 11:47:58 PM
    Author     : Abdo Amin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
    <jsp:include page="/HomeServlet" />

    <jsp:include page="/CommonHead.jsp" />

    <body> 
        <jsp:include page="/CommonHeader.jsp" />
        <!-- Header End====================================================================== -->
        <div id="mainBody">
            <div class="container">
                <div class="row">
                    <!-- Sidebar ================================================== -->
                    <jsp:include page="/CommonBody.jsp" />
                    <!--${err==null}-->
                    <!-- Sidebar end=============================================== -->
                    <div class="span9">
                        <c:if test="${user != null && fn:length(user.interests) >0 }">
                            <div class="well well-small">
                                <h4>Featured Products <small class="pull-right">200+ featured products</small></h4>
                                <div class="row-fluid">
                                    <div id="featured" class="carousel slide">
                                        <div class="carousel-inner">
                                            <c:set var="starter" value="0"/>
                                            <c:forEach items="${productsOfInterest}" step="3" varStatus="loop">
                                                <div class="item <c:if test="${loop.index == 0}"> active </c:if>">
                                                        <!--need to small for-->
                                                    <c:forEach items="${productsOfInterest}" var="product" begin="${starter}" end="${starter+3}" varStatus="loop">
                                                        <li class="span3">
                                                            <div class="thumbnail" style="height: 15rem; display: flex; flex-direction: column; justify-content: flex-end; padding-top: 2rem">
                                                                <i class="tag"></i>
                                                                <a href="${pageContext.request.contextPath}/product_details.jsp?productID=${product.id}"><img
                                                                        src="data:image/jpeg;base64,${product.mainProductImage}" alt=""></a>
                                                                <div class="caption">
                                                                    <h5>${product.name}</h5>
                                                                    <h4><a class="btn" href="${pageContext.request.contextPath}/product_details.jsp?productID=${product.id}">VIEW</a> <span
                                                                            class="pull-right">${product.price}</span></h4>
                                                                </div>
                                                            </div>
                                                        </li>
                                                    </c:forEach>
                                                </div>
                                            </c:forEach>
                                        </div>
                                        <a class="left carousel-control" href="#featured" data-slide="prev">‹</a>
                                        <a class="right carousel-control" href="#featured" data-slide="next">›</a>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <h4>Latest Products </h4>
                            <!-- MODIFY ashraf display products -->
                            <jsp:include page="/Products.jsp" />
                            <!-- MODIFY ashraf display products -->
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer ================================================================== -->
        <jsp:include page="/CommonFooter.jsp" />
    </body>
</html>

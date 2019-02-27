<%-- 
    Document   : product_details1
    Created on : Feb 22, 2019, 10:49:51 PM
    Author     : Abdo Amin
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <jsp:include page="/ProductDetailsServlet" />

    <jsp:include page="/CommonHead.jsp" />
    <link href="themes/css/discountText.css" rel="stylesheet">


    <body> 

        <jsp:include page="/CommonHeader.jsp" />
        <!-- Header End====================================================================== -->
        <div id="mainBody">
            <div class="container">
                <div class="row">
                    <!-- Sidebar ================================================== -->
                    <jsp:include page="/CommonBody.jsp" />
                    <!-- Sidebar end=============================================== -->
                    <div class="span9">
                        <ul class="breadcrumb">
                            <li><a href="index.jsp">Home</a> <span class="divider">/</span></li>
                            <li class="active">product Details</li>
                        </ul>	
                        <div class="row" style="margin: 0 !important;">	  
                            <!-- MODIFY Abdo Print Product Image -->
                            <div id="carouselBlk">
                                <div id="myCarousel" class="carousel slide">
                                    <div class="carousel-inner" >

                                        <c:forEach items="${requestScope.product.productImages}" var="image" varStatus="loop">
                                            <div class="item <c:if test="${loop.index==0}"><c:out value="active"/></c:if>">
                                                    <div class="container" style="height: 450px;">
                                                        <img style="width:100%;height:100%" src="data:image/jpeg;base64,${image}" alt=""/>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
                                    <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
                                </div>
                            </div>
                            <!-- MODIFY Abdo Print Product Image -->
                            <div class="span6">
                                <h3>${requestScope.product.name}</h3>

                                <hr class="soft">
                                <!--TODO Buy *Put In Cart*-->
                                <form class="form-horizontal qtyFrm" action="MyCart.jsp" method="get"> 
                                    <div class="control-group">

                                        <jsp:include page="/ShowPriceDiscount.jsp" />

                                        <div class="controls">
                                            <input type="hidden" name="id" value="${requestScope.product.id}"/>
                                            <input type="number" class="span1" min="1" max="${requestScope.product.quantity}" placeholder="Qty." name="quantity" required>
                                            <button type="submit" href="javascript:document.submitForm.submit()" class="btn btn-large btn-primary pull-right"> Add to cart <i class=" icon-shopping-cart"></i></button>
                                        </div>
                                    </div>
                                </form>

                                <hr class="soft">
                                <h4>${requestScope.product.quantity} items in stock</h4>

                                <hr class="soft clr">
                                <h3>Description</h3>
                                <p>
                                    ${requestScope.product.description}
                                </p>


                                <a href="#" name="detail"></a>
                                <hr class="soft">
                            </div>



                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer ================================================================== -->
        <jsp:include page="/CommonFooter.jsp" />
    </body>
</html>

<%-- 
    Document   : MyCart
    Created on : Feb 23, 2019, 6:32:28 PM
    Author     : Abdo Amin
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="en">

    <jsp:include page="/BuyServlet" />
    <jsp:include page="/CommonHead.jsp" />

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
                            <li class="active"> SHOPPING CART</li>
                        </ul>
                        <h3>  SHOPPING CART [ <small>${fn:length(sessionScope.myCart.cartItems)} Item<c:if test="${fn:length(sessionScope.myCart.cartItems)>1}">s</c:if> </small>]
                                <a href="index.jsp" class="btn btn-large pull-right"><i class="icon-arrow-left"></i> Continue Shopping </a></h3>	
                            <hr class="soft">
                            <table class="table table-bordered">
                            </table>		

                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th>Product</th>
                                        <th>Description</th>
                                        <th>Quantity/Update</th>
                                        <th>Price</th>
                                        <th>Discount</th>
                                        <th>Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${sessionScope.myCart.cartItems}" var="item">
                                    <tr>
                                        <td> <img width="60" style="height: 50px;" src="data:image/jpeg;base64,${item.product.productImages[0]}" alt=""></td>
                                        <td>${item.product.name}<br>${item.product.description}</td>
                                        <td>
                                            <div class="input-append"><input class="span1" style="max-width:34px" placeholder="${item.quantity}" id="appendedInputButtons" min="1" max="${item.product.quantity}" size="16" type="text" readonly>
                                                <a class="btn btn-danger" href = "CartRequestHandelerServelet?productIdToDelete=${item.product.id}" type="button"><i class="icon-remove icon-white"></i></a>
                                            </div>
                                        </td>
                                        <td>$${item.product.price}</td>
                                        <td>$${item.totalDiscount}</td>
                                        <td>$${item.totalPrice}</td>
                                    </tr>
                                </c:forEach>


                                <tr>
                                    <td colspan="5" style="text-align:right">Total Price:	</td>
                                    <td> $${sessionScope.myCart.totalPriceNDis}</td>
                                </tr>
                                <tr>
                                    <td colspan="5" style="text-align:right">Total Discount:	</td>
                                    <td> $${sessionScope.myCart.totalDiscount}</td>
                                </tr>
                                <tr>
                                    <td colspan="5" style="text-align:right"><strong>TOTAL ($${sessionScope.myCart.totalPriceNDis}-$${sessionScope.myCart.totalDiscount}) =</strong></td>
                                    <td class="label label-important" style="display:block"> <strong> $${sessionScope.myCart.totalPrice} </strong></td>
                                </tr>
                            </tbody>
                        </table>


                        <table class="table table-bordered">

                        </table>

                        <a href="index.jsp" class="btn btn-large"><i class="icon-arrow-left"></i> Continue Shopping </a>
                        <a href="<c:if test="${sessionScope.myCart.totalPrice<=sessionScope.user.creditLimit && fn:length(sessionScope.myCart.cartItems)>0}" >
                           CartRequestHandelerServelet?buy=${sessionScope.myCart.totalPrice}</c:if>" class="btn btn-large pull-right">Buy <i class="icon-arrow-right"></i></a>

                        </div>


                    </div>
                </div>
            </div>
            <!-- Footer ================================================================== -->

        <jsp:include page="/CommonFooter.jsp" />
    </body>
</html>
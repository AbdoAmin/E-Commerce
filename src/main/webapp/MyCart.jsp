<%-- 
    Document   : MyCart
    Created on : Feb 23, 2019, 6:32:28 PM
    Author     : Abdo Amin
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

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
                        <h3>  SHOPPING CART [ <small>3 Item(s) </small>]<a href="products.html" class="btn btn-large pull-right"><i class="icon-arrow-left"></i> Continue Shopping </a></h3>	
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
                                    <th>Tax</th>
                                    <th>Total</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td> <img width="60" src="themes/images/products/4.jpg" alt=""></td>
                                    <td>MASSA AST<br>Color : black, Material : metal</td>
                                    <td>
                                        <div class="input-append"><input class="span1" style="max-width:34px" placeholder="1" id="appendedInputButtons" size="16" type="text"><button class="btn" type="button"><i class="icon-minus"></i></button><button class="btn" type="button"><i class="icon-plus"></i></button><button class="btn btn-danger" type="button"><i class="icon-remove icon-white"></i></button>				</div>
                                    </td>
                                    <td>$120.00</td>
                                    <td>$25.00</td>
                                    <td>$15.00</td>
                                    <td>$110.00</td>
                                </tr>

                                <tr>
                                    <td colspan="6" style="text-align:right">Total Price:	</td>
                                    <td> $228.00</td>
                                </tr>
                                <tr>
                                    <td colspan="6" style="text-align:right">Total Discount:	</td>
                                    <td> $50.00</td>
                                </tr>
                                <tr>
                                    <td colspan="6" style="text-align:right">Total Tax:	</td>
                                    <td> $31.00</td>
                                </tr>
                                <tr>
                                    <td colspan="6" style="text-align:right"><strong>TOTAL ($228 - $50 + $31) =</strong></td>
                                    <td class="label label-important" style="display:block"> <strong> $155.00 </strong></td>
                                </tr>
                            </tbody>
                        </table>


                        <table class="table table-bordered">

                        </table>


                        <a href="products.html" class="btn btn-large"><i class="icon-arrow-left"></i> Continue Shopping </a>
                        <a href="login.html" class="btn btn-large pull-right">Next <i class="icon-arrow-right"></i></a>

                    </div>
                    
                    
                </div>
            </div>
        </div>
        <!-- Footer ================================================================== -->

        <jsp:include page="/CommonFooter.jsp" />
    </body>
</html>
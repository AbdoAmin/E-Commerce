<%-- 
    Document   : Common
    Created on : Feb 22, 2019, 12:19:49 AM
    Author     : Abdo Amin
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <jsp:include page="/DiscountProducts" />

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

                    <!-- MODIFY Abdo print categories as list -->
                    <div class="span9">
                        <ul class="breadcrumb">
                            <li><a href="error.html">Home</a> <span class="divider">/</span></li>
                            <li class="active">Special offers</li>
                        </ul>
                        <jsp:include page="/Products.jsp" />
                    </div>
                    <!-- MODIFY Abdo print categories as list -->
                </div>
            </div>
        </div>
        <!-- Footer ================================================================== -->
        <jsp:include page="/CommonFooter.jsp" />
    </body>
</html>

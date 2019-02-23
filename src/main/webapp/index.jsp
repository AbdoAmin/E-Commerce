<%-- 
    Document   : index1
    Created on : Feb 22, 2019, 11:47:58 PM
    Author     : Abdo Amin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <!-- Sidebar end=============================================== -->
                    <div class="span9">
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

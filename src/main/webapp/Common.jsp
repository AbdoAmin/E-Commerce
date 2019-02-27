<%-- 
    Document   : Common
    Created on : Feb 22, 2019, 12:19:49 AM
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
                        
                        
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer ================================================================== -->
        
        <jsp:include page="/CommonFooter.jsp" />
    </body>
</html>

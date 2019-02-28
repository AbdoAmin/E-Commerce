<%-- 
    Document   : TempHistory
    Created on : Feb 23, 2019, 5:51:22 PM
    Author     : Tahoon
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <!--TODO change homeservlet to gategori servlet or put inside it*Body*-->
    <jsp:include page="/CategoriesServelet" /> 

    <jsp:include page="/CommonHead.jsp" />

    <body> 

        <jsp:include page="/CommonHeader.jsp" />
        <!-- Header End====================================================================== -->
        <div id="mainBody">
            <div class="container">
                <div class="row">
                    <!-- Sidebar ================================================== -->
                    <jsp:include page="/adminSideBar.jsp" />
                    <!-- Sidebar end=============================================== -->

                   
                    
                    
                    
                    <div class="span9">
                        <div class="well well-small">


                            <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                            <jsp:include page="/GetAllHistoryServlet"/>
                            <table class="table table-bordered">

                                <thead>
                                    <tr>
                                        <th>Order History ID</th>
                                        <th>Order Date</th>
                                        <th>User ID</th>


                                    </tr>
                                </thead>
                                <tbody>
                                    <c:if test="${!empty requestScope.history}">

                                        <c:forEach items="${requestScope.history}" var="history">
                                            <tr>
                                                <td>
                                                    <p>${history.orderHistoryId}</p>
                                                </td>
                                                <td>
                                                    <p>${history.orderDate}</p>
                                                </td>
                                                <td>
                                                    <p>${history.userId}</p>
                                                </td>                         
                                            </tr>
                                        </c:forEach>
                                    </c:if>                           
                                </tbody>

                            </table>
                        </div>
                    </div>
                            
                            
                            
                         
                </div>
            </div>
        </div>
        <!-- Footer ================================================================== -->
        <jsp:include page="/CommonFooter.jsp" />
    </body>
</html>

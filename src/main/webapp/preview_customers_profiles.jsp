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
    <jsp:include page="/PreviewAllCustomersServlet" /> 

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
                                        <th>Profile Image</th>
                                        <th>First Name</th>
                                        <th>Last Name</th>
                                        <th>Job</th>
                                        <th>Email</th>
                                        <th>Phone</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:if test="${customers!=null}">

                                        <c:forEach items="${customers}" var="customer">
                                            <tr>
                                                <td>
                                                    <img src="data:image/jpeg;base64,${customer.profileImage}" width="60"  height="60"alt=""/>
                                                </td>
                                                <td>
                                                    <p>${customer.firstName}</p>
                                                </td>
                                                <td>
                                                    <p>${customer.lastName}</p>
                                                </td>
                                                <td>
                                                    <p>${customer.job}</p>
                                                </td>                         
                                                <td>
                                                    <p>${customer.email}</p>
                                                </td>                         
                                                <td>
                                                    <p>${customer.phone}</p>
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

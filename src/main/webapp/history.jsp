<%-- 
    Document   : history
    Created on : Feb 21, 2019, 8:31:57 PM
    Author     : Tahoon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html lang="en">
    <jsp:include page="/GetAllHistoryServlet"/>

<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <table align="center"
                   border="1">
            <thead>

                <tr>
                    <td>orederHistoryId</td>
                    <td>orederDate</td>
                    <td>userId</td>

                   
                </tr>
            </thead>
            <tbody>

                <!--<c:if test="${!empty requestScope.allHistoryAdmin}">-->

            <c:forEach items="${requestScope.allHistoryAdmin}" var="history">
                        <tr>
                           <td>
                                <p>${history.orederHistoryId}</p>
                            </td>
                            <td>
                                <p>${history.orederDate}</p>
                            </td>
                              <td>
                                <p>${history.userId}</p>
                            </td>                         
                        </tr>
                    </c:forEach>
                </c:if>


            </tbody>
        </table>
</html>

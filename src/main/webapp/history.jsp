<%-- 
    Document   : history
    Created on : Feb 21, 2019, 8:31:57 PM
    Author     : Tahoon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <jsp:include page="/GetAllHistoryServlet"/>



    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <table align="center"
           border="1">

        <tr>
            <th>orederHistoryId</th>
            <th>orederDate</th>
            <th>userId</th>
        </tr>

        <c:forEach items="${requestScope.history}" var="history">
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
    </table>
</html>

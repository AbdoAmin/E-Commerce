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
                <jsp:include page="/adminSideBar.jsp" />
                <!-- Sidebar end=============================================== -->

            </div>
        </div>
    </div>
    <!-- Footer ================================================================== -->
    <div id="footerSection">
        <jsp:include page="/CommonFooter.jsp" />
    </div>
</body>

</html>
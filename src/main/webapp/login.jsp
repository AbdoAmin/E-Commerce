<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <jsp:include page="/CommonHead.jsp" />

<body>
    <jsp:include page="/CommonHeader.jsp" />
    <!-- Header End====================================================================== -->
    <div id="mainBody">
        <div class="container">
            <div class="span9" style="margin: 0 auto;float: none;">
                <ul class="breadcrumb">
                    <li><a href="index.jsp">Home</a><span class="divider">/</span></li>
                    <li class="active">Login</li>
                </ul>
                <h3> Login</h3>
                <hr class="soft" />
                <div class="row" style="margin: 0 auto;float: none;">
                    <div class="span4" style="margin: 0 auto;float: none;">
                        <div class="well">
                            <!--modify sallam: added action to the LoginServlet-->
                            <form action="LoginServlet" method="POST">
                                <div class="control-group">
                                    <label class="control-label" for="inputEmail1">Email</label>
                                    <div class="controls">
                                        <input name="email" class="span3" required="true" type="email" id="inputEmail1"
                                            placeholder="Email">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="inputPassword1">Password</label>
                                    <div class="controls">
                                        <input name="password" type="password" required="true" class="span3"
                                            id="inputPassword1" placeholder="Password">
                                    </div>
                                </div>
                                <c:if test="${param.error != null}">
                                    <div class="control-group">
                                        <label class="control-label" for="inputPassword1" style="color: red;">* invalid email or password</label>
                                    </div>
                                </c:if>

                                    <div class="control-group">
                                        <div class="controls">
                                            <input type="submit" class="btn" value="Sign in" />
                                            OR <a href="register.jsp" class="btn">Register Now!</a>
                                        </div>
                                    </div>
                                </form>
                                <%--<c:set var="myparam" value="<%= request.getParameter("myparam")%>" />--%>
                                <%--<c:if test="${myparam == 'invalid'}">--%>
                                    <!--<span>invalid email or password</span>-->
                                <%--</c:if>--%>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- MainBody End ============================= -->
    <!-- Footer ================================================================== -->
    <div id="footerSection">
        <jsp:include page="/CommonFooter.jsp" />
    </div>
</body>

</html>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="en">

    <c:if test="${empty categories}">
        <jsp:include page="/CategoriesServelet" /> 
    </c:if>
    <jsp:include page="/CommonHead.jsp" />

    <body>
        <jsp:include page="/CommonHeader.jsp" />
        <!-- Header End====================================================================== -->
        <div id="mainBody">
            <div class="container">
                <div class="span9" style="margin: 0 auto;float: none;">
                    <ul class="breadcrumb">
                        <li><a href="index.jsp">Home</a><span class="divider">/</span></li>
                        <li class="active">Interesting</li>
                    </ul>
                    <h3>Interesting in</h3>
                    <hr class="soft" />
                    <div class="row" style="margin: 0 auto;float: none;">
                        <div class="span4" style="margin: 0 auto;float: none;">
                            <div class="well">
                                <!--modify sallam: added action to the LoginServlet-->
                                <form action="InterestingCategoriesServlet" method="POST">
                                    <div class="control-group">
                                        <input type="hidden" name='userId' value='${param.userId}'>
                                        <input type="hidden" name='size' value='${fn:length(categories)}'>
                                        <c:forEach items="${categories}" var="category" varStatus="loop">
                                            <input type="checkbox" name='c${loop.index}' value='${category.categoryId}'>
                                            ${category.categoryName}
                                            <br>
                                            <br>
                                        </c:forEach>

                                        <br> <br>
                                        <center>
                                            <button type="submit" href="javascript:document.submitForm.submit()" class="btn btn-large btn-primary "> Follow These Categories </button>
                                        </center>
                                        <br> <br>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- MainBody End ============================= -->
        <!-- Footer ================================================================== -->
        <jsp:include page="/CommonFooter.jsp" />
    </body>

</html>
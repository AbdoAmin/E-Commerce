<!DOCTYPE html>
<html lang="en">

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="/CommonHead.jsp" />
    <jsp:include page="/HomeServlet" />
    <jsp:include page="/EditProductServlet" />

    <body>
        <jsp:include page="/CommonHeader.jsp" />
        <!-- Header End====================================================================== -->
        <div id="mainBody">
            <div class="container">
                <div class="row">
                    <!-- Sidebar ================================================== -->
                    <jsp:include page="/adminSideBar.jsp" />
                    <!-- Sidebar end=============================================== -->
                    <div class="span9"">
                        <ul class=" breadcrumb">
                            <li><a href="${pageContext.request.contextPath}/index.jsp">Home</a> <span class="divider">/</span>
                            </li>
                            <li class="active">delete Product</li>
                        </ul>
                        <h3> delete Product</h3>
                        <div class="well" style="margin:0 auto; float: none;">
                            <c:if test="${product == null}">
                                <form class="form-horizontal" method="POST"
                                      action="${pageContext.request.contextPath}/DeleteProductServlet">
                                    <h4>Choose one product to delete it</h4>
                                    <select class="srchTxt" name="productId" style="margin-left: 15% !important;" required>
                                        <c:forEach items="${products}" var="product">
                                            <option value="${product.id}">${product.name}</option>
                                        </c:forEach>
                                    </select>
                                    <button type="submit" id="submitButton" class="btn btn-primary">Delete</button>
                                </form>
                            </c:if>
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
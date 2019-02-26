<!DOCTYPE html>
<html lang="en">

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="/CommonHead.jsp" />
    <jsp:include page="/HomeServlet" />
    <jsp:include page="/EditCategoryServlet" />

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
                            <li class="active">Edit Category</li>
                        </ul>
                        <h3> Edit Category</h3>
                        <div class="well" style="margin:0 auto; float: none;">
                            <c:if test="${category == null}">
                                <form class="form-horizontal" method="GET"
                                      action="${pageContext.request.contextPath}/editCategory.jsp">
                                    <h4>Choose one category to edit it</h4>
                                    <select class="srchTxt" name="categoryId" style="margin-left: 15% !important;">
                                        <c:forEach items="${categories}" var="category">
                                            <option value="${category.categoryId}">${category.categoryName}</option>
                                        </c:forEach>
                                    </select>
                                    <button type="submit" id="submitButton" class="btn btn-primary">Edit</button>
                                </form>
                            </c:if>
                            <c:if test="${category != null}">
                                <form class="form-horizontal" method="POST"
                                      action="${pageContext.request.contextPath}/EditCategoryServlet">
                                    <h4>category information</h4>

                                    <div class="control-group">
                                        <label class="control-label" for="inputFname1">Name<sup>*</sup></label>
                                        <div class="controls">
                                            <input type="text" id="inputFname1" placeholder="Name" name="categoryName"
                                                   value="${category.categoryName}" />
                                        </div>
                                    </div>
                                    <input type="hidden" placeholder="Name" name="categoryId" value="${category.categoryId}" />

                                    <div style="display: none;" class="alert alert-block alert-error fade in">
                                        <button type="button" class="close" data-dismiss="alert">×</button>
                                        <strong>Lorem Ipsum is simply</strong> dummy text of the printing and typesetting
                                        industry. Lorem Ipsum
                                        has been the industry's standard dummy text ever since the 1500s
                                    </div>
                                    <div class="control-group">
                                        <div class="controls">
                                            <input class="btn btn-large btn-success" type="submit" value="Save Changes" />
                                        </div>
                                    </div>
                                </form>
                            </c:if>
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
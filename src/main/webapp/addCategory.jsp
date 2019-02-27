<!DOCTYPE html>
<html lang="en">

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="/CommonHead.jsp" />
    <jsp:include page="/HomeServlet" />

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
                            <li class="active">Add Category</li>
                        </ul>
                        <h3> Add Category</h3>
                        <div class="well" style="margin:0 auto; float: none;">
                            <form class="form-horizontal" method="POST"
                                  action="${pageContext.request.contextPath}/AddCategoryServlet">
                                <h4>Category information</h4>
                                <div class="control-group">
                                    <label class="control-label" for="inputFname1">Name<sup>*</sup></label>
                                    <div class="controls">
                                        <input type="text" id="inputFname1" placeholder="Name" name="categoryName" required>
                                    </div>
                                </div>

                                <div style="display: none;" class="alert alert-block alert-error fade in">
                                    <button type="button" class="close" data-dismiss="alert">×</button>
                                    <strong>Lorem Ipsum is simply</strong> dummy text of the printing and typesetting
                                    industry. Lorem Ipsum
                                    has been the industry's standard dummy text ever since the 1500s
                                </div>
                                <div class="control-group">
                                    <div class="controls">
                                        <input class="btn btn-large btn-success" type="submit" value="Add Category" />
                                    </div>
                                </div>
                            </form>
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
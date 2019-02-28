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
                    <li class="active">Add Product</li>
                    </ul>
                    <h3> Add Product</h3>
                    <div class="well" style="margin:0 auto; float: none;">
                        <form class="form-horizontal" method="POST"
                            action="${pageContext.request.contextPath}/AddProductServlet" enctype="multipart/form-data">
                            <h4>Product information</h4>

                            <div class="control-group">
                                <label class="control-label" for="inputFname1">Image<sup>*</sup></label>
                                <div class="controls">
                                    <input type="file" name="image1" required/>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="inputFname1">Image</label>
                                <div class="controls">
                                    <input type="file" name="image2" />
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="inputFname1">Image</label>
                                <div class="controls">
                                    <input type="file" name="image3" />
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="inputFname1">Image</label>
                                <div class="controls">
                                    <input type="file" name="image4" />
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="inputFname1">Name<sup>*</sup></label>
                                <div class="controls">
                                    <input type="text" id="inputFname1" placeholder="Name" name="name" required>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="inputLnam">Price<sup>*</sup></label>
                                <div class="controls">
                                    <input type="text" id="inputLnam" placeholder="Price" name="price" required>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="input_email">Discount <sup>*</sup></label>
                                <div class="controls">
                                    <input type="text" id="input_email" placeholder="Discount" name="discount" required>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="inputPassword1">Quantity <sup>*</sup></label>
                                <div class="controls">
                                    <input type="text" id="inputPassword1" placeholder="Quantity" name="quantity" required>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Category Name<sup>*</sup></label>
                                <div class="controls">
                                    <select name="categoryId" required>
                                        <c:forEach items="${categories}" var="category">
                                            <option value="${category.categoryId}">${category.categoryName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="input_email">Description <sup>*</sup></label>
                                <div class="controls">
                                    <input type="text" id="input_email" placeholder="Description" name="description" required>
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
                                    <input class="btn btn-large btn-success" type="submit" value="Add Product" />
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
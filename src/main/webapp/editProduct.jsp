<!DOCTYPE html>
<html lang="en">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/CommonHead.jsp" />
<jsp:include page="/EditProductServlet" />
<jsp:include page="/HomeServlet" />

<body>
	<jsp:include page="/CommonHeader.jsp" />
	<!-- Header End====================================================================== -->
	<div id="mainBody">
		<div class="container">
			<div class="row">
				<div class="span9" style="margin: 0 auto; float: none; ">
					<ul class="breadcrumb">
						<li><a href="${pageContext.request.contextPath}/index.jsp">Home</a> <span
								class="divider">/</span></li>
						<li class="active">Edit Product</li>
					</ul>
					<h3> Edit Product</h3>
					<div class="well" style="margin:0 auto; float: none;">
						<form class="form-horizontal" method="POST"
							action="${pageContext.request.contextPath}/EditProductServlet" enctype="multipart/form-data">
							<h4>Product information</h4>

							<div class="control-group">
								
								<label class="control-label" for="inputFname1">Image<sup>*</sup></label>
								<div class="controls">
									<input type="file" name="image1" />
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
									<input type="text" id="inputFname1" placeholder="Name" name="name" value="${product.name}"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputLnam">Price<sup>*</sup></label>
								<div class="controls">
									<input type="text" id="inputLnam" placeholder="Price" name="price" value="${product.price}"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="input_email">Discount <sup>*</sup></label>
								<div class="controls">
									<input type="text" id="input_email" placeholder="Discount" name="discount" value="${product.discount}"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputPassword1">Quantity <sup>*</sup></label>
								<div class="controls">
									<input type="text" id="inputPassword1" placeholder="Quantity" name="quantity" value="${product.quantity}"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Category Name<sup>*</sup></label>
								<div class="controls">
									<select name="categoryId">
										<c:forEach items="${categories}" var="category">
											<c:if test="${category.categoryId eq product.id}">
												<option value="${category.categoryId}">${category.categoryName}</option>
											</c:if>
										</c:forEach>
										<c:forEach items="${categories}" var="category">
											<option value="${category.categoryId}">${category.categoryName}</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="input_email">Description <sup>*</sup></label>
								<div class="controls">
									<input type="text" id="input_email" placeholder="Description" name="description"  value="${product.description}"/>
								</div>
							</div>
							<input type="hidden" id="input_email"name="id"  value="${product.id}"/>


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
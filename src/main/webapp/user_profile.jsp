<%-- 
    Document   : index1
    Created on : Feb 22, 2019, 11:47:58 PM
    Author     : Abdo Amin
--%>

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
                    <jsp:include page="/CommonBody.jsp" />
                    <div class="span9">
                        <form method="post">
                            <div class="span8">
                                <div class="col-md-4">
                                    <div style="float: null !important;">
                                        <!--<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS52y5aInsxSm31CvHOFHWujqUx_wWTS9iM6s7BAm21oEN_RiGoog" alt=""/>-->
                                        <img src="data:image/jpeg;base64,${user.profileImage}" alt=""/>
                                        <a href="user_edit_profile.jsp">
                                            <input style="float: right;" type="button" class="profile-edit-btn" name="btnAddMore" value="Edit Profile"/>
                                        </a>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="profile-head">
                                        <h5>
                                            ${user.firstName} ${user.lastName}
                                        </h5>
                                        <h6>
                                            ${user.job}
                                        </h6>
                                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                                            <li class="nav-item">
                                                <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">About</a>
                                            </li>

                                        </ul>
                                    </div>
                                </div>

                            </div>
                            <div class="span8">
                                <div class="col-md-6">
                                    <div id="myTabContent" class="span8">
                                        <div class="row">
                                            <div style="float: null !important;">
                                                <label style="float: left"><strong>Email</strong></label><label style="float: right">${user.email}</label>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label style="float: left"><strong>Birth Date</strong></label><p style="float: right">${user.birthDate}</p>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6">
                                                <label style="float: left"><strong>Address</strong></label><p style="float: right">${user.address}</p>
                                            </div>

                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label style="float: left"><strong>Credit Limit</strong></label><p style="float: right">${user.creditLimit}</p>
                                            </div>

                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label style="float: left"><strong>Phone</strong></label><p style="float: right">${user.phone}</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>           
                    </div>
                </div>
            </div>
            <!-- Footer ================================================================== -->
            <jsp:include page="/CommonFooter.jsp" />
    </body>
</html>

<html>

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <!--<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>-->
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!--<link rel="stylesheet" tyle="text/css" href="user_progile_css.css" />-->
    <jsp:include page="/CommonHead.jsp" />

    <!------ Include the above in your HEAD tag ---------->

    <body>
        <jsp:include page="/CommonHeader.jsp" />
        <div class="container emp-profile">
            <form method="post">
                <div class="row">
                    <div class="col-md-4">
                        <div class="profile-img">
                            <!--<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS52y5aInsxSm31CvHOFHWujqUx_wWTS9iM6s7BAm21oEN_RiGoog" alt=""/>-->
                            <img src="data:image/jpeg;base64,${user.profileImage}" alt=""/>
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
                                <li class="nav-item">
                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Timeline</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-2">
                        <a href="user_edit_profile.jsp">
                            <input type="button" class="profile-edit-btn" name="btnAddMore" value="Edit Profile"/>
                        </a>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">

                    </div>
                    <div class="col-md-8">
                        <div  id="myTabContent">
                            <!--<div class="tab-/pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">-->

                            <div class="row">
                                <div class="col-md-6">
                                    <label>Email</label>
                                </div>
                                <div class="col-md-6">
                                    <p>${user.email}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Birth Date</label>
                                </div>
                                <div class="col-md-6">
                                    <p>${user.birthDate}</p>
                                </div>
                            </div>

                            <!--</div>-->
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Address</label>
                                </div>
                                <div class="col-md-6">
                                    <p>${user.address}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Credit Limit</label>
                                </div>
                                <div class="col-md-6">
                                    <p>${user.creditLimit}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Phone</label>
                                </div>
                                <div class="col-md-6">
                                    <p>${user.phone}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>           
        </div>
        <jsp:include page="/CommonFooter.jsp" />
    </body>

</html>
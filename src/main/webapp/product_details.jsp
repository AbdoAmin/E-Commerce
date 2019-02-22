<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
    <jsp:include page="/ProductDetailsServlet" />
    <head>
        <meta charset="utf-8">
        <title>Bootshop online Shopping cart</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <!--Less styles -->
        <!-- Other Less css file //different less files has different color scheam
             <link rel="stylesheet/less" type="text/css" href="themes/less/simplex.less">
             <link rel="stylesheet/less" type="text/css" href="themes/less/classified.less">
             <link rel="stylesheet/less" type="text/css" href="themes/less/amelia.less">  MOVE DOWN TO activate
        -->
        <!--<link rel="stylesheet/less" type="text/css" href="themes/less/bootshop.less">
        <script src="themes/js/less.js" type="text/javascript"></script> -->


        <!-- Bootstrap style --> 
        <link id="callCss" rel="stylesheet" href="themes/bootshop/bootstrap.min.css" media="screen">
        <link href="themes/css/base.css" rel="stylesheet" media="screen">
        <!-- Bootstrap style responsive -->	
        <link href="themes/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link href="themes/css/font-awesome.css" rel="stylesheet" type="text/css">
        <!-- Google-code-prettify -->	
        <link href="themes/js/google-code-prettify/prettify.css" rel="stylesheet">
        <!-- fav and touch icons -->
        <link rel="shortcut icon" href="themes/images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="themes/images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="themes/images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="themes/images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="themes/images/ico/apple-touch-icon-57-precomposed.png">
        <style type="text/css" id="enject"></style>

        <!--MODIFY Abdo Add Price discount-->  
        <link href="themes/css/discountText.css" rel="stylesheet">
        <!--MODIFY Abdo Add Price discount-->  
    </head>
    <body>
        <div id="header">
            <div class="container">
                <div id="welcomeLine" class="row">
                    <div class="span6">Welcome!<strong> User</strong></div>
                    <div class="span6">
                        <div class="pull-right">
                            <a href="product_summary.html"><span class="">Fr</span></a>
                            <a href="product_summary.html"><span class="">Es</span></a>
                            <span class="btn btn-mini">En</span>
                            <a href="product_summary.html"><span>�</span></a>
                            <span class="btn btn-mini">$155.00</span>
                            <a href="product_summary.html"><span class="">$</span></a>
                            <a href="product_summary.html"><span class="btn btn-mini btn-primary"><i class="icon-shopping-cart icon-white"></i> [ 3 ] Itemes in your cart </span> </a> 
                        </div>
                    </div>
                </div>
                <!-- Navbar ================================================== -->
                <div id="logoArea" class="navbar">
                    <a id="smallScreen" data-target="#topMenu" data-toggle="collapse" class="btn btn-navbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <div class="navbar-inner">
                        <a class="brand" href="index.html"><img src="themes/images/logo.png" alt="Bootsshop"></a>
                        <form class="form-inline navbar-search" method="post" action="products.html">
                            <input id="srchFld" class="srchTxt" type="text">
                            <select class="srchTxt">
                                <option>All</option>
                                <option>CLOTHES </option>
                                <option>FOOD AND BEVERAGES </option>
                                <option>HEALTH &amp; BEAUTY </option>
                                <option>SPORTS &amp; LEISURE </option>
                                <option>BOOKS &amp; ENTERTAINMENTS </option>
                            </select> 
                            <button type="submit" id="submitButton" class="btn btn-primary">Go</button>
                        </form>
                        <ul id="topMenu" class="nav pull-right">
                            <li class=""><a href="special_offer.html">Specials Offer</a></li>
                            <li class=""><a href="normal.html">Delivery</a></li>
                            <li class=""><a href="contact.html">Contact</a></li>
                            <li class="">
                                <a href="#login" role="button" data-toggle="modal" style="padding-right:0"><span class="btn btn-large btn-success">Login</span></a>
                                <div id="login" class="modal hide fade in" tabindex="-1" role="dialog" aria-labelledby="login" aria-hidden="false">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">�?</button>
                                        <h3>Login Block</h3>
                                    </div>
                                    <div class="modal-body">
                                        <form class="form-horizontal loginFrm">
                                            <div class="control-group">								
                                                <input type="text" id="inputEmail" placeholder="Email">
                                            </div>
                                            <div class="control-group">
                                                <input type="password" id="inputPassword" placeholder="Password">
                                            </div>
                                            <div class="control-group">
                                                <label class="checkbox">
                                                    <input type="checkbox"> Remember me
                                                </label>
                                            </div>
                                        </form>		
                                        <button type="submit" class="btn btn-success">Sign in</button>
                                        <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- Header End====================================================================== -->
        <div id="mainBody">
            <div class="container">
                <div class="row">


                    <!-- Sidebar ================================================== -->
                    <div id="sidebar" class="span3">
                        <div class="well well-small"><a id="myCart" href="product_summary.html"><img src="themes/images/ico-cart.png" alt="cart">3 Items in your cart  <span class="badge badge-warning pull-right">$155.00</span></a></div>
                        <ul id="sideManu" class="nav nav-tabs nav-stacked">
                            <!-- MODIFY Abdo print categories as list -->
                            <c:forEach items="${categories}" var="category">
                                <li>
                                    <a href="${pageContext.request.contextPath}/index.jsp?category=${category.categoryId}">
                                        ${category.categoryName}</a>
                                </li>
                            </c:forEach>
                            <!-- MODIFY Abdo print categories as list -->
                        </ul>
                        <br />
                    </div>
                    <!-- Sidebar end=============================================== -->
                    <div class="span9">
                        <ul class="breadcrumb">
                            <li><a href="index.html">Home</a> <span class="divider">/</span></li>
                            <li><a href="products.html">Products</a> <span class="divider">/</span></li>
                            <li class="active">product Details</li>
                        </ul>	
                        <div class="row" style="margin: 0 !important;">	  
                            <!-- MODIFY Abdo Print Product Image -->
                            <div id="carouselBlk">
                                <div id="myCarousel" class="carousel slide">
                                    <div class="carousel-inner">

                                        <c:forEach items="${requestScope.product.productImages}" var="image" varStatus="loop">
                                            <div class="item <c:if test="${loop.index==0}"><c:out value="active"/></c:if>">
                                                    <div class="container">
                                                        <img style="width:100%" src="data:image/jpeg;base64,${image}" alt=""/>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
                                    <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
                                </div>
                            </div>
                            <!-- MODIFY Abdo Print Product Image -->
                            <div class="span6">
                                <h3>${requestScope.product.name}</h3>

                                <hr class="soft">
                                <form class="form-horizontal qtyFrm">
                                    <div class="control-group">
                                        <!--MODIFY Abdo Add Price discount--> 
                                        <fmt:parseNumber var = "baseNumber" integerOnly = "true" 
                                                         type = "number" value = "${requestScope.product.price}" />
                                        <fmt:parseNumber var = "dicimalNumber" integerOnly = "true" 
                                                         type = "number" value = "${(requestScope.product.price-baseNumber)*100}" />
                                        <fmt:parseNumber var = "baseDiscountNumber" integerOnly = "true" 
                                                         type = "number" value = "${requestScope.product.price-(requestScope.product.price*requestScope.product.discount)}" />
                                        <fmt:parseNumber var = "dicimalDiscountNumber" integerOnly = "true" 
                                                         type = "number" value = "${(requestScope.product.price-(requestScope.product.price*requestScope.product.discount)-baseDiscountNumber)*100}" />

                                        <c:choose>
                                            <c:when test="${requestScope.product.discount!=0.00}">
                                                <div class="style-3">
                                                    <del>
                                                        <span class="amount">$${baseNumber},<sup>
                                                                <c:choose>
                                                                    <c:when test="${dicimalNumber==0}">
                                                                        <c:out value="00"/>
                                                                    </c:when>    
                                                                    <c:otherwise>
                                                                        <c:out value="${dicimalNumber}"/>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </sup></span>
                                                    </del>
                                                    <ins>
                                                        <span class="amount">$${baseDiscountNumber},<sup>
                                                                <c:choose>
                                                                    <c:when test="${dicimalDiscountNumber==0}">
                                                                        <c:out value="00"/>
                                                                    </c:when>    
                                                                    <c:otherwise>
                                                                        <c:out value="${dicimalDiscountNumber}"/>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </sup></span>
                                                    </ins>
                                                </div>
                                            </c:when>    
                                            <c:otherwise>
                                                <div class="style-3">
                                                    <ins>
                                                        <span class="amount">$${baseNumber},
                                                            <sup><c:choose>
                                                                    <c:when test="${dicimalNumber==0}">
                                                                        <c:out value="00"/>
                                                                    </c:when>    
                                                                    <c:otherwise>
                                                                        <c:out value="${dicimalNumber}"/>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </sup></span>
                                                    </ins>
                                                </div>
                                            </c:otherwise>
                                        </c:choose>

                                        <!--MODIFY Abdo Add Price discount-->  
<!--                                        <label class="control-label"><span>$${requestScope.product.price}</span></label>-->
                                        <div class="controls">
                                            <input type="number" class="span1" placeholder="Qty.">
                                            <button type="submit" class="btn btn-large btn-primary pull-right"> Add to cart <i class=" icon-shopping-cart"></i></button>
                                        </div>
                                    </div>
                                </form>

                                <hr class="soft">
                                <h4>${requestScope.product.quantity} items in stock</h4>

                                <hr class="soft clr">
                                <h3>Description</h3>
                                <p>
                                    ${requestScope.product.description}
                                </p>


                                <a href="#" name="detail"></a>
                                <hr class="soft">
                            </div>



                        </div>
                    </div>
                </div> </div>
        </div>
        <!-- MainBody End ============================= -->


        <!-- Footer ================================================================== -->
        <div id="footerSection">
            <div class="container">
                <div class="row">
                    <div class="span3">
                        <h5>ACCOUNT</h5>
                        <a href="login.html">YOUR ACCOUNT</a>
                        <a href="login.html">PERSONAL INFORMATION</a> 
                        <a href="login.html">ADDRESSES</a> 
                        <a href="login.html">DISCOUNT</a>  
                        <a href="login.html">ORDER HISTORY</a>
                    </div>
                    <div class="span3">
                        <h5>INFORMATION</h5>
                        <a href="contact.html">CONTACT</a>  
                        <a href="register.html">REGISTRATION</a>  
                        <a href="legal_notice.html">LEGAL NOTICE</a>  
                        <a href="tac.html">TERMS AND CONDITIONS</a> 
                        <a href="faq.html">FAQ</a>
                    </div>
                    <div class="span3">
                        <h5>OUR OFFERS</h5>
                        <a href="#">NEW PRODUCTS</a> 
                        <a href="#">TOP SELLERS</a>  
                        <a href="special_offer.html">SPECIAL OFFERS</a>  
                        <a href="#">MANUFACTURERS</a> 
                        <a href="#">SUPPLIERS</a> 
                    </div>
                    <div id="socialMedia" class="span3 pull-right">
                        <h5>SOCIAL MEDIA </h5>
                        <a href="#"><img width="60" height="60" src="themes/images/facebook.png" title="facebook" alt="facebook"></a>
                        <a href="#"><img width="60" height="60" src="themes/images/twitter.png" title="twitter" alt="twitter"></a>
                        <a href="#"><img width="60" height="60" src="themes/images/youtube.png" title="youtube" alt="youtube"></a>
                    </div> 
                </div>
                <p class="pull-right">� Bootshop</p>
            </div><!-- Container End -->
        </div>
        <!-- Placed at the end of the document so the pages load faster ============================================= -->
        <script src="themes/js/jquery.js" type="text/javascript"></script>
        <script src="themes/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="themes/js/google-code-prettify/prettify.js"></script>

        <script src="themes/js/bootshop.js"></script>
        <script src="themes/js/jquery.lightbox-0.5.js"></script>

        <!-- Themes switcher section ============================================================================================= -->
        <div id="secectionBox">
            <link rel="stylesheet" href="themes/switch/themeswitch.css" type="text/css" media="screen">
            <script src="themes/switch/theamswitcher.js" type="text/javascript" charset="utf-8"></script>
            <div id="themeContainer">
                <div id="hideme" class="themeTitle">Style Selector</div>
                <div class="themeName">Oregional Skin</div>
                <div class="images style">
                    <a href="themes/css/#" name="bootshop"><img src="themes/switch/images/clr/bootshop.png" alt="bootstrap business templates" class="active"></a>
                    <a href="themes/css/#" name="businessltd"><img src="themes/switch/images/clr/businessltd.png" alt="bootstrap business templates" class="active"></a>
                </div>
                <div class="themeName">Bootswatch Skins (11)</div>
                <div class="images style">
                    <a href="themes/css/#" name="amelia" title="Amelia"><img src="themes/switch/images/clr/amelia.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="spruce" title="Spruce"><img src="themes/switch/images/clr/spruce.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="superhero" title="Superhero"><img src="themes/switch/images/clr/superhero.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="cyborg"><img src="themes/switch/images/clr/cyborg.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="cerulean"><img src="themes/switch/images/clr/cerulean.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="journal"><img src="themes/switch/images/clr/journal.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="readable"><img src="themes/switch/images/clr/readable.png" alt="bootstrap business templates"></a>	
                    <a href="themes/css/#" name="simplex"><img src="themes/switch/images/clr/simplex.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="slate"><img src="themes/switch/images/clr/slate.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="spacelab"><img src="themes/switch/images/clr/spacelab.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="united"><img src="themes/switch/images/clr/united.png" alt="bootstrap business templates"></a>
                    <p style="margin:0;line-height:normal;margin-left:-10px;display:none;"><small>These are just examples and you can build your own color scheme in the backend.</small></p>
                </div>
                <div class="themeName">Background Patterns </div>
                <div class="images patterns">
                    <a href="themes/css/#" name="pattern1"><img src="themes/switch/images/pattern/pattern1.png" alt="bootstrap business templates" class="active"></a>
                    <a href="themes/css/#" name="pattern2"><img src="themes/switch/images/pattern/pattern2.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern3"><img src="themes/switch/images/pattern/pattern3.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern4"><img src="themes/switch/images/pattern/pattern4.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern5"><img src="themes/switch/images/pattern/pattern5.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern6"><img src="themes/switch/images/pattern/pattern6.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern7"><img src="themes/switch/images/pattern/pattern7.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern8"><img src="themes/switch/images/pattern/pattern8.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern9"><img src="themes/switch/images/pattern/pattern9.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern10"><img src="themes/switch/images/pattern/pattern10.png" alt="bootstrap business templates"></a>

                    <a href="themes/css/#" name="pattern11"><img src="themes/switch/images/pattern/pattern11.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern12"><img src="themes/switch/images/pattern/pattern12.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern13"><img src="themes/switch/images/pattern/pattern13.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern14"><img src="themes/switch/images/pattern/pattern14.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern15"><img src="themes/switch/images/pattern/pattern15.png" alt="bootstrap business templates"></a>

                    <a href="themes/css/#" name="pattern16"><img src="themes/switch/images/pattern/pattern16.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern17"><img src="themes/switch/images/pattern/pattern17.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern18"><img src="themes/switch/images/pattern/pattern18.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern19"><img src="themes/switch/images/pattern/pattern19.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern20"><img src="themes/switch/images/pattern/pattern20.png" alt="bootstrap business templates"></a>

                </div>
            </div>
        </div>
        <span id="themesBtn"></span>

    </body>
</html>
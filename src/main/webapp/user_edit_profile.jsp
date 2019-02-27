<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
?<!DOCTYPE html>
<html lang="en">

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
        <link id="callCss" rel="stylesheet" href="themes/bootshop/bootstrap.min.css" media="screen" />
        <link href="themes/css/base.css" rel="stylesheet" media="screen" />
        <!-- Bootstrap style responsive -->
        <link href="themes/css/bootstrap-responsive.min.css" rel="stylesheet" />
        <link href="themes/css/font-awesome.css" rel="stylesheet" type="text/css">
        <!-- Google-code-prettify -->
        <link href="themes/js/google-code-prettify/prettify.css" rel="stylesheet" />
        <!-- fav and touch icons -->
        <link rel="shortcut icon" href="themes/images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144"
              href="themes/images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114"
              href="themes/images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="themes/images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="themes/images/ico/apple-touch-icon-57-precomposed.png">
        <style type="text/css" id="enject">
            .control-group {
                width: fit-content;
                margin: auto;
            }

            .control-label {
                width: 100px !important;
            }

            .controls {
                margin-left: 120px !important;
            }

            .span1 {
                width: 70px !important;
            }

            @media only screen and (max-width: 850px) {

                /* For mobile phones: */
                .span1 {
                    display: inline-flex !important;
                }
            }

            @media only screen and (max-width: 450px) {

                /* For mobile phones: */
                .span1 {
                    width: 60px !important;
                }
            }
        </style>
    </head>

    <body>
        <div id="header">
            <div class="container">
                <!-- Navbar ================================================== -->
                <div id="logoArea" class="navbar">
                    <a id="smallScreen" data-target="#topMenu" data-toggle="collapse" class="btn btn-navbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <div class="navbar-inner" style="margin-top: 1.5%;">
                        <a class="brand" href="error.html"><img src="themes/images/logo.png" alt="Bootsshop" /></a>
                        <form class="form-inline navbar-search" method="post" action="products.html">
                            <input id="srchFld" class="srchTxt" type="text" />
                            <select class="srchTxt">
                                <option>All</option>
                                <option>CLOTHES </option>
                            </select>
                            <button type="submit" id="submitButton" class="btn btn-primary">Go</button>
                        </form>
                        <ul id="topMenu" class="nav pull-right">
                            <li class=""><a href="special_offer.html">Specials Offer</a></li>
                            <li class=""><a href="normal.html">Delivery</a></li>
                            <li class=""><a href="contact.html">Contact</a></li>
                            <li class="">
                                <a href="${pageContext.request.contextPath}/login.jsp" role="button"
                                   style="padding-right:0"><span class="btn btn-large btn-success">Login</span></a>
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
                    <div class="span9" style="margin: 0 auto; float: none; ">
                        <ul class="breadcrumb">
                            <li><a href="${pageContext.request.contextPath}/index.jsp">Home</a> <span class="divider">/</span></li>
                            <li class="active">User Info</li>
                        </ul>
                        <h3>Edit profile</h3>
                        <div class="well" style="margin:0 auto; float: none;">
                            <form class="form-horizontal" method="POST"
                                  action="${pageContext.request.contextPath}/EditProfileServlet" enctype="multipart/form-data">
                                <h4>Your personal information</h4>
                                <div class="control-group">
                                    <img src="data:image/jpeg;base64,${user.profileImage}" alt="Avatar">
                                    <input type="file" name="file" />
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="inputFname1">First name <sup>*</sup></label>
                                    <div class="controls">
                                        <input type="text" id="inputFname1" name="firstName" value="${user.firstName}">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="inputLnam">Last name <sup>*</sup></label>
                                    <div class="controls">
                                        <input type="text" id="inputLnam" value="${user.lastName}" name="lastName">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="input_email">Email <sup>*</sup></label>
                                    <div class="controls">
                                        <input type="text" id="input_email" value="${user.email}" name="UserEmail">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="inputPassword1">Password <sup>*</sup></label>
                                    <div class="controls">
                                        <input type="password" id="inputPassword1" value="${user.password}"
                                               name="UserPassword">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label">Date of Birth <sup>*</sup></label>
                                    <div class="controls">
                                        <select class="span1" name="day">
                                            <c:set var="dayValue" value="1"/>
                                            <c:forEach end="31" begin="${dayValue}">
                                                <option value="${dayValue}" <c:if test="${dayValue==10}"> selected="selected" </c:if>>${dayValue}</option>
                                                <c:set var="dayValue" value="${dayValue+1}"/>
                                            </c:forEach>
                                        </select>
                                        <select class="span1" name="month">
                                            <option value="January">1</option>
                                            <option value="February">2</option>
                                            <option value="March">3</option>
                                            <option value="April">4</option>
                                            <option value="May">5</option>
                                            <option value="June">6</option>
                                            <option value="July">7</option>
                                            <option value="August">8</option>
                                            <option value="September">9</option>
                                            <option value="October">10</option>
                                            <option value="November">11</option>
                                            <option value="December">12</option>
                                        </select>
                                        <select class="span1" name="year">
                                            <option value="2019">2019</option>
                                            <option value="2018">2018</option>
                                            <option value="2017">2017</option>
                                            <option value="2016">2016</option>
                                            <option value="2015">2015</option>
                                            <option value="2014">2014</option>
                                            <option value="2013">2013</option>
                                            <option value="2012">2012</option>
                                            <option value="2011">2011</option>
                                            <option value="2010">2010</option>
                                            <option value="2009">2009</option>
                                            <option value="2008">2008</option>
                                            <option value="2007">2007</option>
                                            <option value="2006">2006</option>
                                            <option value="2005">2005</option>
                                            <option value="2004">2004</option>
                                            <option value="2003">2003</option>
                                            <option value="2002">2002</option>
                                            <option value="2001">2001</option>
                                            <option value="2000">2000</option>
                                            <option value="1999">1999</option>
                                            <option value="1998">1998</option>
                                            <option value="1997">1997</option>
                                            <option value="1996">1996</option>
                                            <option value="1995">1995</option>
                                            <option value="1994">1994</option>
                                            <option value="1993">1993</option>
                                            <option value="1992">1992</option>
                                            <option value="1991">1991</option>
                                            <option value="1990">1990</option>
                                            <option value="1989">1989</option>
                                            <option value="1988">1988</option>
                                            <option value="1987">1987</option>
                                            <option value="1986">1986</option>
                                            <option value="1985">1985</option>
                                            <option value="1984">1984</option>
                                            <option value="1983">1983</option>
                                            <option value="1982">1982</option>
                                            <option value="1981">1981</option>
                                            <option value="1980">1980</option>
                                            <option value="1979">1979</option>
                                            <option value="1978">1978</option>
                                            <option value="1977">1977</option>
                                            <option value="1976">1976</option>
                                            <option value="1975">1975</option>
                                            <option value="1974">1974</option>
                                            <option value="1973">1973</option>
                                            <option value="1972">1972</option>
                                            <option value="1971">1971</option>
                                            <option value="1970">1970</option>
                                            <option value="1969">1969</option>
                                            <option value="1968">1968</option>
                                            <option value="1967">1967</option>
                                            <option value="1966">1966</option>
                                            <option value="1965">1965</option>
                                            <option value="1964">1964</option>
                                            <option value="1963">1963</option>
                                            <option value="1962">1962</option>
                                            <option value="1961">1961</option>
                                            <option value="1960">1960</option>
                                            
                                        </select>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="input_email">Address <sup>*</sup></label>
                                    <div class="controls">
                                        <input type="text" id="input_email" value="${user.address}" name="address">
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="input_email">Phone <sup>*</sup></label>
                                    <div class="controls">
                                        <input type="text" id="input_email" value="${user.phone}" name="phone">
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="input_email">Job <sup>*</sup></label>
                                    <div class="controls">
                                        <input type="text" id="input_email" value="${user.job}" name="job">
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
                                        <input class="btn btn-large btn-success" type="submit" value="Save" />
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
                        <a href="#"><img width="60" height="60" src="themes/images/facebook.png" title="facebook"
                                         alt="facebook" /></a>
                        <a href="#"><img width="60" height="60" src="themes/images/twitter.png" title="twitter"
                                         alt="twitter" /></a>
                        <a href="#"><img width="60" height="60" src="themes/images/youtube.png" title="youtube"
                                         alt="youtube" /></a>
                    </div>
                </div>
                <p class="pull-right">&copy; Bootshop</p>
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
            <link rel="stylesheet" href="themes/switch/themeswitch.css" type="text/css" media="screen" />
            <script src="themes/switch/theamswitcher.js" type="text/javascript" charset="utf-8"></script>
            <div id="themeContainer">
                <div id="hideme" class="themeTitle">Style Selector</div>
                <div class="themeName">Oregional Skin</div>
                <div class="images style">
                    <a href="themes/css/#" name="bootshop"><img src="themes/switch/images/clr/bootshop.png"
                                                                alt="bootstrap business templates" class="active"></a>
                    <a href="themes/css/#" name="businessltd"><img src="themes/switch/images/clr/businessltd.png"
                                                                   alt="bootstrap business templates" class="active"></a>
                </div>
                <div class="themeName">Bootswatch Skins (11)</div>
                <div class="images style">
                    <a href="themes/css/#" name="amelia" title="Amelia"><img src="themes/switch/images/clr/amelia.png"
                                                                             alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="spruce" title="Spruce"><img src="themes/switch/images/clr/spruce.png"
                                                                             alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="superhero" title="Superhero"><img
                            src="themes/switch/images/clr/superhero.png" alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="cyborg"><img src="themes/switch/images/clr/cyborg.png"
                                                              alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="cerulean"><img src="themes/switch/images/clr/cerulean.png"
                                                                alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="journal"><img src="themes/switch/images/clr/journal.png"
                                                               alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="readable"><img src="themes/switch/images/clr/readable.png"
                                                                alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="simplex"><img src="themes/switch/images/clr/simplex.png"
                                                               alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="slate"><img src="themes/switch/images/clr/slate.png"
                                                             alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="spacelab"><img src="themes/switch/images/clr/spacelab.png"
                                                                alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="united"><img src="themes/switch/images/clr/united.png"
                                                              alt="bootstrap business templates"></a>
                    <p style="margin:0;line-height:normal;margin-left:-10px;display:none;"><small>These are just examples
                            and you
                            can build your own color scheme in the backend.</small></p>
                </div>
                <div class="themeName">Background Patterns </div>
                <div class="images patterns">
                    <a href="themes/css/#" name="pattern1"><img src="themes/switch/images/pattern/pattern1.png"
                                                                alt="bootstrap business templates" class="active"></a>
                    <a href="themes/css/#" name="pattern2"><img src="themes/switch/images/pattern/pattern2.png"
                                                                alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern3"><img src="themes/switch/images/pattern/pattern3.png"
                                                                alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern4"><img src="themes/switch/images/pattern/pattern4.png"
                                                                alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern5"><img src="themes/switch/images/pattern/pattern5.png"
                                                                alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern6"><img src="themes/switch/images/pattern/pattern6.png"
                                                                alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern7"><img src="themes/switch/images/pattern/pattern7.png"
                                                                alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern8"><img src="themes/switch/images/pattern/pattern8.png"
                                                                alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern9"><img src="themes/switch/images/pattern/pattern9.png"
                                                                alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern10"><img src="themes/switch/images/pattern/pattern10.png"
                                                                 alt="bootstrap business templates"></a>

                    <a href="themes/css/#" name="pattern11"><img src="themes/switch/images/pattern/pattern11.png"
                                                                 alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern12"><img src="themes/switch/images/pattern/pattern12.png"
                                                                 alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern13"><img src="themes/switch/images/pattern/pattern13.png"
                                                                 alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern14"><img src="themes/switch/images/pattern/pattern14.png"
                                                                 alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern15"><img src="themes/switch/images/pattern/pattern15.png"
                                                                 alt="bootstrap business templates"></a>

                    <a href="themes/css/#" name="pattern16"><img src="themes/switch/images/pattern/pattern16.png"
                                                                 alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern17"><img src="themes/switch/images/pattern/pattern17.png"
                                                                 alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern18"><img src="themes/switch/images/pattern/pattern18.png"
                                                                 alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern19"><img src="themes/switch/images/pattern/pattern19.png"
                                                                 alt="bootstrap business templates"></a>
                    <a href="themes/css/#" name="pattern20"><img src="themes/switch/images/pattern/pattern20.png"
                                                                 alt="bootstrap business templates"></a>

                </div>
            </div>
        </div>
        <span id="themesBtn"></span>
    </body>

</html>
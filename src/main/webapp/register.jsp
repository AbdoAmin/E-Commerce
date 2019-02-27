<!DOCTYPE html>
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
	<jsp:include page="/CommonHeader.jsp" />
	<!-- Header End====================================================================== -->
	<div id="mainBody">
		<div class="container">
			<div class="row">
				<div class="span9" style="margin: 0 auto; float: none; ">
					<ul class="breadcrumb">
						<li><a href="${pageContext.request.contextPath}/index.jsp">Home</a> <span
								class="divider">/</span></li>
						<li class="active">Registration</li>
					</ul>
					<h3> Registration</h3>
					<div class="well" style="margin:0 auto; float: none;">
						<form class="form-horizontal" method="POST"
							action="${pageContext.request.contextPath}/SignUpServlet" enctype="multipart/form-data">
							<h4>Your personal information</h4>

							<div class="control-group">
								<label class="control-label">Profile Image <sup>*</sup></label>
								<div class="controls">
									<input type="file" name="file" required style="width: 215px !important;" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="inputFname1">First name <sup>*</sup></label>
								<div class="controls">
									<input type="text" id="inputFname1" required placeholder="First Name"
										name="firstName">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="inputLnam">Last name <sup>*</sup></label>
								<div class="controls">
									<input type="text" id="inputLnam" placeholder="Last Name" required="true"
										name="lastName">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="input_email">Email <sup>*</sup></label>
								<div class="controls">
									<input id="input_email" placeholder="Email" required="true" type="email"
										name="UserEmail">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="inputPassword1">Password <sup>*</sup></label>
								<div class="controls">
									<input type="password" id="inputPassword1" placeholder="Password" required="true"
										name="UserPassword">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Date of Birth <sup>*</sup></label>
								<div class="controls">
									<select class="span1" name="day">
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
										<option value="13">13</option>
										<option value="14">14</option>
										<option value="15">15</option>
										<option value="16">16</option>
										<option value="17">17</option>
										<option value="18">18</option>
										<option value="19">19</option>
										<option value="20">20</option>
										<option value="21">21</option>
										<option value="22">22</option>
										<option value="23">23</option>
										<option value="24">24</option>
										<option value="25">25</option>
										<option value="26">26</option>
										<option value="27">27</option>
										<option value="28">28</option>
										<option value="29">29</option>
										<option value="30">30</option>
										<option value="31">31</option>
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
										<option value="1959">1959</option>
										<option value="1958">1958</option>
										<option value="1957">1957</option>
										<option value="1956">1956</option>
										<option value="1955">1955</option>
										<option value="1954">1954</option>
										<option value="1953">1953</option>
										<option value="1952">1952</option>
										<option value="1951">1951</option>
										<option value="1950">1950</option>
										<option value="1949">1949</option>
										<option value="1948">1948</option>
										<option value="1947">1947</option>
										<option value="1946">1946</option>
										<option value="1945">1945</option>
										<option value="1944">1944</option>
										<option value="1943">1943</option>
										<option value="1942">1942</option>
										<option value="1941">1941</option>
										<option value="1940">1940</option>
										<option value="1939">1939</option>
										<option value="1938">1938</option>
										<option value="1937">1937</option>
										<option value="1936">1936</option>
										<option value="1935">1935</option>
										<option value="1934">1934</option>
										<option value="1933">1933</option>
										<option value="1932">1932</option>
										<option value="1931">1931</option>
										<option value="1930">1930</option>
										<option value="1929">1929</option>
										<option value="1928">1928</option>
										<option value="1927">1927</option>
										<option value="1926">1926</option>
										<option value="1925">1925</option>
										<option value="1924">1924</option>
										<option value="1923">1923</option>
										<option value="1922">1922</option>
										<option value="1921">1921</option>
										<option value="1920">1920</option>
										<option value="1919">1919</option>
										<option value="1918">1918</option>
										<option value="1917">1917</option>
										<option value="1916">1916</option>
										<option value="1915">1915</option>
										<option value="1914">1914</option>
										<option value="1913">1913</option>
										<option value="1912">1912</option>
										<option value="1911">1911</option>
										<option value="1910">1910</option>
										<option value="1909">1909</option>
										<option value="1908">1908</option>
										<option value="1907">1907</option>
										<option value="1906">1906</option>
										<option value="1905">1905</option>
									</select>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="input_email">Address <sup>*</sup></label>
								<div class="controls">
									<input type="text" id="input_email" placeholder="Address" name="address" required>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="input_email">Phone <sup>*</sup></label>
								<div class="controls">
									<input type="tel" pattern="[0-9]{11}" id="input_email" placeholder="Phone"
										name="phone" required>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="input_email">Job <sup>*</sup></label>
								<div class="controls">
									<input type="text" id="input_email" placeholder="Job" name="job" required />
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
									<input class="btn btn-large btn-success" type="submit" value="Register" />
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
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="c" uri="http://www.springframework.org/tags"  %>
<!DOCTYPE html>
<html>
<head>
<c:url value="/resources/images" var="img"/>

<title> SAI HERBALS </title>
<link rel="icon" href="${img}/logo_new.gif" >
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- Bootstrap -->	
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
<link rel="stylesheet" href="${css}/login.css" >

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- Bootstrap -->

<!-- Navbar -->
	<link rel="stylesheet" href="${css}/style.css" type="text/css" media="all" />
	<link href="${css}/animate.css" rel="stylesheet" type="text/css" media="all">
<!-- Navbar -->

<!-- Icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Icons -->

</head>
<body>
<from:from>
<div>
	<div class="span11">

	<div class="col-md-12  col-sm-12  col-xs-8 "
	style="background: #fff; padding: 30px;">

	<div class="col-md-6 col-sm-6 col-xs-12">
		<h3 class="text-center">BILLING ADDRESS</h3>

		<hr>
		
			<div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="text" path="user.U_Email" name="email" class="form-control input-sm"					
				placeholder="Emailid" disabled="true"/> 
			</div>
		</div>
		<div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="number" name="mono" path="user.U_PhoneNum" disabled="true"
			class="form-control input-sm" placeholder="Mobile no"/>
			</div>
		</div>
		

		<div class="col-xs-12 col-sm-12 col-md-12">
			<div class="form-group">
				<form:input class="form-control" path="billing.b_House_Number" disabled="true"
					placeholder="House name and number"/>                                                
                                            
			</div>
			
		</div>

<!-- 		<div class="col-xs-12 col-sm-4 col-md-4"> -->
<!-- 			<div class="form-group"> -->
<%-- 				<form:input type="text" name="country" disabled="true" --%>
<%--  					class="form-control input-sm" placeholder="country" path="billing.country" />  --%>
<!-- 			</div> -->
<!-- 		</div> -->
		<div class="col-xs-12 col-sm-4 col-md-4">
			<div class="form-group">
				<form:input type="text" name="city" disabled="true"
					class="form-control input-sm" placeholder="city" path="billing.b_City"/>
			</div>
		</div>
<!-- 		<div class="col-xs-12 col-sm-4 col-md-4"> -->
<!-- 			<div class="form-group"> -->
<%-- 				<form:input type="text" name="pincode" disabled="true" --%>
<%-- 					class="form-control input-sm" placeholder="pincode" path="billing.pincode" /> --%>
<!-- 			</div> -->
<!-- 		</div> -->
		<input class="coupon_question" type="checkbox" name="coupon_question"
			value="1"> <span class="item-text">Check Shipping
			address</span>
	</div>


	<div class="col-md-6 shipping col-sm-6 col-xs-12">
		<h3 class="text-center">SHIPPING ADDRESS</h3>

		<hr>
	
		
	
		<div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="text" name="first_name" id="first_name"
					class="form-control input-sm" placeholder="First Name" path="user.U_F_Name"/>
			</div>
		</div>
		<div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="text" name="last_name" id="last_name"
					class="form-control input-sm" placeholder="Last Name" path="user.U_L_Name"/>
			</div>
		</div>

		<div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="text" name="first_name" id="first_name"
					class="form-control input-sm" placeholder="Email id" path="user.U_Email"/>
			</div>
		</div>
		<div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="text" name="Mobile_no" 
					class="form-control input-sm" placeholder="Mobile no" path="user.U_PhoneNum"/>
			</div>
		</div>

		<div class="col-xs-12 col-sm-12 col-md-12">
			<div class="form-group">
				<form:input type="text" class="form-control" path="user.U_Address"/>                                                
                                           
			</div>
		</div>

		<div class="col-xs-12 col-sm-4 col-md-4">
			<div class="form-group">
				<form:input type="text"
					class="form-control input-sm" placeholder="country" path="user.Country"/>
			</div>
		</div>
		<div class="col-xs-12 col-sm-4 col-md-4">
			<div class="form-group">
				<form:input type="text" 
					class="form-control input-sm" placeholder="city" path="user.City"/>
			</div>
		</div>
<!-- 		<div class="col-xs-12 col-sm-4 col-md-4"> -->
<!-- 			<div class="form-group"> -->
<%-- 				<form:input type="text" --%>
<%-- 					class="form-control input-sm" placeholder="pincode" path="pincode" /> --%>
<!-- 			</div> -->
<!-- 		</div> -->
	</div>
	</div>
	<br>
	<br>
	<div class="col-md-12">
	<center>
	<br>
	<br>
	<a href="<c:url value="/ThankYou" />">
	
<!-- 		<input type="submit" class="btn btn-primary pull-right" value="Continue"> -->
<button style="-moz-box-shadow: 1px 1px 3px 2px #5cb85c;
  -webkit-box-shadow: 1px 1px 3px 2px #5cb85c;
  box-shadow:         1px 1px 3px 2px #5cb85c;"type="submit" class="btn btn-success" value="save">CONTINUE</button>
		</a>
	&nbsp &nbsp &nbsp
		  					
  	<a href="<c:url value="/" />"> <button style=" -moz-box-shadow: 1px 1px 3px 2px #d9534f;
  -webkit-box-shadow: 1px 1px 3px 2px #d9534f;
  box-shadow:         1px 1px 3px 2px #d9534f;" type="reset" class="btn btn-danger">CANCEL</button></a>
 </center>
	</div>
</div>

</div>
</from:from>
<!--
Footer
-->

<!-- /container -->

<div class="copyright">
<div class="container">
	
	</div>
</div>
<a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.easing-1.3.min.js"></script>
    <script src="assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
    <script src="assets/js/shop.js"></script>
  </body>
</html>

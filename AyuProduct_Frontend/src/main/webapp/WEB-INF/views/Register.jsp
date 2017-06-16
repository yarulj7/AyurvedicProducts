<%@taglib prefix="c" uri="http://www.springframework.org/tags"  %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="re" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>

<c:url value="/resources/images" var="img"/>
<c:url value="/resources/css" var="css"/>
<c:url value="/resources/fonts" var="fonts"/>
<c:url value="/resources/js" var="js"/>        

<link rel="stylesheet" href="${css}/patanjali_style.css">		
<link rel="stylesheet" href="${css}/coloring.css">

</head>
    <body style="background-color : #e6e6e6">
<section style="background-color:#cccccc">
    <div class="second-page-container">
        <div class="block">
            <div class="container">
                <div class="header-for-light">
                    <h1 class="wow fadeInRight animated animated" data-wow-duration="1s" style="visibility: visible;-webkit-animation-duration: 1s; -moz-animation-duration: 1s; animation-duration: 1s;">Create new <span>Account</span></h1>
                </div>
                <div class="row">
                    <article class="col-xs-12 col-sm-8 col-md-8 col-lg-8">
                        <div class="block-form box-border wow fadeInLeft animated animated" data-wow-duration="1s" style="visibility: visible;-webkit-animation-duration: 1s; -moz-animation-duration: 1s; animation-duration: 1s;">
                        <c:url value="/user_Processing" var="use"/>
                            <form:form  action="${use}" commandName="user" name="registerform" id="registerform" method="POST" novalidate="novalidate">
                                <input type="hidden" name="authtoken" value="6b63542ce947957479a4254606bee834"><div class="alert" id="sign_msg" style="display:none"></div>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <div class="form-group">
                                            <label for="inputFirstName" class="control-label">Title:<span class="text-error">*</span></label>
                                            <div>
                                                <select class="form-control" name="title" required="" aria-required="true">
                                                    <option value="">Select</option>
                                                    <option value="Mr">Mr</option>
                                                    <option value="Mrs">Mrs</option>
                                                    <option value="Ms">Ms</option>
                                                </select>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="col-sm-5">
                                        <div class="form-group">
                                            <label for="U_F_Name" class="control-label">First name:<span class="text-error">*</span></label>
                                            <div>
                                                <form:input type="text" class="form-control" path="U_F_Name"  placeholder="Enter first name.."/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <label for="inputFirstName" class="control-label">Last name:<span class="text-error">*</span></label>
                                            <div>
                                                <form:input type="text" class="form-control" path="U_L_Name" name="lastname" placeholder="Enter last name.."/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <label for="inputFirstName" class="control-label">Address<span class="text-error">*</span></label>
                                            <div>
                                                <form:input type="text" class="form-control" path="U_Address" name="lastname" placeholder="Enter Address"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <label for="inputFirstName" class="control-label">LandMark<span class="text-error">*</span></label>
                                            <div>
                                                <form:input type="text" class="form-control" path="LandMark" name="lastname" placeholder="Enter Landmark"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <label for="inputFirstName" class="control-label">City<span class="text-error">*</span></label>
                                            <div>
                                                <form:input type="text" class="form-control" path="City" name="lastname" placeholder="Enter City"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <label for="inputFirstName" class="control-label">State<span class="text-error">*</span></label>
                                            <div>
                                                <form:input type="text" class="form-control" path="State" name="lastname" placeholder="Enter State"/>
                                            </div>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="col-sm-4">
                                        <label for="inputFirstName" class="control-label">Mobile:<span class="text-error">*</span></label>
                                        <div>
                                            <input type="text" class="form-control" id="code" name="code" value="+91-" readonly=""/>
                                        </div>
                                    </div>
                                    <div class="col-sm-8">
                                        <label for="dd" class="control-label">&nbsp;</label>
                                        <div>
                                            <form:input type="number" class="form-control" path="U_PhoneNum" name="mobile" placeholder="Enter mobile number.."/>
                                        </div>
                                    </div>
                                    <div class="col-sm-12">	
                                        <div class="form-group">

                                            <label for="inputLastName" class="control-label">User Name<span class="text-error">*</span></label>
                                            <div>
                                                <form:input type="text" class="form-control" path="U_Email" name="email"/>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="inputEMail" class="control-label">Password<span class="text-error">*</span></label>
                                            <div>
                                                <form:input type="password" class="form-control" path="U_Password" name="password"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="inputEMail" class="control-label">Confirm Password<span class="text-error">*</span></label>
                                            <div>
                                                <input type="password" class="form-control" id="confirmpassword" name="confirmpassword">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                   <button style="-moz-box-shadow: 1px 1px 3px 2px #5cb85c;
  -webkit-box-shadow: 1px 1px 3px 2px #5cb85c;
  box-shadow:         1px 1px 3px 2px #5cb85c;"type="submit" class="btn btn-success" value="save">REGISTER</button>
  
                            </form:form>
                        </div>
                    </article>
<!--     private String U_dob; -->
<!--     private String City; -->
<!--     private String State; -->
<!--     private String LandMark; -->

                </div>
            </div>
        </div>
    </div> 

</body></html>
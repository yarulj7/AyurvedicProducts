<%@taglib prefix="c" uri="http://www.springframework.org/tags"  %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="s1" uri="http://java.sun.com/jsp/jstl/core" %>
<!Doctype html>

<html>

<head>
<c:url value="/resources/images" var="img"/>
<c:url value="/resources/css" var="css"/>
<c:url value="/resources/fonts" var="fonts"/>
<c:url value="/resources/js" var="js"/>

  <title>SAI HERBALS</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <link rel="icon" href="${img}/logo_new.gif">
  <style>
   .dropdown-menu
   {
     margin-left:1px
   }
  </style>
<link rel="stylesheet" href="${css}/coloring.css">

</head>

<body>
<br>
<br>
<br>
<br> 	

<c:url value="/supplier_Processing" var="sup" />
<form:form action="${sup}" method="POST" commandName="supplier" class="form-horizontal container" style="40%">
  <div class="form-group">
    <label class="control-label col-sm-2" for="S_Id"> SUPPLIER ID : &nbsp</label>
    <div class="col-sm-10">
      <form:input type="text" class="form-control" path="S_Id" placeholder="SUPPLIER ID"/>
    </div>
  </div>

  <div class="form-group">
    <label class="control-label col-sm-2" for="S_Name">SUPPLIER NAME : &nbsp</label>
    <div class="col-sm-10"> 
      <form:input type="text" class="form-control" path="S_Name" placeholder="SUPPLIER NAME"/>
    </div>
  </div>

  <div class="form-group">
    <label class="control-label col-sm-2" for="S_Address">SUPPLIER ADDRESS : &nbsp</label>
    <div class="col-sm-10"> 
      <form:input type="text" class="form-control" path="S_Address" placeholder="SUPPLIER ADDRESS"/>
    </div>
  </div>

  <div class="form-group">
    <label class="control-label col-sm-2" for="S_Email">SUPPLIER EMAIL : </label>
    <div class="col-sm-10"> 
      <form:input type="text" class="form-control" path="S_Email" placeholder="SUPPLIER EMAIL"/>
    </div>
  </div>

  <div class="form-group">
    <label class="control-label col-sm-2" for="S_Phone">SUPPLIER PHONE : &nbsp</label>
    <div class="col-sm-10"> 
      <form:input type="number" class="form-control" path="S_Phone" placeholder="SUPPLIER PHONE"/>
    </div>
  </div>
<!--
-->
<br>
  <div class="form-group" >
	 <span style="textalign:center;margin-left:350px">
	    <button style="-moz-box-shadow: 1px 1px 3px 2px #5cb85c;
  -webkit-box-shadow: 1px 1px 3px 2px #5cb85c;
  box-shadow:         1px 1px 3px 2px #5cb85c;"type="submit" class="btn btn-success" value="save">SUBMIT</button>
  
  
  
  &nbsp &nbsp
        <button style="-moz-box-shadow: 1px 1px 3px 2px #31b0d5;
  -webkit-box-shadow: 1px 1px 3px 2px #31b0d5;
  box-shadow:         1px 1px 3px 2px #31b0d5;"type="reset"  class="btn btn-info">RESET</button>
  
  
  
  &nbsp &nbsp
		<button style=" -moz-box-shadow: 1px 1px 3px 2px #d9534f;
  -webkit-box-shadow: 1px 1px 3px 2px #d9534f;
  box-shadow:         1px 1px 3px 2px #d9534f;" type="cancel" class="btn btn-danger">CANCEL</button>
	 </span>
    </div>

</form:form>
<br>
<br>
<br>
<table class="table">
        <thead>
            <tr>
                <th style="padding-left : 15px;">SUPPLIER ID</th>
                <th style="padding-left : 15px;">SUPPLIER NAME</th>
                <th style="padding-left : 15px;">SUPPLIER ADDRESS</th>
                <th style="padding-left : 15px;">SUPPLIER EMAIL</th>
                <th style="padding-left : 15px;">SUPPLIER PHONE</th>
            </tr>
        </thead>
        <tbody>
             <s1:forEach items="${supplierlist}" var="supplierlist">
            <tr>
    			<td>${supplierlist.getS_Id()}</td>
    			<td>${supplierlist.getS_Name()}</td>
    			<td>${supplierlist.getS_Address()}</td>
    			<td>${supplierlist.getS_Email()}</td>
    			<td>${supplierlist.getS_Phone()}</td>
    			
    			  <td>
    			  <a href ='<c:url value="/EditSupplier/${supplierlist.getS_Id()}"></c:url>'>
    			  <button style= "-moz-box-shadow: 1px 1px 3px 2px #31b0d5;
  							     -webkit-box-shadow: 1px 1px 3px 2px #31b0d5;
  								  box-shadow: 1px 1px 3px 2px #31b0d5;"
  				  class="btn btn-info">EDIT</button>
  
  				</a>
  				</td>
  					<td>
  						&nbsp &nbsp
  						<a href='<c:url value="/DeleteSupplier/${supplierlist.getS_Id()}"></c:url>'>
							<button style=" -moz-box-shadow: 1px 1px 3px 2px #d9534f;
  											-webkit-box-shadow: 1px 1px 3px 2px #d9534f;
  											box-shadow: 1px 1px 3px 2px #d9534f;" 
  							class="btn btn-danger">DELETE
  							</button>
  					   </a>
  				   </td>
    	
            </tr>
            </s1:forEach>
        </tbody>
    </table>
</body>

</html>
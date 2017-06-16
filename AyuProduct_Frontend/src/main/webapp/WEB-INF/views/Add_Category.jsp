<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="c" uri="http://www.springframework.org/tags"  %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
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

<c:url value="/category_Processing" var="cat"/>
<form:form action="${cat}" method="POST" commandName="category" class="form-horizontal container" style="40%">
  <div class="form-group">
    <label class="control-label col-sm-2" for="C_Id"> CATEGORY ID : &nbsp</label>
    <div class="col-sm-10">
      <form:input type="text" class="form-control" path="C_Id" placeholder="CATEGORY ID"/>
    </div>
  </div>

  <div class="form-group">
    <label class="control-label col-sm-2" for="C_Name"> CATEGORY NAME : &nbsp</label>
    <div class="col-sm-10"> 
      <form:input type="text" class="form-control" path="C_Name" placeholder="CATEGORY NAME"/>
    </div>
  </div>

  <div class="form-group">
    <label class="control-label col-sm-2" for="C_Des">CATEGORY DESCRIPTION : &nbsp</label>
    <div class="col-sm-10"> 
      <form:input type="text" class="form-control" path="C_Des" placeholder="CATEGORY DESCRIPTION"/>
    </div>
  </div>



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
<!-- '''categories''' name should be same as refence variable name in controller --> 
<table class="table">
        <thead>
            <tr>
                <th style="padding-left : 15px;">CATEGORY ID</th>
                <th style="padding-left : 15px;">CATEGORY NAME</th>
                <th style="padding-left : 15px;">CATEGORY ADDRESS</th>
            </tr>
        </thead>
        <tbody>
          <c1:forEach items="${categories}" var="category">
            <tr>
    			<td>${category.getC_Id()}</td>
    			<td>${category.getC_Name()}</td>
    			<td>${category.getC_Des()}</td>
    			  <td>
    			  <a href ='<c:url value="/EditCategory/${category.getC_Id()}"></c:url>'>
    			  <button style= "-moz-box-shadow: 1px 1px 3px 2px #31b0d5;
  							     -webkit-box-shadow: 1px 1px 3px 2px #31b0d5;
  								  box-shadow: 1px 1px 3px 2px #31b0d5;"
  				  class="btn btn-info">EDIT</button>
  
  				</a>
  				</td>
  					<td>
  						&nbsp &nbsp
  						<a href='<c:url value="/DeleteCategory/${category.getC_Id()}"></c:url>'>
							<button style=" -moz-box-shadow: 1px 1px 3px 2px #d9534f;
  											-webkit-box-shadow: 1px 1px 3px 2px #d9534f;
  											box-shadow: 1px 1px 3px 2px #d9534f;" 
  							class="btn btn-danger">DELETE
  							</button>
  					   </a>
  				   </td>
    	
            </tr>
            </c1:forEach>
        </tbody>
    </table>

</body>

</html>
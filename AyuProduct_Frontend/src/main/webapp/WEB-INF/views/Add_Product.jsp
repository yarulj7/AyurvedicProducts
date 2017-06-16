<%@taglib prefix="c" uri="http://www.springframework.org/tags"  %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@taglib prefix="p1" uri="http://java.sun.com/jsp/jstl/core" %>

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

<!--  
  <script>
    var a=$(function(){

    $(".dropdown-menu").on('click', 'li a', function(){
      $(".btn:first-child").text($(this).text());
      $(".btn:first-child").val($(this).text());
   });

});
  </script>

-->
<body>
<br>
<br>
<br>
<br>
<c:url value="/product_Processing" var="p"/>
<form:form action="${p}" method="POST" commandName="products" enctype="multipart/form-data" class="form-horizontal container" style="40%">
  <div class="form-group">
    <label class="control-label col-sm-2" for="ProductId"> PRODUCT ID : &nbsp</label>
    <div class="col-sm-10">
      <form:input type="text" class="form-control" path="ProductId" placeholder="PRODUCT ID"/>
    </div>
  </div>

  <div class="form-group">
    <label class="control-label col-sm-2" for="ProductName">PRODUCT NAME : &nbsp</label>
    <div class="col-sm-10"> 
      <form:input type="text" class="form-control" path="ProductName" placeholder="PRODUCT NAME"/>
    </div>
  </div>

  <div class="form-group">
    <label class="control-label col-sm-2" for="ProductDes">PRODUCT DESCRIPTION : &nbsp</label>
    <div class="col-sm-10"> 
      <form:input type="text" class="form-control" path="ProductDes" placeholder="PRODUCT DESCRIPTION"/>
    </div>
  </div>

  <div class="form-group">
    <label class="control-label col-sm-2" for="Product_Qua">PRODUCT AVAILABILITY : </label>
    <div class="col-sm-10"> 
      <form:input type="number" class="form-control" path="Product_Qua" placeholder="PRODUCT AVAILABILITY"/>
    </div>
  </div>

  <div class="form-group">
    <label class="control-label col-sm-2" for="Product_Price">PRODUCT PRICE : &nbsp</label>
    <div class="col-sm-10"> 
      <form:input type="number" class="form-control" path="Product_Price" placeholder="PRODUCT PRICE"/>
    </div>
  </div>
<!--
-->
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="Product_weight_in_grams">PRODUCT WITH WEIGHT : &nbsp</label>
    <div class="col-sm-10"> 
      <form:input type="text" class="form-control" path="Product_weight_in_grams"  placeholder="PRODUCT WITH WEIGHT"/>
    &nbsp &nbsp
  </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="category">PRODUCT CATEGORY : &nbsp</label>
<!--     <div class="col-sm-10">  -->
<!-- 	 <div class="input-group"> -->
<!-- 	<button class="btn btn-default dropdown-toggle" style="width:240%" type="button" id="menu1" data-toggle="dropdown">CATEGORY NAME &nbsp &nbsp -->
<!-- 		  <span class="caret" style="margin-right:0px"></span></button> -->
<form:select path="category.C_Id" multiple="false">
    <p1:forEach items="${categorylist}" var="categoryDropDown">   
    <form:option value="${categoryDropDown.getC_Id()}" label="${categoryDropDown.getC_Name()}"/>
      </p1:forEach>
</form:select>

	</div>
<!-- 	</div> -->
<!--   </div> -->

  
  <div class="form-group">
    <label class="control-label col-sm-2" for="Product_weight">PRODUCT SUPPLIER : &nbsp</label>
<!--     <div class="col-sm-10">  -->
<!-- 	 <div class="input-group"> -->
<!-- 	<button class="btn btn-default dropdown-toggle" style="width:250%" type="button" id="menu1" data-toggle="dropdown">SUPPLIER NAME &nbsp &nbsp -->
<!-- 		  <span class="caret" style="margin-right:0px"></span></button> -->
	  <form:select path="supplier.S_Id" multiple="false">
    <p1:forEach items="${supplierlist}" var="supplierDropDown">   
    <form:option value="${supplierDropDown.getS_Id()}" label="${supplierDropDown.getS_Name()}"/>
      </p1:forEach>
</form:select>
<!-- 	</div> -->
	</div>
	<form:input path="pimg" type="file" name="pimg" value="upload file" />
	
<!--   </div> -->
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
   <c:url value="/Canceling" var="can"/>
		<a href="${can}"> <button style=" -moz-box-shadow: 1px 1px 3px 2px #d9534f;
  -webkit-box-shadow: 1px 1px 3px 2px #d9534f;
  box-shadow:         1px 1px 3px 2px #d9534f;" type="reset" class="btn btn-danger">CANCEL</button></a>
	 </span>
    </div>

</form:form>
<br>
<br>
<br>
<!--
	  private String ProductId;
	  private String ProductName;
	  private String ProductDes;
	  private String Product_weight_in_grams;
	 
	  private int Product_Qua;
	  private double Product_Price;
	  private float Product_weight;
	  

	@ManyToOne(cascade  = CascadeType.ALL)
	  @JoinColumn(name="C_Id")
	  private Category category;
	  
	  @ManyToOne
	  @JoinColumn(name="S_Id")
	  private Supplier supplier;
	  
	  

-->
<table class="table">
        <thead>
            <tr>
                <th style="padding-left : 15px;">PRODUCT ID</th>
                <th style="padding-left : 15px;">PRODUCT NAME</th>
                <th style="padding-left : 15px;">PRODUCT DESCRIPTION</th>
                <th style="padding-left : 15px;">PRODUCT AVAILABILITY</th>
                <th style="padding-left : 15px;">PRODUCT PRICE</th>
                <th style="padding-left : 15px;">PRODUCT WEIGHT</th>
                <th style="padding-left : 15px;">PRODUCT CATEGORY</th>
                <th style="padding-left : 15px;">PRODUCT SUPPLIER</th>

			</tr>
        </thead>
        <tbody>
            <tr>
            <p1:forEach items="${productlist}" var="productlist">
                <td> <br> <br>
                ${productlist.getProductId()} </td>
                &nbsp   &nbsp  &nbsp &nbsp &nbsp
    			<td>${productlist.getProductName()}</td>
    			<td>${productlist.getProductDes()}</td>
    			<td>${productlist.getProduct_Qua()}</td>
    			<td>${productlist.getProduct_Price()}</td>
    			<td>${productlist.getProduct_weight_in_grams()}</td>
    			<td>${productlist.getCategory().getC_Name()}</td>
    			<td>${productlist.getSupplier().getS_Name()}</td>
    			<td>
    			  <img src="${img}/${productlist.getProductId()}.jpg",width="50px,height=200px"> 
    			</td>
    			
    			  
  				
  				
  				<td>
  					
  					
  					<a href ='<c:url value="/EditProduct/${productlist.getProductId()}"></c:url>'>
    			  <button style= "-moz-box-shadow: 1px 1px 3px 2px #31b0d5;
  							     -webkit-box-shadow: 1px 1px 3px 2px #31b0d5;
  								  box-shadow: 1px 1px 3px 2px #31b0d5;"
  				  class="btn btn-info">EDIT</button>
  
  				</a> 
  				</td>
  				<td>
  				&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
  					
  						<a href='<c:url value="/DeleteProduct/${productlist.getProductId()}"></c:url>'>
							<button style=" -moz-box-shadow: 1px 1px 3px 2px #d9534f;
  											-webkit-box-shadow: 1px 1px 3px 2px #d9534f;
  											box-shadow: 1px 1px 3px 2px #d9534f;" 
  							class="btn btn-danger">DELETE
  							</button>
  							 <br>
  <br>
  <br>
  </a>
  
 
  </td>
  <br>
  <br>
  </p1:forEach>
            </tr>
  
        </tbody>
    </table>

</body>

</html>
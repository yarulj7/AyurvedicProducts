<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="c" uri="http://www.springframework.org/tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:url value="/resources/images" var="img"/>
<c:url value="/resources/css" var="css"/>
<c:url value="/resources/fonts" var="fonts"/>
<c:url value="/resources/js" var="js"/>
<title> SAI HERBALS </title>
<link rel="icon" href="${img}/logo_new.gif" >
<!-- Bootstrap -->	
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >

<!-- Bootstrap -->

<!-- Navbar -->
<%-- 	<link rel="stylesheet" href="${css}/style.css" type="text/css" media="all" /> --%>
<!-- Navbar -->

<!-- Icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Icons -->

</head>
<body>
<table class="table table-bordered table-condensed">
              <thead>
                <tr>
                  <th>IMAGE</th>
                  <th>NAME</th>
				  <th>	PRICE </th>
                  <th>Remove/Buy now</th>
                  <th>Total</th>	
				</tr>
              </thead>
              <tbody>
                 <c1:forEach items="${cartItems}" var="ci">
      <tr>
        <td><img src="<c:url value='/resources/images/${ci.getProducts().getProductId()}.jpg'/>" ,width=200px, height=200px></td>
        <td>${ci.getProducts().getProductName() }</td>
        <td>${ci.getProducts().getProduct_Price()}</td>
        <td><a href="<c1:url value='/Buy/${ci.getProducts().getProductId()}/${ci.getCart_Items_Id()}'/>" class="btn btn-info"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Buy Now</a>
        <a href=" <c:url value='/Remove/${ci.getCart_Items_Id()}'/>" class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i> Remove</a>
        </td>
        <td>${ci.getCart().getGrandtotal()} </td> 
      </tr>
      </c1:forEach>
                </tbody>

  </table>
</body>
</html>
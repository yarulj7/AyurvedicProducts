<%@ taglib prefix="c" uri="http://www.springframework.org/tags"  %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<!Doctype html>

<html>

<head>
<c:url value="/resources/images" var="img"/>
<c:url value="/resources/css" var="css"/>
<c:url value="/resources/fonts" var="fonts"/>
<c:url value="/resources/js" var="js"/>

<title> SAI HERBALS </title>

 
</head>


<body>


<link rel="stylesheet" href="${css}/patanjali_style.css">
<link rel="icon" href="${img}/logo_new.gif">
<!-- Icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Icons -->
        
<link rel="stylesheet" href="${css}/coloring.css">
   
    <div class="second-page-container all-pro ">
     <div class="container">
       <div class="row">
        <div class="col-md-12 all-categories" id="tiles" style="padding-bottom:25px;">
<!-- TURMARIC POWDER -->
  		    <div class="col-xs-12 col-sm-3 col-md-2 mb-25">
			 <article class="product light">
			 <c1:forEach var="pro" items="${productlist}">
			     <figure class="figure-hover-overlay ">
				   <a class="figure-href" href="<c:url value ="/Product_Details/${pro.getProductId()}"/>"></a>
					 <img height="50" alt="${pro.getProductName()}" class="img-responsive" src="${img}/${pro.getProductId()}.jpg">
				 </figure>
			        <div class="product-caption">
					  <div class="block-name">
					    <a data-original-title="${pro.getProductName()}" href="#" class="tool_tip ${pro.getProductName()}" data-toggle="tooltip" title="" style="">${pro.getProductName()}</a>
				
							${pro.getProduct_weight_in_grams()}				
							<p class="product-price">Rs.${pro.getProduct_Price()}</p>	
					   </div>
							   <div class="product-cart">
								<a href="<c:url value="/AddToCart/${pro.getProductId()}"/>"> 

								<button style="font-size:1.5" class="cart_new addtocart" title="Add to cart" itemid="780" itemqty="1" itemprice="24" itemname="TURMARIC POWDER" weight="100" type="button" id="btn-add-cart680">
								<i class="fa fa-shopping-cart">
								
								</i>
								</button>
								</a>	
							   </div>
			   
				      </div>
				      </c1:forEach>
				 </article>
			</div>
<!-- END TURMARIC POWDER -->

<!-- ATTA NOODLES -->

<!--   		    <div class="col-xs-12 col-sm-3 col-md-2 mb-25"> -->
<!-- 			 <article class="product light"> -->
<!-- 			     <figure class="figure-hover-overlay "> -->
<!-- 				   <a class="figure-href" href="#"></a> -->
<%-- 					 <img height="50" alt="ATTA NOODLE" class="img-responsive" src="${img}/AttaNoodle.jpg"> --%>
<!-- 				 </figure> -->
<!-- 			        <div class="product-caption"> -->
<!-- 					  <div class="block-name"> -->
<!-- 					    <a data-original-title="ATTA NOODLE" href="#" class="tool_tip product-name" data-toggle="tooltip" title="" style="">ATTA NOODLE....</a> -->
				
<!-- 							60gm				 -->
<!-- 							<p class="product-price">Rs. 10</p>	 -->
<!-- 					   </div> -->
<!-- 							   <div class="product-cart"> -->
<!-- 								<button class="cart_new addtocart" title="Add to cart" itemid="690" itemqty="1" itemprice="10" itemname="ATTA NOODLE" weight="60" type="button" id="btn-add-cart680"><i class="fa fa-shopping-cart"></i> </button> -->
<!-- 							   </div> -->
			   
<!-- 				      </div> -->
<!-- 				 </article> -->
<!-- 			</div> -->
<!-- END ATTA NOODLES -->

<!-- HALDICHANDAN SOAP -->

<!--   		    <div class="col-xs-12 col-sm-3 col-md-2 mb-25"> -->
<!-- 			 <article class="product light"> -->
<!-- 			     <figure class="figure-hover-overlay "> -->
<!-- 				   <a class="figure-href" href="#"></a> -->
<%-- 					 <img height="50" alt="HALDICHANDAN SOAP" class="img-responsive" src="${img}/HaldiChandankanti.jpg"> --%>
<!-- 				 </figure> -->
<!-- 			        <div class="product-caption"> -->
<!-- 					  <div class="block-name"> -->
<!-- 					    <a data-original-title="HALDICHANDAN SOAP" href="#" class="tool_tip product-name" data-toggle="tooltip" title="" style="">HALDICHANDAN...</a> -->
				
<!-- 							75gm				 -->
<!-- 							<p class="product-price">Rs. 13</p>	 -->
<!-- 					   </div> -->
<!-- 							   <div class="product-cart"> -->
<!-- 								<button class="cart_new addtocart" title="Add to cart" itemid="700" itemqty="1" itemprice="13" itemname="HALDICHANDAN SOAP" weight="75" type="button" id="btn-add-cart680"><i class="fa fa-shopping-cart"></i> </button> -->
<!-- 							   </div> -->
			   
<!-- 				      </div> -->
<!-- 				 </article> -->
<!-- 			</div> -->
<!-- END  HALDICHANDAN SOAP --> 

<!-- AAROYAGYA BISCUIT -->

<!--   		    <div class="col-xs-12 col-sm-3 col-md-2 mb-25"> -->
<!-- 			 <article class="product light"> -->
<!-- 			     <figure class="figure-hover-overlay "> -->
<!-- 				   <a class="figure-href" href="#"></a> -->
<%-- 					 <img height="50" alt="AAROYAGYA BISCUIT" class="img-responsive" src="${img}/Patanjali-Aaroyagya-Biskut.png"> --%>
<!-- 				 </figure> -->
<!-- 			        <div class="product-caption"> -->
<!-- 					  <div class="block-name"> -->
<!-- 					    <a data-original-title="AAROYAGYA BISCUIT" href="#" class="tool_tip product-name" data-toggle="tooltip" title="" style="">AAROYAGYA...</a> -->
				
<!-- 							100gm				 -->
<!-- 							<p class="product-price">Rs. 10</p>	 -->
<!-- 					   </div> -->
<!-- 							   <div class="product-cart"> -->
<!-- 								<button class="cart_new addtocart" title="Add to cart" itemid="710" itemqty="1" itemprice="10" itemname="AAROYAGYA BISCUIT weight="100" type="button" id="btn-add-cart680"><i class="fa fa-shopping-cart"></i> </button> -->
<!-- 							   </div>			    -->
<!-- 				      </div> -->
<!-- 				 </article> -->
<!-- 			</div> -->
<!-- END AAROYAGYA BISCUIT -->

<!-- CHANADAL NAMKEEN  -->

<!--   		    <div class="col-xs-12 col-sm-3 col-md-2 mb-25"> -->
<!-- 			 <article class="product light"> -->
<!-- 			     <figure class="figure-hover-overlay "> -->
<!-- 				   <a class="figure-href" href="#"></a> -->
<%-- 					 <img height="50" alt="CHANADAL NAMKEEN" class="img-responsive" src="${img}/ChanaDalNamkeen.jpg"> --%>
<!-- 				 </figure> -->
<!-- 			        <div class="product-caption"> -->
<!-- 					  <div class="block-name"> -->
<!-- 					    <a data-original-title="CHANADAL NAMKEEN" href="#" class="tool_tip product-name" data-toggle="tooltip" title="" style="">CHANADAL NAM...</a> -->
				
<!-- 							35gm				 -->
<!-- 							<p class="product-price">Rs. 10</p>	 -->
<!-- 					   </div> -->
<!-- 							   <div class="product-cart"> -->
<!-- 								<button class="cart_new addtocart" title="Add to cart" itemid="750" itemqty="1" itemprice="10" itemname="CHANADAL NAMKEEN" weight="35" type="button" id="btn-add-cart680"><i class="fa fa-shopping-cart"></i> </button> -->
<!-- 							   </div> -->
			   
<!-- 				      </div> -->
<!-- 				 </article> -->
<!-- 			</div> -->
<!-- END CHANADAL NAMKEEN -->

<!-- 		 </div> -->
<!-- 		</div> -->
<!-- 	  </div> -->
<!-- 	</div> -->
	
<!-- </div> -->


</body>

</html>
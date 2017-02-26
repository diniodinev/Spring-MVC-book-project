<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;
charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/
bootstrap.min.css">

<link rel="stylesheet"
	href="<c:url value="/resource/css/productDetails.css"/>"
	type="text/css" />

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js">
	
</script>
<script src="/store/resource/js/controllers.js"></script>
<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Products</h1>
			</div>
		</div>
	</section>
	<section class="container" ng-app="cartApp">
		<div class="row">
			<div class="col-md-5">
				<h3>${product.name}</h3>
				<p>${product.description}</p>
				<p>
					<strong>Item Code : </strong><span class="label label-warning">${product.productId}</span>
				</p>
				<p>
					<strong>manufacturer</strong> : ${product.manufacturer}
				</p>
				<p>
					<strong>category</strong> : ${product.category}
				</p>
				<p>
					<strong>Availble units in stock </strong> : ${product.unitsInStock}
				</p>
				<h4>${product.unitPrice}USD</h4>
				<p ng-controller="cartCtrl">
					<a class="btn btn-warning btn-large"
					ng-click="addToCart('${product.productId}')"> <spanclass="glyphicon-shopping-cartglyphicon"> </span> Order Now </a>
				</p>
				<a href="<spring:url value="/cart"/>" class="btn btn-default">
					<span class="glyphicon-hand-right glyphicon"></span> View Cart
				</a>
			</div>
			<img id="productDetailsImage"
				src="<c:url value="/resource/images/${product.productId}.png"></c:url>"
				alt="image" style="width: 300px" />

			<!-- The Modal -->
			<div id="myModal" class="modal">

				<!-- The Close Button -->
				<span class="close"
					onclick="document.getElementById('myModal').style.display='none'">&times;</span>

				<!-- Modal Content (The Image) -->
				<img class="modal-content" id="modalImg">

				<!-- Modal Caption (Image Text) -->
				<div id="caption"></div>
			</div>
		</div>
	</section>
</body>
</html>
<script>
	// Get the modal
	var modal = document.getElementById('myModal');

	// Get the image and insert it inside the modal - use its "alt" text as a caption
	var img = document.getElementById('productDetailsImage');
	var modalImg = document.getElementById("modalImg");
	var captionText = document.getElementById("caption");
	img.onclick = function() {
		modal.style.display = "block";
		modalImg.src = this.src;
		captionText.innerHTML = this.alt;
	}

	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];

	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
		modal.style.display = "none";
	}
</script>
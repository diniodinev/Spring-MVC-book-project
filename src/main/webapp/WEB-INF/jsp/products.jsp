<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;
charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Products</h1>
				<p>All the available products in our store</p>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<c:forEach items="${products}" var="product">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<h3>${product.name}</h3>
							<p>${product.description}</p>
							<p>
								<i class="class="fafa-dollar">${product.unitPrice} $</i>
							</p>
							<p>Available ${product.unitsInStock} units in stock</p>
						</div>
						<img
							src="<c:url value="/resource/images/${product.productId}.png"></c:url>"
							alt="image" style="width: px" />
						<p>
							<a href="<spring:url value="/products/product?id=${product.productId}"/>" class="btn btn-primary"> <span class="glyphicon-info-sign glyphicon" /></span> Details </a>
						</p>
					</div>

				</div>
			</c:forEach>
		</div>
		<div class="col-md-5">
		</div>
	</section>
</body>
</html>
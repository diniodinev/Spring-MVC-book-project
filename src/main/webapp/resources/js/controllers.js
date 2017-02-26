var cartApp = angular.module('cartApp', []);
cartApp.controller('cartCtrl', function ($scope, $http) {
	$scope.refreshCart = function (cartId) {
		$http.get('/store/rest/cart/' + $scope.cartId)
		.success(function (data) {
			$scope.cart = data;
		});
	};
	$scope.clearCart = function () {
		$http.delete ('/store/rest/cart/' + $scope.cartId)
		.success($scope.refreshCart($scope.cartId));
	};
	$scope.initCartId = function (cartId) {
		$scope.cartId = cartId;
		$scope.refreshCart($scope.cartId);
	};
	$scope.addToCart = function (productId) {
		$http.put('/store/rest/cart/add/' + productId)
		.success(function (data) {
			$scope.refreshCart($http.get('/store/rest/cart/get/cartId'));
			alert("Product Successfully added to the Cart!");
		});
	};
	$scope.removeFromCart = function (productId) {
		$http.put('/store/rest/cart/remove/' + productId)
		.success(function (data) {
			$scope.refreshCart($http.get('/store/rest/cart/get/cartId'));
		});
	};
});

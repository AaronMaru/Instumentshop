var cartApp = angular.module('cartApp', []);

cartApp.controller('cartCtrl', function($scope, $http) {
	$scope.cart = [];
    $scope.refreshCart = function() {
        $http.get("/InstrumentShop/rest/cart/" + $scope.cartId).then(function successCallback(response) {
        	console.log(response.data);
        	$scope.cart = response.data;
            
        }, function errorCallback(response) {
        });

    };

    $scope.clearCart = function() {
        $http.delete("/InstrumentShop/rest/cart/" + $scope.cartId).then(function successCallback(response) {
    		$scope.refreshCart();
        });
    };

    $scope.initCartId = function(cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function(productId) {
        $http.put('/InstrumentShop/rest/cart/create/' + productId).then(function successCallback(response) {
            alert('Product successfully add to the cart');
        }, function errorCallback(response) {
            alert('fail Product successfully add to the cart');
        });

    };

    $scope.removeFromCart = function(productId) {
    	$http.put("/InstrumentShop/rest/cart/remove/" + productId).then(function successCallback(response) {
    		$scope.refreshCart();
        });
    };
    
    $scope.calGrandTotal = function(){
    	var grandTotal = 0;
    	angular.forEach($scope.cart.cartItem, function(v,k){
    		grandTotal += v.totalPrice;
    	});	
    	    
    	return grandTotal;
    };

});

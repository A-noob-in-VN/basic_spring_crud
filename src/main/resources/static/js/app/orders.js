var app = angular.module('myApp', []);
app.controller('OrdersController', function ($scope, $http){

    $scope.ordersList = [];
    getAllOrders();

    function getAllOrders() {
        $http.get("http://localhost:8081/v1/shopee/orders").then(function (response) {
            $scope.ordersList = response.data;
        })
    }
})
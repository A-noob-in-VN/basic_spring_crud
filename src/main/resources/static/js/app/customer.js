var app = angular.module('myApp', []);
app.controller('CustomerController', function ($scope, $http){

    $scope.customerList = [];
    getAllCustomer();

    function getAllCustomer(){
        $http.get("http://localhost:8081/v1/shopee/customer").then(function (response) {
            $scope.customerList = response.data;
        })
    }
})
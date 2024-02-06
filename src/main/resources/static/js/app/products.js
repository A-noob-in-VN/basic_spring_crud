// var app = angular.module('myApp', []);
// app.controller('ProductsController', function ($scope, $http) {
//
//     $scope.productList = [];
//     getAllProduct();
//     getUser();
//     function getUser() {
//
//     }
//     function getAllProduct() {
//         $http.get("http://localhost:8081/v1/shopee/product").then(function(response) {
//             $scope.productList = response.data;
//         })
//     }
// })

var app = angular.module('myApp', []);
app.controller('ProductController', function ($scope, $http) {

    $scope.productList = [];
    $scope.product = {};

    getAllProduct();
    // getAddress();
    // loadAllAddress();
    // createAddress();
    updateProduct();
    // deleteAddress();
    // editAddress();
    // removeUser();

    // self.editUser = editUser;

    // return{
    //     getAddress: getAddress
    // };
    function getAllProduct() {
        $http.get("http://localhost:8081/v1/shopee/address").then(function (response) {
            $scope.productList = response.data;
        })

    }

    function loadAllProduct(){
        console.log('Fetching all address');
        $http.get("http://localhost:8081/v1/shopee/address")
            .then(
                function (response){
                    console.log('Thành công')
                    $scope.productList = response.data;
                }
            )
    }
    function updateAddress(){
        $scope.updateAddress = function(){
            $http.put("http://localhost:8081/v1/shopee/address", $scope.address)
                .then(
                    function (response){
                        loadAllAddress();
                    }
                )
        }
    }

    $scope.editProduct = function (x) {
        $scope.product.id = x.addressId;
        $scope.product.addressName = x.addressName;
        $scope.product.addressCity = x.addressCity;
    }

    $scope.removeAddress = function (x){
        $http.remove("http://localhost:8081/v1/shopee/address", $scope.address)
            .then(function (response){
                $scope.addressList = response.data;
            })
    }
})
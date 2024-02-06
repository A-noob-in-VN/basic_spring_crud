// var app = angular.module('myApp', []);
// app.controller('AddressController', function ($scope, $http, $q) {
//
//         $scope.addressList = [];
//         getAllAddress();
//         // loadAllAddress();
//         // createAddress();
//         // updateAddress();
//         // deleteAddress();
//         // editAddress();
//         // removeUser();
//
//         function getAllAddress() {
//             $http.get("http://localhost:8081/v1/shopee/address").then(function (response) {
//                 $scope.addressList = response.data;
//             })
//
//         }
//
//         function loadAllAddress(){
//             console.log('Fetching all address');
//             $http.get("http://localhost:8081/v1/shopee/address")
//                 .then(
//                     function (response){
//                         console.log('Thành công')
//                         $scope.addressList = response.data;
//                     }
//                 )
//         }
//
//         function createAddress() {
//             console.log('Khởi tạo địa chỉ')
//             // var deferred = $q.defer();
//             $http.post("http://localhost:8081/v1/shopee/address")
//             .then(
//                 function (response) {
//                 loadAllAddress();
//                 // $scope.addressList = response.data;
//                 // deferred.resolve(response.data);
//             })
//         }
//
//         function updateAddress() {
//             console.log('Sửa địa chỉ');
//             $http.put("http://localhost:8081/v1/shopee/address")
//                 .then(
//                     function (response){
//                         loadAllAddress();
//                         $scope.addressList = response.data;
//                     }
//                 )
//         }
//
//         $scope.editAddress = function () {
//             updateAddress();
//         }
//
//         function deleteAddress() {
//         }
//
//         function editAddress() {
//
//         }
//
//         function removeUser() {
//
//         }
//     })
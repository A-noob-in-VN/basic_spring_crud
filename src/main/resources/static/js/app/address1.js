var app = angular.module('myApp', []);
app.controller('AddressController1', function ($scope, $http) {

    $scope.addressList = [];
    $scope.address = {};

    getAllAddress();
    // getAddress();
    // loadAllAddress();
    // createAddress();
    updateAddress();
    // deleteAddress();
    // editAddress();
    // removeUser();

    // self.editUser = editUser;

    // return{
    //     getAddress: getAddress
    // };
    function getAllAddress() {
        $http.get("http://localhost:8081/v1/shopee/address").then(function (response) {
            $scope.addressList = response.data;
        })

    }

    function loadAllAddress(){
        console.log('Fetching all address');
        $http.get("http://localhost:8081/v1/shopee/address")
            .then(
                function (response){
                    console.log('Thành công')
                    $scope.addressList = response.data;
                }
            )
    }
    function updateAddress(){
        $scope.updateAddress = function(){
            $http.put("http://localhost:8081/v1/shopee/address", $scope.address)
                .then(
                    function(){
                        loadAllAddress();
                    }
                )
        }
    }

    $scope.editAddress = function (x) {
        $scope.address.id = x.addressId;
        $scope.address.addressName = x.addressName;
        $scope.address.addressCity = x.addressCity;
    }})

//     $scope.removeAddress = function (x){
//         $http.remove("http://localhost:8081/v1/shopee/address", $scope.address)
//             .then(function (response){
//                 $scope.addressList = response.data;
//             })
//     }
//})
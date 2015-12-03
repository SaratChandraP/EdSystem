/**
 * Created by Sarat Chandra on 11/27/2015.
 */

angular.module('myJS',[])
    .controller('myCtrl1', function($scope){
        $scope.firstName = "sarat";
        $scope.lastName = "chandra";

    })

    .controller('myCtrl2', function($scope){
        $scope.num = 4357;
    })


;
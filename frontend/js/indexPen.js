'use strict';

// Declare app level module which depends on filters, and services
angular.module('myApp', []);

/* Controllers */
function stageController($scope) {

    $scope.username2 = 'Clark Kent';

    $scope.submitForm = function () {
        console.info("Here I should implement the logic to send a request to the server.");
    }

}
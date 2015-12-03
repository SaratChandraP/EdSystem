angular.module('todoApp', [])
  .controller('TestCtrl', function($scope, $http) {

    refreshAllTests();

    $scope.addTest = function(test) {
      $http.put('/api/test', test).then(function(response) {
        refreshAllTests();
      });
    }

      $scope.deleteTest= function(id) {
          $http.delete('/api/test/'+id).then(function(response) {
              refreshAllTests();
          });
      }

    function refreshAllTests() {
      $http.get('/api/test').then(function(response) {
        $scope.tests= response.data;
      });      
    }
  });
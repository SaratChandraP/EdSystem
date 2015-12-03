angular.module('todoApp', [])
  .controller('DemoCtrl', function($scope, $http) {

    refreshAll();

    $scope.addTest = function(item) {
      $http.put('/api/test', item).then(function(response) {
        refreshAll();
      });
    }

      $scope.deleteTest= function(id) {
          $http.delete('/api/test/'+id).then(function(response) {
              refreshAll();
          });
      }

    function refreshAll() {
      $http.get('/api/test').then(function(response) {
        $scope.items= response.data;
          $scope.answers=response.data.answer;
      });      
    }
  });
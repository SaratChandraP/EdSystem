angular.module('questionsApp', [])
  .controller('questionsCtrl', function($scope, $http) {

      function refreshAll() {
      $http.get('/api/question').then(function(response) {
        $scope.items= response.data;
          $scope.answers=response.data.answer;
          //$scope.items[i].id;
          $scope.j=0;
          $scope.nextQuestion=myFunction()
          {
              $scope.j++;
          }

      });
    }

  });
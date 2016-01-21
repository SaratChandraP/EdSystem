angular.module('questionsApp', [])
  .controller('questionsCtrl', function($scope, $http) {

      refreshAll();

      $scope.questionnum = '1';

      function refreshAll() {
      $http.get('/api/questions/1').then(function(response) {
          $scope.questionSingle= response.data;
          //$scope.items[i].id;
          //$scope.j=0;
          //$scope.nextQuestion=myFunction()
          //{
          //    $scope.j++;
          //}

      });
    }

  });
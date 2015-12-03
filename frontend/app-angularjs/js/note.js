angular.module('todoApp', [])
  .controller('NoteCtrl', function($scope, $http) {

    refreshAllNotes();

    $scope.addNote = function(note) {
      $http.put('/api/note', note).then(function(response) {
        refreshAllNotes();
      });
    }

      $scope.deleteNote= function(id) {
          $http.delete('/api/note/'+id).then(function(response) {
              refreshAllNotes();
          });
      }

    function refreshAllNotes() {
      $http.get('/api/note').then(function(response) {
        $scope.notes = response.data;
      });      
    }
  });
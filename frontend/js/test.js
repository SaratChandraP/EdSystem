angular.module('questionsApp', [])
    .controller('questionsCtrl', function($scope, $http) {

        refreshAll();

        //$scope.questionnum = '1';

        function refreshAll() {
            $http.get('/api/questions').then(function (response) {
            });

            //$scope.questionSingle=response.data;

            $scope.i=-1;

            $scope.myFunction=function(){
                $scope.i++;
                //$scope.questions=data;

                $scope.questions = [{id:'1', question:'Name?', option1:'1', option2:'2', option3:'3',option4:4},
                    {id:'2',question:'Age?', option1:'2', option2:'2', option3:'3',option4:4},
                    {id:'3',question:'City?', option1:'3', option2:'2', option3:'3',option4:4},
                ];

            }
                //$scope.items[i].id;
                //$scope.j=0;
                //$scope.nextQuestion=myFunction()
                //{
                //    $scope.j++;
                //}
            //});


        }

    });

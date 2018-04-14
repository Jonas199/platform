var app = angular.module('MyPlattform', ['ngMaterial','ngMessages' ]); 
app.controller("myCtrl", function ($scope, $http) {
            	
				$scope.selectedTab = 0;
				$scope.selectTab = function(tab) {
					$scope.selectedTab = tab;
				}
				
				$scope.createNewUser = function () {
                   // use $.param jQuery function to serialize data from JSON 
        			console.log('Anfrage createNewUser gestartet: ');
					$scope.selectTab(1);	
                     var data = {
                    		 UserName : $scope.UserName
                    }; 
                    
                    $http.post('http://localhost:8080/LearnPlattform-0.0.1-SNAPSHOT/service/Plattform/USERS', JSON.stringify(data))
                    .success(function (data, status, headers, config) {
                        $scope.PostDataResponse = data;
			        })
                    .error(function (data, status, header, config) {
                        $scope.ResponseDetails = "Data: " + data +
                            "<hr />status: " + status +
                            "<hr />headers: " + header +
                            "<hr />config: " + config;
                    }); 
                };
				$scope.createNewCourse = function () {
	                   // use $.param jQuery function to serialize data from JSON 
	        			console.log('Anfrage createNewCourse gestartet: ');
						$scope.selectTab(1);	
	                     var data = {
	                    		 CourseName  : $scope.CourseName,
	                    		 CourseTopic : $scope.CourseTopic
	                    }; 
	                    
	                    $http.post('http://localhost:8080/LearnPlattform-0.0.1-SNAPSHOT/service/Plattform/COURSES', JSON.stringify(data))
	                    .success(function (data, status, headers, config) {
	                        $scope.PostDataResponse = data;
				        })
	                    .error(function (data, status, header, config) {
	                        $scope.ResponseDetails = "Data: " + data +
	                            "<hr />status: " + status +
	                            "<hr />headers: " + header +
	                            "<hr />config: " + config;
	                    }); 
	                };
            });
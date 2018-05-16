var app = angular.module('MyPlattform', ['ngMaterial','ngMessages' ]); 
app.controller("myCtrl", function ($scope, $http) {
            	
				$scope.selectedTab = 0;
				$scope.courses = [{"CourseId":0,"name":"test","topic":"test","numberOfParticipants":0}];
				$scope.users;
				$scope.selectTab = function(tab) {
					$scope.selectedTab = tab;
				}
				
				$scope.createNewUser = function () {
                   // use $.param jQuery function to serialize data from JSON 
        			console.log('Anfrage createNewUser gestartet: ');
					$scope.selectTab(2);	
                     var data = {
                    		 UserName : $scope.UserName
                    }; 
                    
                    $http.post('http://localhost:8080/LearnPlattform-0.0.1-SNAPSHOT/service/Plattform/USERS', JSON.stringify(data))
                    .success(function (data, status, headers, config) {
                        $scope.PostDataResponse = data;
                        $scope.getUsers();
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
	                        $scope.getCourses();
				        })
	                    .error(function (data, status, header, config) {
	                        $scope.ResponseDetails = "Data: " + data +
	                            "<hr />status: " + status +
	                            "<hr />headers: " + header +
	                            "<hr />config: " + config;
	                    }); 
	                };
					$scope.getCourses = function () {
		                   // use $.param jQuery function to serialize data from JSON 
		        			console.log('Anfrage getCourses gestartet: ');
				            $http.get('http://localhost:8080/LearnPlattform-0.0.1-SNAPSHOT/service/Plattform/COURSES')
				            .then(function(response) {
				                $scope.courses = response.data;
				                console.log('courses= ' + $scope.courses[0].name);
				            });
		                };
						$scope.getUsers = function () {
			                   // use $.param jQuery function to serialize data from JSON 
			        			console.log('Anfrage getUsers gestartet: ');
					            $http.get('http://localhost:8080/LearnPlattform-0.0.1-SNAPSHOT/service/Plattform/USERS')
					            .then(function(response) {
					                $scope.users = response.data;
					                console.log('users= ' + $scope.users);
					            });
			                };
            });
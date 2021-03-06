<!DOCTYPE html>
<html lang="de">
<head>
<meta charset="utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Angular Material style sheet -->
 <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.0/angular-material.min.css"> 
  <link rel="stylesheet" href="Plattform.css"> 
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
  <body ng-cloak="" class="tabsdemoDynamicHeight" ng-app="MyPlattform" >
  <!-- Angular Material requires Angular.js Libraries -->
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-animate.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-aria.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-messages.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-aria.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-messages.min.js"></script>
 
  <!-- Angular Material Library -->
  <script src="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.0/angular-material.min.js"></script>
  <!-- Your application bootstrap  -->
  <script src="Plattform.js"></script> 
  <div ng-controller="myCtrl">
  <md-content>
    <md-tabs md-dynamic-height="" md-border-bottom="" md-selected="selectedTab">
      <md-tab label="GETTING STARTED">
        <md-content class="md-padding">
    <md-radio-group ng-model="data.group1">
      <md-radio-button value="USER" class="md-primary">Register</md-radio-button>
      <md-radio-button value="COURSE">Create New Course </md-radio-button>
    </md-radio-group>
    <hr>
		<div  id="user"  ng-show="(data.group1 == 'USER')">
	     <h2 class="md-display-2">Register</h2>
         <table>
<!-- 		  <tr> -->
<!-- 		    <th>Value</th> -->
<!-- 		    <th>Input</th>  -->
<!-- 		 </tr> -->
		  <tr>
		    <td>
		    	<h4>Username</h4>
		    </td>
		    <td>
		    	<input ng-model="UserName"  placeholder="MyUsername...">
		    </td>
		  </tr>
		  		  <tr>
		    <td>
		    	<h4>Password</h4>
		    </td>
		    <td>
		    	<input ng-model="Password"  placeholder="Password..." type="password" >
		    </td>
		  </tr>
		  		    <td>
		    	<h4>Mail</h4>
		    </td>
		    <td>
		    	<input ng-model="Mail"  placeholder="MyUser@...">
		    </td>
		  </tr>
		</table>
		<div>
		<button ng-click="createNewUser()" >Create</button>
		</div>
		</div>
		<div  id="course" ng-show="(data.group1 == 'COURSE')">		
		 <h2 class="md-display-2">Create New Course</h2>
         <table>
<!-- 		  <tr> -->
<!-- 		    <th>Value</th> -->
<!-- 		    <th>Input</th>  -->
<!-- 		 </tr> -->
		  <tr>
		    <td>
		    	<h4>Course Name</h4>
		    </td>
		    <td>
		    	<input ng-model="CourseName"  placeholder="MyCourse...">
		    </td>
		  </tr>
		  <tr>
		    <td>
		    	<h4>Course Topic</h4>
		    </td>
		    <td>
		    	<input ng-model="CourseTopic"  placeholder="MyTopic...">
		    </td>
		  </tr>
		</table>
		<div>
		<button ng-click="createNewCourse()" >Create</button>
		</div>
		</div>
        </md-content>
      </md-tab>
      <md-tab label="COURSES">
        <md-content class="md-padding">
          <h2 class="md-display-2">Courses</h2>
		  	<button ng-click="getCourses()">
				<i class="fa fa-refresh" style="font-size:24px" ></i>
			</button>
			<table>
		  <tr >
		    <th width = 300>ID</th>
		    <th width = 300>NAME</th>
		    <th width = 300>TOPIC</th>
		    <th width = 300>PARTICIPANTS</th>
		    <th width = 300>PARTICIPATE</th>
		   </tr>
		  <tr ng-repeat = "course in courses">
		    <td>
		    	<h4>{{course.CourseId}}</h4>
		    </td>
			<td>
		    	<h4>{{course.name}}</h4>
		    </td>
		    <td>
		    	<h4>{{course.topic}}</h4>
		    </td>
		    <td>
		    	<h4>{{course.numberOfParticipants}}</h4>
		    </td>
		    <td>
		    	<button ng-click="participate()">Participate</button>
		    </td>
		 </tr>
		</table>
        </md-content>
      </md-tab>
       <md-tab label="USERS">
        <md-content class="md-padding">
          <h2 class="md-display-2">Users</h2>
		  	<button ng-click="getUsers()">
				<i class="fa fa-refresh" style="font-size:24px" ></i>
			</button>
			<table>
		  <tr >
		    <th width = 300>ID</th>
		    <th width = 300>NAME</th>
		   </tr>
		  <tr ng-repeat = "user in users">
		    <td>
		    	<h4>{{user.UserId}}</h4>
		    </td>
			<td>
		    	<h4>{{user.name}}</h4>
		    </td>
		 </tr>
		</table>
        </md-content>
      </md-tab>
    </md-tabs>
  </md-content>
</div>
</body>
</html>




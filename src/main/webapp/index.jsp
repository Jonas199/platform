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
      <md-tab label="REQUESTS">
        <md-content class="md-padding">
    <md-radio-group ng-model="data.group1">
      <md-radio-button value="USER" class="md-primary">Create New User</md-radio-button>
      <md-radio-button value="COURSE">Create New Course </md-radio-button>
    </md-radio-group>
    <hr>
		<div  id="user"  ng-show="(data.group1 == 'USER')">
		
          <h2 class="md-display-2">Create New User</h2>
         <table>
		  <tr>
		    <th>Value</th>
		    <th>Input</th> 
		 </tr>
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
		    	<h4>Common Name</h4>
		    </td>
		    <td>
		    	<input ng-model="CommonName"  placeholder="VPN Client...">
		    </td>
		  </tr>
		  <tr>
		    <td>
		    	<h4>Country</h4>
		    </td>
		    <td>
		    	<input ng-model="Country"  placeholder="DE...">
		    </td>
		  </tr>
		   <tr>
		    <td>
		    	<h4>State</h4>
		    </td>
		    <td>
		    	<input ng-model="State"  placeholder="Bavaria...">
		    </td>
		  </tr>
		  	<tr>
		    <td>
		    	<h4>Location</h4>
		    </td>
		    <td>
		    	<input ng-model="Location"  placeholder="Munich...">
		    </td>
		  </tr>
		  <tr>
		    <td>
		    	<h4>Organization</h4>
		    </td>
		    <td>
		    	<input ng-model="Organization"  placeholder="MyCompany...">
		    </td>
		  </tr>
		   <tr>
		    <td>
		    	<h4>Organization Unit</h4>
		    </td>
		    <td>
		    	<input ng-model="OrganizationUnit"  placeholder="Sales...">
		    </td>
		  </tr>
		</table>
		<div>
		<button ng-click="createNewUser()" >Submit Request</button>
		</div>
		</div>
		<div  id="course" ng-show="(data.group1 == 'COURSE')">		
		 <h2 class="md-display-2">Create New Course</h2>
         <table>
		  <tr>
		    <th>Value</th>
		    <th>Input</th> 
		 </tr>
		  <tr>
		    <td>
		    	<h4>Course Name</h4>
		    </td>
		    <td>
		    	<input ng-model="CommonName"  placeholder="VPN Client...">
		    </td>
		  </tr>
		  <tr>
		    <td>
		    	<h4>Country</h4>
		    </td>
		    <td>
		    	<input ng-model="Country"  placeholder="DE...">
		    </td>
		  </tr>
		   <tr>
		    <td>
		    	<h4>State</h4>
		    </td>
		    <td>
		    	<input ng-model="State"  placeholder="Bavaria...">
		    </td>
		  </tr>
		  	<tr>
		    <td>
		    	<h4>Location</h4>
		    </td>
		    <td>
		    	<input ng-model="Location"  placeholder="Munich...">
		    </td>
		  </tr>
		  <tr>
		    <td>
		    	<h4>Organization</h4>
		    </td>
		    <td>
		    	<input ng-model="Organization"  placeholder="MyCompany...">
		    </td>
		  </tr>
		   <tr>
		    <td>
		    	<h4>Organization Unit</h4>
		    </td>
		    <td>
		    	<input ng-model="OrganizationUnit"  placeholder="Sales...">
		    </td>
		  </tr>
		</table>
		<div>
		<button ng-click="SendData()" >Submit Request</button>
		</div>
		</div>
        </md-content>
      </md-tab>
      <md-tab label="CMP MESSAGES">
        <md-content class="md-padding">
          <h2 class="md-display-2">CMP Messages</h2>
		  	<button>
				<i class="fa fa-refresh" style="font-size:24px" ng-click="Refresh()"></i>
			</button>
			<table>
		  <tr >
		    <th>ID</th>
		    <th>Type</th>
		    <th>Status</th>
			<th>TimeStamp</th>
			<th>Source</th>
		   </tr>
		  <tr ng-repeat = "cmpMessage in cmpMessages">
		    <td>
		    	<h4>{{::cmpMessage.ID}}</h4>
		    </td>
			<td>
		    	<h4>{{::cmpMessage.Type}}</h4>
		    </td>
		    <td>
		    	<h4>{{::cmpMessage.Status}}</h4>
		    </td>
			<td>
		    	<h4>{{::cmpMessage.TimeStamp}}</h4>
		    </td>
			<td>
		    	<h4>{{::cmpMessage.Source}}</h4>
		    </td>
		 </tr>
		</table>
        </md-content>
      </md-tab>
      <md-tab label="SETTINGS">
        <md-content class="md-padding">
          <h2 class="md-display-2">Settings</h2>
           <table>
		  <tr>
		  <h2>Certificate Authority</h2>
		    <th>Name</th>
		    <th>Url</th> 
		 </tr>
		  <tr>
		    <td>
		    	<input ng-model="Name"  placeholder="MyCertificateAuthority...">
		    </td>
		    <td>
		    	<input ng-model="Url"  placeholder="www.MyCA.com/cmp/...">
		    </td>
		  </tr>
		  
		</table>
		<div>
		<button ng-click="SaveSettings()">Save Settings</button>
		</div>
        </md-content>
      </md-tab>
	   <md-tab label="TOOLS">
        <md-content class="md-padding">
          <h2 class="md-display-2">Tools</h2>
		  <ul>
			<li><a href="https://www.sslshopper.com/csr-decoder.html">Decode CSR File</a>
			</li>
			<li><a href="https://lapo.it/asn1js/">DER to ASN1 Decoder</a>
		</ul>
       </md-content>
      </md-tab>
    </md-tabs>
  </md-content>
</div>
</body>
</html>




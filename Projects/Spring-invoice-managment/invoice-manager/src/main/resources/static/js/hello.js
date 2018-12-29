(function(){  
	

angular.module('app', [ 'ui.router', 'ngResource' ])

//	ui-route config

.config(function($stateProvider, $urlRouterProvider) {
  $urlRouterProvider.otherwise("/");
  $stateProvider
    .state('home', {
      url: "/",
      templateUrl: "partials/templates/home.html"
    })
    .state('home.resource', {
      url: "home/resource",
      templateUrl: "partials/templates/home.resource.html",
      controller: function($scope, $http) {
    	$http.get('/resource/').success(function(data) {
    		$scope.greeting = data;
    	})
      }
    })
    .state('phoneType', {
      url: "/phoneType",
     // abstract: true,
      templateUrl: "partials/templates/phoneType/phoneType.html"
      //controller: ''
    })
    .state('phoneType.new', {
      url: "/new",
      templateUrl: "partials/templates/phoneType/phoneType.new.html",
      controller: 'PhoneTypeNewController'
    })
    .state('phoneType.edit', {
      url: "/:id/edit",
      templateUrl: "partials/templates/phoneType/phoneType.edit.html",
      controller: 'PhoneTypeEditController'
    })
    .state('phoneType.list', {
      url: "/list",
      templateUrl: "partials/templates/phoneType/phoneType.list.html",
      controller: 'PhoneTypeListController'
    })
    .state('login', {
      url: "/login",
      templateUrl: "partials/templates/login/login.html",
      controller: 'loginController'
    })
    .state('logout', {
      url: "/logout",
      template: "<p>logging out..</p>",
      controller: "logoutController"
    });
})

//	services for /api/

.factory('PhoneType', ['$resource',
  function($resource){
    return $resource('api/phoneType/:id', {}, {
      query: {method:'GET', isArray:false}
    });
  }])

//	controllers attached to states
  
.controller('PhoneTypeListController', function($scope, PhoneType, $state) { 
	$scope.phoneTypeList = {};
    $scope.phoneTypeList = PhoneType.query();
    $scope.deleteItem = function(id){
    	PhoneType.delete({id: id}, function(){
    		$scope.phoneTypeList = PhoneType.query();
    		//$state.go('phoneType.list', {}, { });
    	});
    };
    
})
.controller('PhoneTypeNewController', function($scope, PhoneType, $state) {
	$scope.phoneTypeNew = {};
	  $scope.phoneTypeNew = new PhoneType();
	  $scope.phoneTypeForm = function(){
	   	 $scope.phoneTypeNew.$save(function(){
	   		$scope.phoneTypeList = PhoneType.query();
	         $state.go('phoneType.list');
	     });
	  };
  	
  
})
.controller('PhoneTypeEditController', function($scope, PhoneType, $state, $stateParams) {
		$scope.phoneTypeEdit = PhoneType.get({ id: $stateParams.id });
		//console.log(PhoneType.get({ id: $stateParams.id }));
		$scope.phoneTypeFormEdit = function(){	
			PhoneType.save({id: $stateParams.id, name: $scope.phoneTypeEdit.name}, function(){
				$state.go('phoneType.list');
			});
		};
})
.controller('loginController', function($rootScope, $scope, $http, $state) {
		
		$scope.credentials = {};
		$scope.login = function() {
			$http.post('login', $.param($scope.credentials), {
				headers : {
					"content-type" : "application/x-www-form-urlencoded"
				}
			}).success(function(data) {
				$rootScope.authenticate(function() {
					if ($rootScope.authenticated) {
						//$location.path("/");
						$scope.error = false;
						$state.go('home');
					} else {
						//$location.path("/login");
						$scope.error = true;
						$rootScope.authority = {};
						$state.go('login');
					}
				});
			}).error(function(data) {
				//$location.path("/login");
				$scope.error = true;
				$rootScope.authenticated = false;
				$rootScope.authority = {};
				$state.go('login');
			})
		};
  })
  .controller('logoutController', function($scope, $http, $rootScope, $state) {
      $scope.logout = function() {
			$http.post('logout', {}).success(function() {
				$rootScope.authenticated = false;
				$rootScope.authority = {};
				$state.go('home');
			}).error(function(data) {
				$rootScope.authenticated = false;
				$rootScope.authority = {};
				$state.go('home');
			});
		};
		$scope.logout();
    })

//	custom directives
    
.directive('navigationBar', function(){
	return{
		
		restrict: 'E',
		templateUrl: '/partials/templates/navigationBar.html',
		controller: 
			function($rootScope, $scope, $http, $state, $window){
			
				// auth check on page reload
				$rootScope.authenticate = 
				function(callback) {
				$http.get('user').success(function(data) {
					if (data.name) {
						$rootScope.authenticated = true;
						$rootScope.authority = data.authorities[0].authority;
					} else {
						$rootScope.authenticated = false;
						$rootScope.authority = {};
						//$state.go('login');
					}
					callback && callback();
				}).error(function() {
					$rootScope.authenticated = false;
					$rootScope.authority = {};
					$state.go('login');
					callback && callback();
				});
				}	
					
				$rootScope.authenticate();
				
			},
		controllerAs: 'navBar'
	}
})
;

})();

/* sample data from PricipalController at /user/
 * {
 * "details":{"remoteAddress":"0:0:0:0:0:0:0:1","sessionId":"EC2C5162D9C8A5A2A13F7023DF2F8BCD"},
 * "authorities":[{"authority":"ROLE_USER"}], "authenticated":true,
 * "principal":{ "password":null, "username":"user", "authorities":[{
 * "authority":"ROLE_USER"}], "accountNonExpired":true, "accountNonLocked":true,
 * "credentialsNonExpired":true, "enabled":true }, "credentials":null,
 * "name":"user"}
 * 
 */

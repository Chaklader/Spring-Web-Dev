angular.module('org.privatechat.login.LoginController', [
  'org.privatechat.user.AuthService',
  'org.privatechat.user.UserService',
]).controller('LoginController', ['$scope', '$location', 'AuthService', 'UserService',
  function($scope, $location, AuthService, UserService, WebSocketConnection) {
    var self = $scope;

    self.email = null;
    self.password = null;

    var construct = function() {};

    var routeToFriendsList = function() {
      $location.path('/friendslist');
    };

    self.attemptLogin = function() {
      AuthService.login({
          username: self.email,
          password: self.password
        })
        .then(function() {
          return UserService.establishUserInfo();
        })
        .then(function() {
          routeToFriendsList();
        })
        .catch(function() {
          alert('Invalid credentials.');
        });
    };

    construct();
  }
]);
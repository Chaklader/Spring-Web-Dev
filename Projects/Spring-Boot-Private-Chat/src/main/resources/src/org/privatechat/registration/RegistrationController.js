angular.module('org.privatechat.registration.RegistrationController', [
  'org.privatechat.user.AuthService',
]).controller('RegistrationController', ['$scope', '$location', 'AuthService',
  function($scope, $location, AuthService) {
    var self = $scope;

    self.email = null;
    self.password = null;
    self.fullName = null;

    var construct = function() {};

    var routeToLogin = function() {
      $location.path('/login');
    };

    self.attemptRegistration = function() {
      AuthService.register({
        email: self.email,
        password: self.password,
        fullName: self.fullName,
      })
      .then(function() {
        alert('Successfully registered.');
        routeToLogin();
      })
      .catch(function(err) {
        alert(err.data);
      });
    };

    construct();
  }
]);
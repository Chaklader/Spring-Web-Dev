angular.module('org.privatechat.user.AuthService', [
    'org.privatechat.user.UserService',
    'org.privatechat.shared.websocket.WebSocket'
  ])
  .factory('AuthService', ['$http', '$location', 'UserService', 'WebSocket', '$rootScope',
    function($http, $location, UserService, WebSocket, $rootScope) {
      var login = function(loginDTO) {
        return $http({
          method: 'POST',
          url: '/login',
          data: $.param(loginDTO),
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
          }
        });
      };

      var logout = function() {      
        UserService.clearUserInfo();
        WebSocket.disconnect();
        $location.path('/');

        return $http({
          method: 'POST',
          url: '/logout'
        });
      };

      $rootScope.$on('logout-event', logout);

      var register = function(registerDTO) {
        return $http({
          method: 'POST',
          url: '/api/user/register',
          data: registerDTO,
          headers: {
            'Content-Type': 'application/json'
          }
        });
      };

      // TODO: currently just checking to see if the user's
      // metadata cookie is in place... not very robust. Call
      // the service to confirm this.
      var hasActiveSession = function() {
        var info = UserService.getUserInfo();

        return (info !== null) ? true : false;
      };

      return {
        login: login,
        register: register,
        hasActiveSession: hasActiveSession
      };
    }
  ]);
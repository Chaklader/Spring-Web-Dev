angular.module('org.privatechat.shared.theme.Navbar', [
    'org.privatechat.user.AuthService',
    'org.privatechat.user.notification.NotificationDirective'
  ])
  .directive('navbar', function() {
    return {
      restrict: 'E',
      templateUrl: 'shared/theme/NavbarView.html',
      controller: ['$scope', '$rootScope', 'AuthService',
        function($scope, $rootScope, AuthService) {
          var self = $scope;

          self.hasActiveSession = false;

          self.construct = function() {
            self.hasActiveSession = AuthService.hasActiveSession();
          };

          self.logout = function() {
            $rootScope.$broadcast('logout-event');
          };

          self.construct();
        }
      ]
    };
  });
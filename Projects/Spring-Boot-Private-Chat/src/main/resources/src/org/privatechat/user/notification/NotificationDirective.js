angular.module('org.privatechat.user.notification.NotificationDirective', [
    'org.privatechat.user.notification.NotificationController'
  ])
  .directive('notifications', function() {
    return {
      restrict: 'E',
      templateUrl: 'user/notification/NotificationView.html',
      controller: 'NotificationController'
    };
  });
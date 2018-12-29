angular.module('org.privatechat.user.notification.NotificationService', [

  ])
  .factory('NotificationService', [
    function() {
      var notifications = [];
      
      return {
        notifications: notifications,
      };
    }
  ]);
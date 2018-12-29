angular.module('org.privatechat.user.notification.NotificationController', [
  'org.privatechat.user.AuthService',
  'org.privatechat.shared.websocket.WebSocket',
  'org.privatechat.user.UserService',
  'org.privatechat.user.notification.NotificationService'
]).controller('NotificationController', ['$scope', 'AuthService', 'WebSocket', '$location', 'UserService', 'NotificationService',
  function($scope, AuthService, WebSocket, $location, UserService, NotificationService) {
    var self = $scope;

    var notificationsWebSocket;
    
    self.construct = function() {
      establishChannel();
    };

    var establishChannel = function() {
      notificationsWebSocket = WebSocket.get();
      notificationsWebSocket.subscribe(
        '/topic/user.notification.' + UserService.getUserInfo().id,
        onMessage
      );
      self.notifications = NotificationService.notifications;
    };

    var notificationStrategies = {
      'ChatMessageNotification': {
        
        onMessage: function(notification) {
          var notificationPath = '/private-chat/' + notification.fromUserId;

          var isDuplicateNotification = _.any(NotificationService.notifications, {
            fromUserId: notification.fromUserId,
            type: 'ChatMessageNotification'
          });

          if ($location.path() !== notificationPath && !isDuplicateNotification) {
            notification.path = notificationPath;
            NotificationService.notifications.push(notification);
            self.$apply();
          }
        },

        onAcknowledgement: function(notification) {
          var index = NotificationService.notifications.indexOf(notification);
          NotificationService.notifications.splice(index, 1);
          $location.path(notification.path);
        }
      }
    };

    var onMessage = function(rawNotification) {
      var notification = JSON.parse(rawNotification.body);

      notificationStrategies[notification.type].onMessage(notification);
    };

    self.acknowledgeNotification = function(notification) {
      notificationStrategies[notification.type].onAcknowledgement(notification);
    };

    WebSocket.whenConnected(self.construct);
  }
]);
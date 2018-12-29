angular.module('org.privatechat.chat.ChatController', [
  'org.privatechat.shared.theme.Navbar',
  'org.privatechat.chat.ChatService',
  'org.privatechat.user.UserService',
  'org.privatechat.shared.websocket.WebSocket'
]).controller('ChatController', ['$scope', '$routeParams', 'ChatService', 'UserService', '$timeout', 'WebSocket',
  function($scope, $routeParams, ChatService, UserService, $timeout, WebSocket) {
    var self = $scope;

    var chatWebSocket;
    var channelUuid;
    var MESSAGES_RENDERING_WAIT_TIME = 1000;
    
    // TODO: implement .catch if user isn't authorized
    // to chat with this user (i.e.: not in friendslist)
    var construct = function() {
      ChatService
        .establishChatSession(UserService.getUserInfo().id, $routeParams.id)
        .then(establishChannel)
        .then(getExistingChatMessages);
      };
      
    var establishChannel = function(channelDetailsPayload) {
      chatWebSocket = WebSocket.get();
      channelUuid = channelDetailsPayload.data.channelUuid;
      self.userOneFullName = channelDetailsPayload.data.userOneFullName;
      self.userTwoFullName = channelDetailsPayload.data.userTwoFullName;
      chatWebSocket.subscribe('/topic/private.chat.' + channelUuid, onMessage);
    };

    var getExistingChatMessages = function() {
      ChatService
        .getExistingChatSessionMessages(channelUuid)
        .then(function(messages) {
          self.showChat = true;

          messages.data
            .forEach(function(message) {
              addChatMessageToUI(message);
            });

          scrollToLatestChatMessage();
        });
    };

    var scrollToLatestChatMessage = function() {
      var chatContainer = $('#chat-area');

      $timeout(function() {
        if (chatContainer.length > 0) { chatContainer.scrollTop(chatContainer[0].scrollHeight); }        
      }, MESSAGES_RENDERING_WAIT_TIME);
    };

    var addChatMessageToUI = function(message, withForceApply) {
      self.messages
        .push({
          contents: message.contents,
          isFromRecipient: message.fromUserId != UserService.getUserInfo().id,
          author: (message.fromUserId == UserService.getUserInfo().id) ? self.userOneFullName : self.userTwoFullName
        });

      if (withForceApply) { self.$apply(); }
    };

    var onMessage = function(response) {
      addChatMessageToUI(JSON.parse(response.body), true);
      scrollToLatestChatMessage();
    };

    self.sendChatMessage = function() {
      if (!self.currentMessage || self.currentMessage.trim() === '') return;

      chatWebSocket.send("/app/private.chat." + channelUuid, {}, JSON.stringify({
        fromUserId: UserService.getUserInfo().id,
        toUserId: $routeParams.id,
        contents: self.currentMessage
      }));

      self.currentMessage = null;
    };

    WebSocket.whenConnected(construct);
  }
]);
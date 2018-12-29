angular.module('org.privatechat.chat.ChatService', [

  ])
  .factory('ChatService', ['$http',
    function($http) {

      var establishChatSession = function(userIdOne, userIdTwo) {
        return $http({
          method: 'PUT',
          url: '/api/private-chat/channel',
          data: {
            userIdOne: userIdOne,
            userIdTwo: userIdTwo
          },
          headers: {
            'Content-Type': 'application/json'
          }
        });
      };

      var getExistingChatSessionMessages = function(channelUuid) {
        return $http({
          method: 'GET',
          url: '/api/private-chat/channel/' + channelUuid,
          headers: {
            'Content-Type': 'application/json'
          }
        });
      };

      return {
        establishChatSession: establishChatSession,
        getExistingChatSessionMessages: getExistingChatSessionMessages,
      };
    }
  ]);
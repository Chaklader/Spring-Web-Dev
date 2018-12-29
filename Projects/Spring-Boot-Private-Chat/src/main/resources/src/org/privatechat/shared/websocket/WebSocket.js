angular.module('org.privatechat.shared.websocket.WebSocket', [
  ])
  .factory('WebSocket', [function() {
    var socket;

    var WHEN_CONNECTED_CALLBACK_WAIT_INTERVAL = 1000;

    var connect = function() {
      socket = Stomp.over(new SockJS('/ws'));
      socket.debug = null;
      socket.connect({}, onOpen, onClose);
    };

    var disconnect = function() {
      socket.disconnect();
      socket = null;
    };
    
    var onOpen = function() {};

    var onClose = function() {
      alert('You have disconnected, hit "OK" to reload.');
      window.location.reload();
    };

    var isConnected = function() {
      return (socket && socket.connected);
    };

    var whenConnected = function(_do) {
      setTimeout(
        function() {
          if (isConnected()) {
            if (_do !== null) { _do(); }
            return;
          } else {
            whenConnected(_do);
          }

        }, WHEN_CONNECTED_CALLBACK_WAIT_INTERVAL);
    };

    return {
      get: function() { return socket; },
      connect: connect,
      disconnect: disconnect,
      isConnected: isConnected,
      whenConnected: whenConnected
    };
  }
]);
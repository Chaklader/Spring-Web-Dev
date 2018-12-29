angular.module('org.privatechat.user.UserService', [

  ])
  .factory('UserService', ['$http',
    function($http) {
      var USER_INFO = 'USER_INFO';

      var getFriendslist = function() {
        return $http({
          method: 'GET',
          url: '/api/user/requesting/friendslist',
          headers: {
            'Content-Type': 'application/json'
          }
        });
      };

      var establishUserInfo = function() {
        return $http({
            method: 'GET',
            url: '/api/user/requesting/info',
          })
          .then(function(res) {
            if (res && res.data) {
              $.cookie(USER_INFO, JSON.stringify({
                id: parseInt(res.data.id, 10),
                fullName: res.data.fullName,
                email: res.data.email,
              }));
            }

            return;
          });
      };

      var clearUserInfo = function() {
        $.removeCookie(USER_INFO);
      };

      var getUserInfo = function() {
        var rawInfo = $.cookie(USER_INFO);

        return (rawInfo) ? JSON.parse($.cookie(USER_INFO)) : null;
      };

      return {
        getFriendslist: getFriendslist,
        getUserInfo: getUserInfo,
        establishUserInfo: establishUserInfo,
        clearUserInfo: clearUserInfo,
      };
    }
  ]);
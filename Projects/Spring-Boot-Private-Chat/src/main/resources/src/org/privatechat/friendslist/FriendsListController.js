angular.module('org.privatechat.friendslist.FriendsListController', [
  'org.privatechat.shared.theme.Navbar',
  'org.privatechat.user.UserService'
]).controller('FriendsListController', ['$scope', 'UserService',
  function($scope, UserService) {
    var self = $scope;

    var getFriendsList = function() {
      return UserService
        .getFriendslist()
        .then(function(users) {
          self.users = users.data;
        });
    };

    var construct = function() {
      getFriendsList();
    };

    construct();
  }
]);
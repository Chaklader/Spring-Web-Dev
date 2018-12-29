angular.module('org.privatechat', [
    'ngRoute',
    'angular.filter',
    'org.privatechat.login.LoginController',
    'org.privatechat.registration.RegistrationController',
    'org.privatechat.friendslist.FriendsListController',
    'org.privatechat.chat.ChatController',
    'org.privatechat.user.AuthService',
    'org.privatechat.shared.websocket.WebSocket',
  ])
  .run(['$rootScope', '$location', 'AuthService', 'WebSocket',
    function($rootScope, $location, AuthService, WebSocket) {
      $rootScope.$on('$routeChangeStart', function(event, next, current) {
        if (next.$$route && next.$$route.auth) {
          if ( !AuthService.hasActiveSession()) {
            $location.path('/login');            
          } else {
            if (!WebSocket.isConnected()) {
            WebSocket.connect();
          }            
        }
      }
    });
  }])
  .factory('authHttpResponseInterceptor',['$q', '$location',
    function($q, $location){
    
    var routeToLogin = function() { $location.path('/login'); };

    return {
      response: function(response){
        if (response.status === 401) { routeToLogin(); }

        return response || $q.when(response);
      },
      responseError: function(rejection) {
        if (rejection.status === 401) { routeToLogin(); }

        return $q.reject(rejection);
      }
    };
  }])
  .config(['$routeProvider', '$httpProvider',
    function($routeProvider, $httpProvider) {
      $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
      $httpProvider.defaults.withCredentials = true;

      // http://stackoverflow.com/a/19771501/1525534 - disable IE ajax request caching
      if (!$httpProvider.defaults.headers.get) { $httpProvider.defaults.headers.get = {}; }
      $httpProvider.defaults.headers.get['If-Modified-Since'] = 'Mon, 26 Jul 1997 05:00:00 GMT';
      $httpProvider.defaults.headers.get['Cache-Control'] = 'no-cache';
      $httpProvider.defaults.headers.get['Pragma'] = 'no-cache';

      $httpProvider.interceptors.push('authHttpResponseInterceptor');

      $routeProvider
        .when('/login', {
          controller: 'LoginController',
          templateUrl: 'login/LoginView.html'
        })
        .when('/register', {
          controller: 'RegistrationController',
          templateUrl: 'registration/RegistrationView.html'
        })
        .when('/friendslist', {
          controller: 'FriendsListController',
          templateUrl: 'friendslist/FriendsListView.html',
          auth: true,
        })
        .when('/private-chat/:id', {
          controller: 'ChatController',
          templateUrl: 'chat/ChatView.html',
          auth: true,
        })
        .otherwise({
          redirectTo: '/login'
        });
  }]);
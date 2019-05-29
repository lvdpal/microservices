'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'ngSanitize',
  'myApp.game',
  'myApp.view2',
  'myApp.version'
]).
config(['$locationProvider', '$routeProvider', '$httpProvider', function($locationProvider, $routeProvider, $httpProvider) {
  $locationProvider.hashPrefix('!');

  $routeProvider.otherwise({redirectTo: '/game'});

  //$httpProvider.defaults.headers.post = {};
  //$httpProvider.defaults.useXDomain = true;
  
}]).
filter('to_trusted', ['$sce', function($sce){
        return function(text) {
            return $sce.trustAsHtml(text);
        };
    }]);

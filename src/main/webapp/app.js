/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var myApp = angular.module('myApp', 'ngResource' , 'ngRoute');
myApp.config(function($routeProvider, $locationProvider){
    $routeProvider.
      when('/contactus', {
        templateUrl: 'partials/contactus.html',
        controller: 'myAppController'
      });
  });
myApp.controller('myAppController', ['$scope', '$http',
  function ($scope, $http) {
  }]);
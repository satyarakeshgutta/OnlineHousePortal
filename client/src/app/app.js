(function() {
  'use strict';

  angular.module("Tracker", ["ngRoute"]);

  angular.module("Tracker")
        .config(moduleConfig);

  moduleConfig.$inject = ['$routeProvider'];

  function moduleConfig($routeProvider) {

      $routeProvider
          .when('/users', {
              templateUrl: 'app/views/users.tmpl.html',
              controller: 'UsersController',
              controllerAs: 'usersVm'
          })
          .when('/users/:pId', {
              templateUrl: 'app/views/user-detail.tmpl.html',
              controller: 'UserDetailController',
              controllerAs: 'userDetailVm'
          })
          .when('/listings', {
              templateUrl: 'app/views/listings.tmpl.html',
              controller: 'ListingsController',
              controllerAs: 'listingsVm'
          })

          .when('/listings/:vin', {
              templateUrl: 'app/views/listing-detail.tmpl.html',
              controller: 'ListingDetailController',
              controllerAs: 'listingDetailVm'
          })
          .when('/alerts', {
              templateUrl: 'app/views/alerts.tmpl.html',
              controller: 'AlertsController',
              controllerAs: 'alertsVm'
          })
          .when('/alerts/:pid', {
              templateUrl: 'app/views/alert-detail.tmpl.html',
              controller: 'AlertDetailController',
              controllerAs: 'alertDetailVm'
          })
          .otherwise({
              redirectTo: ''
          });
      };
})();
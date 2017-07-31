(function() {
  'use strict';

  angular.module('Tracker')
    .controller('UserDetailController', UserDetailController);

    UserDetailController.$inject = ['userService','$routeParams','listingService','alertService'];

  function UserDetailController(userService,$routeParams,listingService,alertService) {
    var userDetailVm = this;

    init();

      function init() {
          console.log('UserDetailController');
          userService
              .getUserById($routeParams.pId)
              .then(function (user){
                  userDetailVm.user = user;
               },function (error) {
                  console.log(error);
              });
          }
      }
})();
(function() {
  'use strict';

  angular.module("Tracker")
    .controller('ListingsController', ListingsController);

    ListingsController.$inject = ['listingService'];

  function ListingsController(listingService) {
    var listingsVm = this;

      listingService.getListings().then(function (response) {
          listingsVm.listings = response;
          console.log(response);
      },function (error) {
          console.log(error);
      });


      listingsVm.changeSort = changeSort;

      init();

      function init() {
          console.log('ListingsController');

          listingsVm.sorter = {
              by: 'pId',
              reverse: false
          };

          listingService
              .getListings()
              .then(function(listings) {
                  listingsVm.listings = listings;
              }, function(error) {
                  console.log(error);
              });
      }

      function changeSort(prop) {
          listingsVm.sorter.by = prop;
          listingsVm.sorter.reverse = !listingsVm.sorter.reverse;
      }
  }
})();
(function() {
    'use strict';

    angular.module('Tracker')
        .controller('ListingDetailController', ListingDetailController);

    ListingDetailController.$inject = ['listingService','$routeParams'];

    function ListingDetailController(listingService,$routeParams) {
        var listingDetailVm = this;

        init();

        function init() {
            console.log('ListingDetailController');

            listingService
                .getListingsById($routeParams.vin)
                .then(function (listings){
                    listingDetailVm.listings = listings;
                }, function (error) {
                    console.log(error);
                });
        }
    }
})();
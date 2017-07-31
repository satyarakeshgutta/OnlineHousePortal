(function() {
  'use strict';

  angular.module("Tracker")
    .service('listingService', listingService);

    listingService.$inject = ['$http', '$q', 'CONFIG'];

    function listingService($http, $q,CONFIG) {
        var self = this;
        self.getListings = getListings;
        self.getListingsById = getListingsById;

        function getListings() {
            return $http.get(CONFIG.API_HOST +'/listings')
                .then(successFn,errorFn);
        };

        function getListingsById(vin) {
            return $http.get(CONFIG.API_HOST + '/listings/' + vin)
                .then(successFn,errorFn);
        };

        function successFn(response) {
            return response.data;
        }

        function errorFn(response) {
            return $q.reject('ERROR: ' + response.statusText);
        }
    }
})();
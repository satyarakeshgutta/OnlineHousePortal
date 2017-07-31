(function() {
    'use strict';

    angular.module("Tracker")
        .service('alertService', alertService);

    alertService.$inject = ['$http', '$q', 'CONFIG'];

    function alertService($http, $q,CONFIG) {
        var self = this;

        self.getAlerts = getAlerts;
        self.getAlertsById = getAlertsById;

        function getAlerts() {
            return $http.get(CONFIG.API_HOST +'/alerts')
                .then(successFn,errorFn);
        };

        function getAlertsById(pId) {
            return $http.get(CONFIG.API_HOST + '/alerts/' + pId)
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
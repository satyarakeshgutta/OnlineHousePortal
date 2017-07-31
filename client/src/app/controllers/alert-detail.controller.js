(function() {
    'use strict';

    angular.module('Tracker')
        .controller('AlertDetailController', AlertDetailController);

    AlertDetailController.$inject = ['alertService','$routeParams'];

    function AlertDetailController(alertService,$routeParams) {
        var alertDetailVm = this;

        init();

        function init() {
            console.log('AlertDetailController');

            alertService
                .getAlertsById($routeParams.vin)
                .then(function (alerts){
                    alertDetailVm.alerts = alerts;
                }, function (error) {
                    console.log(error);
                });
        }
    }
})();
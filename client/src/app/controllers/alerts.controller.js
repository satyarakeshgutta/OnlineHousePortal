(function() {
    'use strict';

    angular.module("Tracker")
        .controller('AlertsController', AlertsController);

    AlertsController.$inject = ['alertService'];

    function AlertsController(alertService) {
        var alertsVm = this;

        alertService.getAlerts().then(function (response) {
            alertsVm.alerts = response;
            console.log(response);
        },function (error) {
            console.log(error);
        });

        alertsVm.changeSort = changeSort;

        init();

        function init() {
         console.log('AlertsController');

         alertsVm.sorter = {
         by: 'personId',
         reverse: false
         };

         alertService
         .getAlerts()
         .then(function(alerts) {
             alertsVm.alerts = alerts;
         }, function(error) {
         console.log(error);
         });
         }

         function changeSort(prop) {
             alertsVm.sorter.by = prop;
             alertsVm.sorter.reverse = !alertsVm.sorter.reverse;
         }
    }
})();
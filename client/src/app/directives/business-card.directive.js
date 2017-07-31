(function () {
  'use strict';

  angular
    .module('Tracker')
    .directive('businessCard', businessCard);

  function businessCard () {
    var directive = {
      replace: true,
      scope: {
        user: '=',
        logFn: '&'
      },
      transclude: true,
      templateUrl: 'business-card.tmpl.html',
      link: function (scope, elem, attrs) {
        elem.on('click', function () {
          scope.logFn();
        });
      }
    };

    return directive;
  }

})();


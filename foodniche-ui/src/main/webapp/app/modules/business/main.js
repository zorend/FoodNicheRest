angular.module('fnApp').config(['$stateProvider',function($stateProvider) {
  $stateProvider
    .state('business',{
      url: '/business',
      template: '<ui-view></ui-view>'
    })
    .state('business.view',{
      url: '/',
      templateUrl: 'app/modules/business/views/business.html',
      controller: 'BusinessViewCtrl',
      authenticate: true,
      isBusiness: true
    })
    .state('business.edit',{
      url: '/edit',
      templateUrl: 'app/modules/business/views/business-edit.html',
      controller: 'BusinessEditCtrl',
      authenticate: true,
      isBusiness: true
    })
    .state('business.connection',{
      url: '/my-connection',
      templateUrl: 'app/modules/business/views/business-connection.html',
      controller: 'BusinessConnectionCtrl',
      authenticate: true,
      isBusiness: true,
      resolve: {
        connections: [
          'User',
          function(User) {
            return User.getMyConnection();
          }
        ]
      }
    })
    .state('business.album',{
      url: '/my-album',
      templateUrl: 'app/modules/business/views/business-album.html',
      controller: 'BusinessAlbumCtrl',
      authenticate: true,
      isBusiness: true,
      resolve: {
        albums: [
          'User',
          function(User) {
            return User.getMyAlbum();
          }
        ]
      }
    })
}]);
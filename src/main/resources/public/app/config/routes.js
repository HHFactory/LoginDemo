/**
 * ui.router設定ファイル
 * 
 * @return
 */
(function(){
	'use strict';

	angular.module(demoApp)
	.config(["$stateProvider","$urlRouterProvider","$httpProvider",function($stateProvider,$urlRouterProvider,$httpProvider){
		$stateProvider
		.state('login',{
			url:"/",
			templateUrl: "app/views/loginform.html",
			controller: "LoginController",
			controllerAs: "LoginCtrl"
		})
		.state('home',{
			url:"/home",
			templateUrl: "app/views/home.html",
			controller: "HomeController",
			controllerAs: "HomeCtrl"
		})
		.state('admin',{
			url: "/admin",
			templateUrl:"app/views/admin.html",
			controller:"AdminController",
			controllerAs:"AdminCtrl"
		});
		
		$urlRouterProvider.otherwise('/');
		$httpProvider.defaults.headers.common["X-Requested-With"] = "XMLHttpRequest";
	}]);

})();


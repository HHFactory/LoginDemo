/**
 * ホーム画面コントローラ
 * 
 * @return 
 */
(function(){
	'use strict';

	function HomeCtrl($http,$state,$localStorage,LoginUserService){
		var self = this;

		/** ログインユーザ名をlocalStorageから取得*/
		self.userName = $localStorage.userinfo.userName;

		/**
		 * 権限チェック(ボタン表示制御用)
		 * @param  {[type]}  targetPermission 
		 * @return {Boolean}                  
		 */
		self.hasPermission = function(targetPermission){
			return LoginUserService.hasPermission(targetPermission);
		}

		/**
		 * ログアウトボタン押下処理
		 * @return 
		 */
		self.logout = function(){
			$http.get("/demo/api/logout")
				.finally(function(){
					$localStorage.$reset(); //localStorageを全て削除
					$state.go('login');
				});
		}

		/**
		 * 管理者ページボタン押下処理
		 * @return 
		 */
		self.goAdminPage = function(){
			$state.go('admin');
		}

		/**
		 * ホームへ戻るボタン押下処理
		 * @return 
		 */
		self.goHome = function(){
			$state.go('home');
		}
	}
	
	angular.module(demoApp).controller('HomeController',['$http','$state','$localStorage','LoginUserService',HomeCtrl]);
})();
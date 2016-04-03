/**
 * 管理者ページ用コントローラ
 * 
 * @return 
 */
(function(){
	'use strict';

	function AdminCtrl($http,$state,LoginUserService){
	var self = this;

		/**
		 * 権限チェック(ボタン表示制御用)
		 * @param  {[type]}  targetPermission 
		 * @return {Boolean}                  
		 */
		self.hasPermission = function(targetPermission){
			return LoginUserService.hasPermission(targetPermission);
		}

		/**
		 * ユーザリスト取得処理
		 * (サーバー側で認可設定)
		 */
		$http.get('/demo/api/v1/users')
				.success(function(apiResult){
					console.log(apiResult);
					self.userList = apiResult;
				})
				.error(function(apiResult){
					console.log(apiResult);
				});

		/**
		 * ホームへ戻るリンク押下処理
		 * @return {[type]} [description]
		 */
		self.goHome = function(){
			$state.go('home');
		}

	}

	angular.module(demoApp).controller('AdminController',['$http','$state','LoginUserService',AdminCtrl]);
})();
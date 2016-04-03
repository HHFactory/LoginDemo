/**
 * ログイン画面コントローラ
 * 
 * @return
 */
(function(){
	'use strict';

	function LoginCtrl($scope,$http,$state,$localStorage){
		var self = this;

		// ログイン画面呼び出し時に既にログイン状態の場合ホーム画面に遷移
		// ログイン後、localstorageを破棄せずにブラウザを閉じた場合の対応として
		if($localStorage.userinfo){
			$state.go('home');
		}

		/**
		 * ログインボタン押下処理
		 * @param  {[object]} credentials 
		 * @return              
		 */
		self.login = function(credentials){
			$http.post("/demo/api/login",credentials)
				/** 認証成功時 */
				.success(function(apiResult){
					$localStorage.userinfo = apiResult; //localStorageにログイン情報を格納
					$state.go('home');　//home画面に遷移
				})
				/** 認証失敗時 */
				.error(function(apiResult) {
					self.error = true;　//エラー表示フラグ:true
				});
		}

	}

	angular.module(demoApp).controller('LoginController',['$scope','$http','$state','$localStorage',LoginCtrl]);
})();
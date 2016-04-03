/**
 * 画面遷移時の認可チェックを行う
 * 
 * @return 
 */
(function(){
	'use strict';

	function run($rootScope,$state,$localStorage,LoginUserService){
		$rootScope.$on('$stateChangeStart',function(e,toState,toParams,fromState,fromParams){

			// 管理者ページに遷移する場合
			if(toState.name == 'admin'){
				// admin権限がない場合は遷移させない
				if(!LoginUserService.hasPermission('manageUser')){
					e.preventDefault();
					alert('権限がありません');
				}
			}

			// ログインページに遷移する場合（ブラウザバック時の対応として）
			if(toState.name == 'login'){
				// ログイン状態の場合は、ログイン画面まで遷移させない
				if($localStorage.userinfo){
					$state.go('home'); //ホーム画面に遷移
				}
			}

			// ホーム画面に遷移する場合（未ログイン時にホーム画面へのURLを直接入力された場合の対応として）
			if(toState.name == 'home'){
				if(!$localStorage.userinfo){
					e.preventDefault();
					alert('再度ログインしてください');
				}
			}

		});
	}

	angular.module(demoApp).run(['$rootScope','$state','$localStorage','LoginUserService',run]);
})();
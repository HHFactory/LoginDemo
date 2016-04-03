/**
 * ログインユーザ情報に関するサービス
 * 
 * @return
 */
(function(){
	'use strict';

	function LoginUserService($localStorage){

		var loginUserService = {
			/**
			 * 指定された権限を持っているかチェック
			 * @param  {[type]}  targetPermission
			 * @return {Boolean}                 
			 */
			hasPermission: function(targetPermission){
				for(var i=0; i<$localStorage.userinfo.permissions.length; i++){
					if($localStorage.userinfo.permissions[i] === targetPermission){
						return true;
					}
				}
				return false;
			}
		}
		
		return loginUserService;
	}

	angular.module(demoApp).factory('LoginUserService',['$localStorage',LoginUserService]);
})();
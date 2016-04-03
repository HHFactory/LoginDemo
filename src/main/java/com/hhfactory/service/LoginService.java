package com.hhfactory.service;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.hhfactory.dto.AuthResult;
import com.hhfactory.dto.LoginInfoDTO;
import com.hhfactory.dto.LoginUserDetails;

@Service
public class LoginService {

	@Autowired
	private AuthenticationManager authManager;
	/** logger */
	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

	/**
	 * 認証処理
	 * @param loginInfo
	 * @return
	 */
	public AuthResult login(LoginInfoDTO loginInfo){
		Authentication authentication = null;
		AuthResult authResult = new AuthResult();
		try {
			//メールアドレスとパスワードによる照合を実施
			Authentication request = new UsernamePasswordAuthenticationToken(loginInfo.getMailaddress(), loginInfo.getPassword());
			authentication = authManager.authenticate(request);
			//認証OKの場合は、認証結果をcontextholderに設定
			SecurityContextHolder.getContext().setAuthentication(authentication);
			//現在ログインユーザ情報を格納
			LoginUserDetails principal = (LoginUserDetails)authentication.getPrincipal();
			//クライアントへの返却データを設定
			authResult.setUserName(principal.getUsername());
			authResult.setPermissions(principal.getPermissions());
			authResult.setRoles(principal.getAuthorities().stream().map(authority -> authority.getAuthority()).collect(Collectors.toList()));
		}
		//認証失敗の場合
		catch (Exception e) {
			logger.error(e.toString());
		}
		return authResult;
	}
}

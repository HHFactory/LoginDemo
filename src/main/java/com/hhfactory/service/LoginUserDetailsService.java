package com.hhfactory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hhfactory.dto.LoginUserDetails;
import com.hhfactory.entity.User;
import com.hhfactory.repository.UserRepository;

/**
 * 認証ユーザ取得サービスクラス
 *
 */
@Service
public class LoginUserDetailsService implements UserDetailsService{
	@Autowired
	UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String mailaddress) throws UsernameNotFoundException{
		//DBに登録されているメールアドレスから認証対象ユーザを取得
		User user = repository.findOne(mailaddress);
		if(user == null){
			//TODO:このexceptionをそのままcatchしたい
			throw new UsernameNotFoundException("対象データがありません");
		}
		//取得したUserエンティティをもとにLoginUserDetailsを作成する
		return new LoginUserDetails(user);
	}
}

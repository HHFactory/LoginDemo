package com.hhfactory.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.hhfactory.entity.User;

import lombok.Data;

/**
 * 認証ユーザ作成クラス
 *
 */
@Data
public class LoginUserDetails extends org.springframework.security.core.userdetails.User{
	private static final long serialVersionUID = 1L;
	
	/** 認証ユーザ名*/
	private String name;
	/** パスワード*/
	private String password;
	/** 権限リスト*/
	private List<String> permissions;
	/** ロールリスト*/
	private Collection<GrantedAuthority> authorities;
	
	/**
	 * コンストラクタ
	 * @param user
	 */
	public LoginUserDetails(User user){
		//Userエンティティから、認証ユーザのユーザ名、パスワード、権限リスト、ロールリストを設定
		super(user.getName(), user.getEncodedPassword(), new ArrayList<GrantedAuthority>());
		name = user.getName();
		password = user.getEncodedPassword();
		//User -> list<Role> -> list<Permission> -> list<String>
		permissions = user.getRoles()
						  .stream()
						  .flatMap(role -> role.getPermissions().stream()
																.map(permission -> permission.getName()))
						  .collect(Collectors.toList());
		//User -> list<Role> -> list<GrantedAuthority>
		authorities = user.getRoles()
						.stream()
						.map(role -> new SimpleGrantedAuthority(role.getName()))
						.collect(Collectors.toList());
	}

}

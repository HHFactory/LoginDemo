package com.hhfactory.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * クライアントに返却する認証結果クラス
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResult {
	/** ユーザ名*/
	private String userName;
	/** 権限リスト*/
	private List<String> permissions;
	/** ロール名*/
	private List<String> roles;
}

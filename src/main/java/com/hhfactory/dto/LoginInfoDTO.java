package com.hhfactory.dto;

import lombok.Data;

/**
 * クライアントから渡されるログイン情報
 *
 */
@Data
public class LoginInfoDTO {
	private String mailaddress;
	private String password;
}

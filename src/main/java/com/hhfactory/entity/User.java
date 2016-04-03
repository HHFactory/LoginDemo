package com.hhfactory.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** メールアドレス（認証時使用）*/
	@Id
	@Column(nullable=false,columnDefinition="VARCHAR(255)")
	private String mailaddress;
	
	/** パスワード（認証時使用。DBにはハッシュ化して格納）*/
	@JsonIgnore
	@Column(nullable=false,columnDefinition="VARCHAR(255)")
	private String encodedPassword;
	
	/** クライアント表示ユーザ名*/
	@Column(nullable=false,columnDefinition="VARCHAR(50)")
	private String name;
	
	/** 保有するロールリスト*/
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="user_has_role",			
			joinColumns=@JoinColumn(name="user_name",referencedColumnName="name"),
			inverseJoinColumns=@JoinColumn(name="role_id",referencedColumnName="id")
			)
	private List<Role> roles;
	
}

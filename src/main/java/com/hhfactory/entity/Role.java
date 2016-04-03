package com.hhfactory.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="role")
public class Role implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	
	/** システム内部で識別するロール名*/
	@Column(nullable=false)
	private String name;

	/** クライアント側表示用ロール名*/
	@Column(nullable=false)
	private String alias;
	
	/** 保有する権限リスト*/
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="role_has_permission",
			joinColumns=@JoinColumn(name="role_name",referencedColumnName="name"),
			inverseJoinColumns=@JoinColumn(name="permission_id",referencedColumnName="id")
			)
	List<Permission> permissions;	
}

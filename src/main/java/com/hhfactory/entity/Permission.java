package com.hhfactory.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="permission")
public class Permission implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	
	/** システム内部で識別する権限名*/
	@Column(nullable=false)
	private String name;
	
	/** クライアント側表示用権限名*/
	@Column(nullable=false)
	private String alias;
}

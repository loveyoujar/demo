package com.ltq.demo.entity;

import java.util.*;
import com.ltq.demo.core.EntrtyBase;

/**
 * 实体类
 * @author admin
 * @since 2019年9月22日
 * 用户信息
 */
public class User extends EntrtyBase {
	


	//@ApiModelProperty(value = "ID")
	private Integer id;

	//@ApiModelProperty(value = "用户名")
	private String name;

	//@ApiModelProperty(value = "密码")
	private String password;

	//@ApiModelProperty(value = "")
	private Date createdTime;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
}
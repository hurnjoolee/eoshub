package io.eoshub.model;

import io.eoshub.type.LoginType;

public class Member {

	private Integer id;
	private LoginType loginType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LoginType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginType loginType) {
		this.loginType = loginType;
	}

}

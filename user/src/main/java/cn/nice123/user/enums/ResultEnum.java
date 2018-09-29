package cn.nice123.user.enums;

import lombok.Getter;

/**
 * Created by 廖师兄 2017-12-10 23:00
 */
@Getter
public enum ResultEnum {

	LOGIN_FAIL(1, "登录失败"),

	ROLE_ERROR(2, "角色权限有误");

	private Integer code;

	private String message;

	ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}

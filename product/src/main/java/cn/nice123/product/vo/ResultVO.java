package cn.nice123.product.vo;

import lombok.Data;

@Data
public class ResultVO<T> {

	/**
	 * 状态码
	 */
	private Integer code;
	
	/**
	 * 状态描述
	 */
	private String msg;
	
	/**
	 * 返回数据
	 */
	private T data;
}

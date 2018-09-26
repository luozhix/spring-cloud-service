package cn.nice123.product.server.exception;

import cn.nice123.product.server.enums.ResultEnum;

/**
 * Created by 廖师兄 2017-12-10 22:59
 */
public class ProductException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6257102118585012445L;
	@SuppressWarnings("unused")
	private Integer code;

	public ProductException(Integer code, String message) {
		super(message);
		this.code = code;
	}

	public ProductException(ResultEnum resultEnum) {
		super(resultEnum.getMessage());
		this.code = resultEnum.getCode();
	}
}

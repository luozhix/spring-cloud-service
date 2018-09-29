package cn.nice123.user.vo;

import cn.nice123.user.enums.ResultEnum;
import lombok.Data;

/**
 * http请求返回的最外层对象 Created by 廖师兄 2017-12-09 22:09
 */
@Data
public class ResultVO<T> {

	/**
	 * 错误码
	 */
	private Integer code;

	/**
	 * 提示信息
	 */
	private String msg;

	/**
	 * 具体内容
	 */
	private T data;

	public static ResultVO success(Object object) {
		ResultVO resultVO = new ResultVO();
		resultVO.setData(object);
		resultVO.setCode(0);
		resultVO.setMsg("成功");
		return resultVO;
	}

	public static ResultVO success() {
		return success(null);
	}

	public static ResultVO error(ResultEnum resultEnum) {
		ResultVO resultVO = new ResultVO();
		resultVO.setData(null);
		resultVO.setCode(resultEnum.getCode());
		resultVO.setMsg(resultEnum.getMessage());
		return resultVO;
	}
}

package cn.nice123.product.util;

import cn.nice123.product.vo.ResultVO;

public class ResultVOUtil {
	
	public static ResultVO success(Object obj) {
		ResultVO resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setMsg("success");
		resultVO.setData(obj);
		return resultVO;
	}
	
	public static ResultVO success() {
		return success(null);
	}
	
	public static ResultVO error(Integer code,String msg) {
		ResultVO resultVO = new ResultVO<>();
		resultVO.setCode(code);
		resultVO.setMsg(msg);
		resultVO.setData(null);
		return resultVO;
	}
}

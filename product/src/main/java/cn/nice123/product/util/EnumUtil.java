package cn.nice123.product.util;

import cn.nice123.product.enums.CodeEnum;

public class EnumUtil {

	//定义泛型为CodeEnum<Integer>的子类
	public static <T extends CodeEnum<Integer>> T getByCode(Integer code,Class<T> enumClass) {
		/*
		 * values()方法是编译器插入到enum定义中的static方法，
		 * 所以，当你将enum实例向上转型为父类Enum是，values()就不可访问了。
		 * 解决办法：在Class中有一个getEnumConstants()方法，
		 * 所以即便Enum接口中没有values()方法，我们仍然可以通过Class对象取得所有的enum实例
		 */
		for(T data:enumClass.getEnumConstants()) {
			if(code.equals(data.getCode())) {
				return data;
			}
		}
		return null;
	}
}

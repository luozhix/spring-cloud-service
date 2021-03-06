package cn.nice123.order.server.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	private static ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * 转换为json字符串
	 * 
	 * @param object
	 * @return
	 */
	public static String toJson(Object object) {
		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * json转换为对象
	 * @param string
	 * @param classType
	 * @return
	 */
	public static Object fromJson(String string, Class classType) {
		try {
			return objectMapper.readValue(string, classType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * json转换为对面，用于转化为集合对象，带泛型的
	 * @param string
	 * @param typeReference
	 * @return
	 */
	public static Object fromJson(String string, TypeReference typeReference) {
		try {
			return objectMapper.readValue(string, typeReference);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
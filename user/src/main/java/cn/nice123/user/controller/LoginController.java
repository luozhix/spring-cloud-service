package cn.nice123.user.controller;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.nice123.user.constant.CookieConstant;
import cn.nice123.user.constant.TokenConstant;
import cn.nice123.user.dataobject.UserInfo;
import cn.nice123.user.enums.ResultEnum;
import cn.nice123.user.enums.RoleEnum;
import cn.nice123.user.service.UserService;
import cn.nice123.user.util.CookieUtil;
import cn.nice123.user.vo.ResultVO;

@RestController
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	/**
	 * 买家登录
	 * 
	 * @param openid
	 * @param response
	 * @return
	 */
	@GetMapping("/buyer")
	public ResultVO buyer(@RequestParam("openid") String openid, HttpServletResponse response) {
		UserInfo userInfo = userService.findByOpenid(openid);
		if (userInfo == null) {
			return ResultVO.error(ResultEnum.LOGIN_FAIL);
		}
		if (userInfo.getRole() != RoleEnum.BUYER.getCode()) {
			return ResultVO.error(ResultEnum.ROLE_ERROR);
		}
		//cookie中openid = abc
		CookieUtil.set(response, CookieConstant.OPENID, openid, CookieConstant.EXPIRE);
		return ResultVO.success(userInfo);
	}

	/**
	 * 卖家登录
	 * 
	 * @param openid
	 * @param response
	 * @param request
	 * @return
	 */
	@GetMapping("/seller")
	public ResultVO seller(@RequestParam("openid") String openid, HttpServletResponse response,
			HttpServletRequest request) {
		Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
		/*
		 * 判断cookie是否有信息，如果有信息直接返回成功信息
		 */
		if (cookie != null && !StringUtils.isEmpty(stringRedisTemplate.opsForValue()
				.get(String.format(TokenConstant.TOKEN_TEMPLATE, cookie.getValue())))) {
			return ResultVO.success();
		}
		UserInfo userInfo = userService.findByOpenid(openid);
		if (userInfo == null) {
			return ResultVO.error(ResultEnum.LOGIN_FAIL);
		}
		if (userInfo.getRole() != RoleEnum.SELLER.getCode()) {
			return ResultVO.error(ResultEnum.ROLE_ERROR);
		}
		String token = UUID.randomUUID().toString();
		/*
		 * 将用户信息储存到redis中,token_uuid = xyz
		 */
		stringRedisTemplate.opsForValue().set(String.format(TokenConstant.TOKEN_TEMPLATE, token), openid,
				CookieConstant.EXPIRE, TimeUnit.SECONDS);
		//cookie存储 token = uuid
		CookieUtil.set(response, CookieConstant.TOKEN, token, CookieConstant.EXPIRE);
		return ResultVO.success(userInfo);
	}
}

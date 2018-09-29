/*package cn.nice123.apigateway.filter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import cn.nice123.apigateway.constant.TokenConstant;
import cn.nice123.apigateway.util.CookieUtil;

*//**
 * 权限拦截，分买家和卖家
 * 
 * @author xiang
 *
 *//*
@Component
public class AuthFilter extends ZuulFilter {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	*//**
	 * 是否过滤
	 *//*
	@Override
	public boolean shouldFilter() {
		return true;
	}

	*//**
	 * 判断用户是否带有token
	 *//*
	@Override
	public Object run() throws ZuulException {
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		if ("/order/order/create".equals(request.getRequestURI())) {
			Cookie cookie = CookieUtil.get(request, "openid");
			if (cookie == null || StringUtils.isEmpty(cookie.getValue())) {
				requestContext.setSendZuulResponse(false);
				requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
			}
		}
		if ("/order/order/finish".equals(request.getRequestURI())) {
			Cookie cookie = CookieUtil.get(request, "token");
			if (cookie == null || StringUtils.isEmpty(cookie.getValue()) || StringUtils.isEmpty(stringRedisTemplate
					.opsForValue().get(String.format(TokenConstant.TOKEN_TEMPLATE, cookie.getValue())))) {
				requestContext.setSendZuulResponse(false);
				requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
			}
		}
		return null;
	}

	*//**
	 * 过滤器类型
	 *//*
	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	*//**
	 * 过滤器顺序
	 *//*
	@Override
	public int filterOrder() {
		// 越小优先级越高
		return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
	}

}
*/
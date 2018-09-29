package cn.nice123.apigateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class TokenFilter extends ZuulFilter{

	/**
	 * 是否过滤
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 判断用户是否带有token
	 */
	@Override
	public Object run() throws ZuulException {
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		String token = request.getParameter("token");
		if(StringUtils.isEmpty(token)) {
			/*requestContext.setSendZuulResponse(false);
			requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());*/
		}
		return null;
	}
	/**
	 * 过滤器类型
	 */
	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	/**
	 * 过滤器顺序
	 */
	@Override
	public int filterOrder() {
		//越小优先级越高
		return FilterConstants.PRE_DECORATION_FILTER_ORDER-1;
	}

}

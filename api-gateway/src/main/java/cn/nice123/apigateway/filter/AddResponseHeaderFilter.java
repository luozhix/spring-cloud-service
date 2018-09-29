package cn.nice123.apigateway.filter;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class AddResponseHeaderFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 向相应消息头中加入X-FOO内容
	 */
	@Override
	public Object run() throws ZuulException {
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletResponse response = requestContext.getResponse();
		response.setHeader("X-FOO", UUID.randomUUID().toString());
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.POST_TYPE;
	}

	@Override
	public int filterOrder() {
		return FilterConstants.SEND_RESPONSE_FILTER_ORDER-1;
	}

}

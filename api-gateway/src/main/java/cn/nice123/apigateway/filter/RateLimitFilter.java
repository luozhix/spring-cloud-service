package cn.nice123.apigateway.filter;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

import cn.nice123.apigateway.exception.RateLimitException;

/**
 * 限流
 * @author xiang
 *
 */
@Component
public class RateLimitFilter extends ZuulFilter {

	private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		if(!RATE_LIMITER.tryAcquire()) {
			throw new RateLimitException();
		}
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return FilterConstants.SERVLET_DETECTION_FILTER_ORDER - 1;
	}

}

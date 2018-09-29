package cn.nice123.order.server.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

	// 设置超时
//	@HystrixCommand(commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000"))
	// (fallbackMethod = "fallback")
	@HystrixCommand(commandProperties = { @HystrixProperty(name = "execution.timeout.enabled", value = "true"), // 设置熔断
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 滚动时间窗口中断路器的最小请求数
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 休眠时间窗时间
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") }) // 熔断器打开的失败百分比*/
	//@HystrixCommand
	@GetMapping("/getProductInfoList")
	public String getProductInfoList(@RequestParam("number") Integer number) {
		if (number % 2 == 0)
			return "successs";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.postForObject("http://localhost:8081/product/listForOrder",
				Arrays.asList("123121"), String.class);
		return result;
		// throw new RuntimeException("发生异常了");
	}

	public String fallback() {
		return "网络繁忙，请稍后再试";
	}

	// 默认降级回调方法
	public String defaultFallback() {
		return "默认提示：网络繁忙，请稍后再试";
	}
}

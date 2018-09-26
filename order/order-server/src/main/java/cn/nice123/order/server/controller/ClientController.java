package cn.nice123.order.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/order")
@Slf4j
public class ClientController {

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	//@Autowired
	//private RestTemplate restTemplate;

	@GetMapping("/getProductMsg")
	public String getProductMsg() {
		// 第一种方式(直接使用RestTemplate，url写死)
		/*
		 * RestTemplate restTemplate = new RestTemplate(); String response =
		 * restTemplate.getForObject("http://localhost:8080/product/msg", String.class);
		 * log.info("response={}",response);
		 */

		// 第二种方式(利用LoadBalancerClient通过应用名获得url,然后再使用)
		ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
		String url = serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/product/msg";
		log.info("url={}", url);
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject("http://" + url, String.class);
		log.info("response={}", response);
		return "hh" + response;
		// 第三种方式(利用注解@LoadBalanced，可在restTemplate里使用应用名)
		/*
		 * String response = restTemplate.getForObject("http://PRODUCT/product/msg",
		 * String.class); log.info("response={}",response);
		 */
		// return response;
	}
}
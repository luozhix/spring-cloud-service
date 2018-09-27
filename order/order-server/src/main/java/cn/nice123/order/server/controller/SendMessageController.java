package cn.nice123.order.server.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.nice123.order.server.dto.OrderDTO;
import cn.nice123.order.server.message.StreamClient;

@RestController
public class SendMessageController {

	@Autowired
	private StreamClient streamClient;

	/*
	 * 发送orderDTO对象
	 */
	@GetMapping("/sendMessage")
	public void process() {
		String message = "now " + new Date();
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setOrderId("12312");
		streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
	}

}

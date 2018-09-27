package cn.nice123.order.server.message;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import cn.nice123.order.server.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;

@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

	/**
	 * 接收orderDTO对象
	 * @param message
	 */
	@StreamListener(StreamClient.OUTPUT)
	public void processsOutput(OrderDTO message) {
		log.info("StreamReceiver = {}", message);
	}
/*
	@StreamListener(StreamClient.INPUT)
	@SendTo(StreamClient.OUTPUT)
	public Object processInput(Object message) {
		log.info("StreamReceiverInput = {}", new String((byte[]) message));
		return message;
	}*/
}

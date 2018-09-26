package cn.nice123.order.server.message;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 接收MQ消息
 * @author zhixiang luo
 * @date: 2018年8月31日 上午11:17:50
 */
@Slf4j
@Component
public class MqReceiver {

	/**
	 * 单queue，只有一种业务场景
	 * @param message
	 */
	@RabbitListener(queuesToDeclare = @Queue("singleQueues"))
	public void process (String message) {
		log.info("singleReceiver = {}" , message);
	}
	
	/**
	 * 绑定exchange
	 * @param message
	 */
	@RabbitListener(bindings = @QueueBinding(
			value = @Queue("manyQueues"),exchange = @Exchange("myExchange")) )
	public void process2 (String message) {
		log.info("manyReceiver = {}" , message);
	}
	
	/**
	 * 电脑业务
	 * @param message
	 */
	@RabbitListener(bindings = @QueueBinding(
			value = @Queue("computerOrder"),exchange = @Exchange("myOrder"),key = "computer") )
	public void processComputer (String message) {
		log.info("computer manyReceiver = {}" , message);
	}
	
	/**
	 * 水果业务
	 * @param message
	 */
	@RabbitListener(bindings = @QueueBinding(
			value = @Queue("fruitOrder"),exchange = @Exchange("myOrder"),key = "fruit") )
	public void processFruit (String message) {
		log.info("fruit manyReceiver = {}" , message);
	}
}

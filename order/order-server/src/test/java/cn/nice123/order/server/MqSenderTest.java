package cn.nice123.order.server;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 发送消息测试
 * 
 * @author zhixiang luo
 * @date: 2018年8月31日 上午11:21:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MqSenderTest {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Test
	public void senderSingleTest() {
		// convertAndSend(列名，消息)
		amqpTemplate.convertAndSend("nobindQueue", "now :" + new Date());
	}

	@Test
	public void senderTest() {
		// convertAndSend(列名，消息)
		amqpTemplate.convertAndSend("myQueue", "now :" + new Date());
	}

	@Test
	public void senderExchangeTest() {
		/**convertAndSend()参数说明
		 * exchange the name of the exchange 
		 * routingKey the routing key 
		 * message a message to send
		 */
		amqpTemplate.convertAndSend("myOrder", "computer", "now :" + new Date());
	}

}

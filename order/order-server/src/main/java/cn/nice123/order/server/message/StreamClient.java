package cn.nice123.order.server.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamClient {
	
	String INPUT = "myMessageInput";
	
	String OUTPUT = "myMessageOutput";

	@Input(INPUT)
	SubscribableChannel input();
	
	@Output(OUTPUT)
	MessageChannel output();
	
}

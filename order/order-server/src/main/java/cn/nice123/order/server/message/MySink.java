package cn.nice123.order.server.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MySink {
    String INPUT = "input";

    @Input(INPUT)
    SubscribableChannel input();
}
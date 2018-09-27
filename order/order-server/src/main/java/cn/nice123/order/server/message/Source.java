package cn.nice123.order.server.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Source {

    //String OUTPUT = "output"; // 之前所设置的消息发送的管道

    @Output(MySink.INPUT)
    MessageChannel output();

}
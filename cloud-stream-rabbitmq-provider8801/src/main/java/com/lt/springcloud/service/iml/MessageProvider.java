package com.lt.springcloud.service.iml;

import com.lt.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * @author lucine
 * @version 1.0 2021/1/3 13:49
 *
 * @EnableBinding(Source.class) 定义消息的推送管道
 */
@EnableBinding(Source.class)
public class MessageProvider implements IMessageProvider {

    @Autowired
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial : "+serial);
        return null;
    }
}

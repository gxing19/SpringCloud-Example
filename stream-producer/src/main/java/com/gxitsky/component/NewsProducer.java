package com.gxitsky.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

/**
 * @name: NBANewsProducer
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-22 15:24
 **/
@EnableBinding(Source.class)
public class NewsProducer {

    @Autowired(required = false)
    private Source source;

    @Resource
    private MessageChannel output;

    public void sendNBANews(String msg) {
//       this.output.send(MessageBuilder.withPayload(msg).build());
        this.source.output().send(MessageBuilder.withPayload(msg).build(), 1000 * 5);
    }

    public void sendMusicNews(String msg) {
        MessageBuilder<String> msgBuilder = MessageBuilder.withPayload(msg);
        //定义消息头
        msgBuilder.setHeader("news","music");
        this.source.output().send(msgBuilder.build(), 1000 * 5);
    }

    public void sendWarNews(String msg) {
        MessageBuilder<String> msgBuilder = MessageBuilder.withPayload(msg);
        msgBuilder.setHeader("news","war");
        this.source.output().send(msgBuilder.build(), 1000 * 5);
    }


}

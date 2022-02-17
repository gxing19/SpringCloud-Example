package com.gxitsky.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;


/**
 * @name: NBANewsConsumer
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-14 18:11
 **/

//绑定消息绑定
@EnableBinding(Sink.class)
public class NewsConsumer {

    private static Logger logger = LoggerFactory.getLogger(NewsConsumer.class);

    @StreamListener(Sink.INPUT)
    public void consumeNBANews(String msg){
//        logger.info("NBA News:" + msg);
        System.out.println("NBA News:" + msg);
    }

    /**
     * 根据消息头进行内容路由
     * @param msg
     */
    @StreamListener(value = Sink.INPUT, condition = "headers['news']=='music'")
    public void consumeMusicNews(@Payload String msg) {
        System.out.println("Music News:" + msg);
    }

}
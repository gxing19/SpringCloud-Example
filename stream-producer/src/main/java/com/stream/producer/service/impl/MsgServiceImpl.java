package com.stream.producer.service.impl;

import com.stream.producer.component.NewsProducer;
import com.stream.producer.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @name: MsgServiceImpl
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-22 15:21
 **/
@Service
public class MsgServiceImpl implements MsgService {

    @Autowired
    private NewsProducer newsProducer;

    @Override
    public void sendNBANews(String msg) {
        newsProducer.sendNBANews(msg);
    }

    @Override
    public void sendMusicNews(String msg) {
        newsProducer.sendMusicNews(msg);

    }
}
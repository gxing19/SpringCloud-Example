package com.stream.producer.controller;

import com.stream.producer.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @name: MsgController
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-22 15:19
 **/
@RestController
@RequestMapping("/news")
public class MsgController {

    @Autowired
    private MsgService msgService;

    @RequestMapping("/nba/{msg}")
    public void sendNBANews(@PathVariable String msg){

        msgService.sendNBANews(msg);

    }

    @RequestMapping("/music/{msg}")
    public void sendMusicNews(@PathVariable String msg){

        msgService.sendMusicNews(msg);

    }
}
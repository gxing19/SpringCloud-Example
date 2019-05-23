package com.stream.producer.component.binding;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @name: ShopMall
 * @desc: 自定义输出通道
 * @author: gxing
 * @date: 2019-05-23 15:43
 **/
public interface ShopMallOutput {

    @Output(value = "orderOut")
    MessageChannel newOrder();

    /*@Output(value = "paymentOut")
    MessageChannel payment();*/
}

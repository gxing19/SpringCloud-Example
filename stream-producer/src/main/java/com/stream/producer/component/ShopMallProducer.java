package com.stream.producer.component;

import com.stream.producer.component.binding.ShopMallOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;

/**
 * @name: ShopMallProducer
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-23 15:45
 **/
@EnableBinding(value = ShopMallOutput.class)
public class ShopMallProducer {

    @Autowired(required = false)
    private ShopMallOutput shopMallOutput;

    public void sendOrderInfo(String order){
        shopMallOutput.newOrder().send(MessageBuilder.withPayload(order).build());
    }

    public void sendPaymentInfo(String money){
        shopMallOutput.newOrder().send(MessageBuilder.withPayload(money).build());
    }
}
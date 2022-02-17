package com.gxitsky.component.binding;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @name: Shopmall
 * @desc: 自定义输入通道
 * @author: gxing
 * @date: 2019-05-23 16:08
 **/
public interface ShopMallInput {

    @Input(value = "orderIn")
    SubscribableChannel orderInfo();
}

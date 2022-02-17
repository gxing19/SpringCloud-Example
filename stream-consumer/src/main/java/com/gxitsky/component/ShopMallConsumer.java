package com.gxitsky.component;

import com.gxitsky.component.binding.ShopMallInput;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @name: ShopMallConsumer
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-23 16:21
 **/
@EnableBinding(value = ShopMallInput.class)
public class ShopMallConsumer {

    @StreamListener(value = "orderIn")
    public void orderInfo(String order){
        System.out.println("Shop Mall : " + order);
    }
}
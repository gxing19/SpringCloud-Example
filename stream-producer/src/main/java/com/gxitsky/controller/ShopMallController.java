package com.gxitsky.controller;

import com.gxitsky.component.ShopMallProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @name: ShopMallController
 * @desc: TODO
 * @author: gxing
 * @date: 2019-05-23 15:53
 **/
@RestController
@RequestMapping("/shopmall")
public class ShopMallController {

    @Autowired
    private ShopMallProducer shopMallProducer;

    @RequestMapping("/order/{order}")
    public void order(@PathVariable String order){
        shopMallProducer.sendOrderInfo(order);
    }
}
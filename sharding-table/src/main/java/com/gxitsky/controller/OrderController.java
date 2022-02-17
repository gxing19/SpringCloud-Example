package com.gxitsky.controller;

import com.gxitsky.entity.OrderInfo;
import com.gxitsky.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @name: OrderController
 * @desc: TODO
 * @author: gxing
 * @date: 2019-06-26 14:09
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderInfoService orderInfoService;

    @RequestMapping("/getByOrderId")
    public OrderInfo getByOrderId(Long orderId){
        OrderInfo orderInfo = orderInfoService.getByOrderId(orderId);
        return orderInfo;
    }

    @RequestMapping("/addOrderInfo")
    public int addOrderInfo(){
        OrderInfo orderInfo = new OrderInfo().setCreateDatetime(new Date());
        int count = 0;
        for (int i = 0; i < 20; i++) {
             orderInfo.setOrderId((long) i).setUserId((long) (1000 + i));
            orderInfoService.addOrderInfo(orderInfo);
            count++;
        }
        return count;
    }


}
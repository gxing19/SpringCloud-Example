package com.shardingjdbc.shardingtable.service;

import com.shardingjdbc.shardingtable.entity.OrderInfo;

/**
 * @name: OrderInfoService
 * @desc: TODO
 * @author: gxing
 * @date: 2019-06-26 15:42
 **/
public interface OrderInfoService {
    OrderInfo getByOrderId(Long orderId);

    void addOrderInfo(OrderInfo orderInfo);
}

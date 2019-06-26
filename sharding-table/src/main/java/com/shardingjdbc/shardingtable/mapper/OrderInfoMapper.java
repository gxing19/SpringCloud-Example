package com.shardingjdbc.shardingtable.mapper;

import com.shardingjdbc.shardingtable.entity.OrderInfo;
import org.springframework.stereotype.Repository;

/**
 * @name: OrderInfoMapper
 * @desc: TODO
 * @author: gxing
 * @date: 2019-06-26 15:46
 **/
@Repository
public interface OrderInfoMapper {

    OrderInfo getByOrderId(Long orderId);

    void addOrderInfo(OrderInfo orderInfo);
}
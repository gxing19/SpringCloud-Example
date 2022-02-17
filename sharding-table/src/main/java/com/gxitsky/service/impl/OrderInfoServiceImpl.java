package com.gxitsky.service.impl;

import com.gxitsky.entity.OrderInfo;
import com.gxitsky.service.OrderInfoService;
import com.gxitsky.mapper.OrderInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @name: OrderServiceImpl
 * @desc: TODO
 * @author: gxing
 * @date: 2019-06-26 15:42
 **/
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;
    /*@Autowired
    private JdbcTemplate jdbcTemplate;*/

    @Override
    public OrderInfo getByOrderId(Long orderId) {
        OrderInfo orderInfo = orderInfoMapper.getByOrderId(orderId);
        return orderInfo;
    }

    @Override
    public void addOrderInfo(OrderInfo orderInfo) {
        orderInfoMapper.addOrderInfo(orderInfo);

//        String sql = "insert into order_info (order_id,user_id,create_datetime) values (?,?,?)";
//        int rows = jdbcTemplate.update(sql, orderInfo.getOrderId(), orderInfo.getUserId(), orderInfo.getCreateDatetime());
//        System.out.println(rows);
    }
}
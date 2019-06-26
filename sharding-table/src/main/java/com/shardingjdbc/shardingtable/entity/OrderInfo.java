package com.shardingjdbc.shardingtable.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @name: Order
 * @desc: TODO
 * @author: gxing
 * @date: 2019-06-26 13:53
 **/
public class OrderInfo implements Serializable {
    private static final long serialVersionUID = -5919760221944881420L;

    private Long orderId;
    private Long userId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDatetime;

    public OrderInfo() {
    }

    public OrderInfo(Long orderId, Long userId, Date createDatetime) {
        this.orderId = orderId;
        this.userId = userId;
        this.createDatetime = createDatetime;
    }

    public Long getOrderId() {
        return orderId;
    }

    public OrderInfo setOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public OrderInfo setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public OrderInfo setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
        return this;
    }
}
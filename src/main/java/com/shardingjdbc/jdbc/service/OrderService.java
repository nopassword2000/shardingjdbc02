package com.shardingjdbc.jdbc.service;

import com.shardingjdbc.jdbc.pojo.Order;

import java.util.List;

public interface  OrderService {

    /**
     * 新增订单
     *
     */
    void addOrder();

    /**
     * 查询
     */
    List<Order> findOrder();

    Long totalRecord();
}

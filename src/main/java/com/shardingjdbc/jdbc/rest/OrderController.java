package com.shardingjdbc.jdbc.rest;

import com.shardingjdbc.jdbc.pojo.Order;
import com.shardingjdbc.jdbc.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping(value = "/add")
    public void addOrder() {
        orderService.addOrder();
    }

    @GetMapping(value = "/find")
    public List<Order> findOrder() {
        return  orderService.findOrder();
    }

    @GetMapping(value = "/total")
    public Long totalOrder() {
        return  orderService.totalRecord();
    }
}

package com.shardingjdbc.jdbc.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shardingjdbc.jdbc.dao.OrderDao;
import com.shardingjdbc.jdbc.pojo.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderDao orderDao;

    @Override
    public void addOrder() {
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setPrice(new BigDecimal(Math.random()));
            //order.setUserId(new Random().nextLong());
            order.setStatus("0");
            orderDao.insert(order);
        }
    }


    //执行新增后，将两库的数据各取一条，来测试
    @Override
    public List<Order> findOrder() {
        List<Long> list=new ArrayList<>();
        list.add(575433759998869505L);
        list.add(575433771705171968L);
        QueryWrapper<Order> queryWrapper=new QueryWrapper<>();
        queryWrapper.in("order_id", list);
        return  orderDao.selectList(queryWrapper);
    }

    @Override
    public Long totalRecord() {
        return orderDao.tatal();
    }
}

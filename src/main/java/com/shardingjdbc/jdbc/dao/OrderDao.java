package com.shardingjdbc.jdbc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shardingjdbc.jdbc.pojo.Order;
import org.apache.ibatis.annotations.Select;

public interface OrderDao extends BaseMapper<Order> {


    @Select({"<script>",
            " select",
            " count(*) ",
            " from t_order t ",
            "</script>"
    })

    Long tatal();
}

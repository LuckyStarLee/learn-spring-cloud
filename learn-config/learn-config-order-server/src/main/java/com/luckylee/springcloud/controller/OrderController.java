package com.luckylee.springcloud.controller;

import com.luckylee.springcloud.common.model.Order;
import com.luckylee.springcloud.common.model.Result;
import com.luckylee.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping("/place")
    public Result placeOrder(Order order) throws Exception {

        this.orderService.placeOrder(order);
        return Result.success();
    }
}

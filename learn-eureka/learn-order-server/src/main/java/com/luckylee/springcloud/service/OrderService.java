package com.luckylee.springcloud.service;

import com.luckylee.springcloud.common.model.Order;

public interface OrderService {
    void placeOrder(Order order) throws Exception;
}

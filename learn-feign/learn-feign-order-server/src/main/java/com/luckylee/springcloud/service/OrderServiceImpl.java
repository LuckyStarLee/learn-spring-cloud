package com.luckylee.springcloud.service;

import com.luckylee.springcloud.common.client.GoodsServiceClient;
import com.luckylee.springcloud.common.model.Order;
import com.luckylee.springcloud.common.model.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private GoodsServiceClient goodsServiceClient;

    @Override
    public void placeOrder(Order order) throws Exception {

        Result result = this.goodsServiceClient.goodsInfo(order.getGoodsId());
        if (result != null && result.getCode() == 200) {
            System.out.println("=====下订单====");
            System.out.println(result.getData());
        }
    }
}

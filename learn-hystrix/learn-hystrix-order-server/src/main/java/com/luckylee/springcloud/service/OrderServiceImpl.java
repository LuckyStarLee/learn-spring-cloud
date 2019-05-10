package com.luckylee.springcloud.service;

import com.luckylee.springcloud.common.client.GoodsServiceClient;
import com.luckylee.springcloud.common.model.Order;
import com.luckylee.springcloud.common.model.Result;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
//@DefaultProperties(defaultFallback = "defaultByHystrix")// 统一处理请求熔断
public class OrderServiceImpl implements OrderService {
    @Resource
    private GoodsServiceClient goodsServiceClient;

    //@HystrixCommand(fallbackMethod = "defaultByPlaceOrder")//熔断
    //@HystrixCommand//熔断
    @Override
    public void placeOrder(Order order) throws Exception {

        Result result = this.goodsServiceClient.goodsInfo(order.getGoodsId());
        if (result != null && result.getCode() == 200) {
            System.out.println("=====下订单====");
            System.out.println(result.getData());
        } else {
            System.out.println(result.getMsg());
        }
    }

//    public void defaultByPlaceOrder(Order order) {
//        System.out.println("商品服务系统异常");
//    }
//
//    //defaultFallback 定义的方法必须是无参的
//    public void defaultByHystrix() {
//        System.out.println("商品服务系统异常");
//    }
}

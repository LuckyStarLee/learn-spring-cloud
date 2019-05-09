package com.luckylee.springcloud.service;

import com.luckylee.springcloud.common.model.Order;
import com.luckylee.springcloud.common.model.Result;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private RestTemplate restTemplate;

    @Override
    public void placeOrder(Order order) throws Exception {

        Result result = restTemplate.getForObject(new URI("http://GOODS/goods/goodsInfo/" + order.getGoodsId()), Result.class);

        if (result != null && result.getCode() == 200) {
            System.out.println("=====下订单====");
            System.out.println(result.getData());
        }
    }
}

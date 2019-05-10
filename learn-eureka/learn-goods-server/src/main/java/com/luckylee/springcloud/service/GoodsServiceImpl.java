package com.luckylee.springcloud.service;


import com.luckylee.springcloud.common.model.Goods;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {
    // 模拟数据库
    private  Map<String, Goods> data;

    @Value("${server.port}")
    private int port;

    @PostConstruct
    public void init() {
        data = new HashMap<>();
        data.put("1", new Goods("1", "手机", "国产手机", port));
        data.put("2", new Goods("2", "电脑", "台式电脑", port));
    }

    @Override
    public Goods findGoodsById(String goodsId) {
        Goods goods = data.get(goodsId);
        if (goods == null) {
            throw new RuntimeException("商品不存在");
        }

        return goods;
    }
}

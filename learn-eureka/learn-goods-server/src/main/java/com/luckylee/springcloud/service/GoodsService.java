package com.luckylee.springcloud.service;


import com.luckylee.springcloud.common.model.Goods;

public interface GoodsService {
    Goods findGoodsById(String goodsId);
}

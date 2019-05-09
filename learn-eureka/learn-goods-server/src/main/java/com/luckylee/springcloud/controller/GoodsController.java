package com.luckylee.springcloud.controller;

import com.luckylee.springcloud.common.model.Goods;
import com.luckylee.springcloud.common.model.Result;
import com.luckylee.springcloud.service.GoodsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @RequestMapping("/goodsInfo/{goodsId}")
    public Result goodsInfo(@PathVariable String goodsId) {

        Goods goods = this.goodsService.findGoodsById(goodsId);
        return Result.success(goods);
    }
}

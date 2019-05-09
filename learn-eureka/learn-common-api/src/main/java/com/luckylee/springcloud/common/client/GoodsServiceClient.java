package com.luckylee.springcloud.common.client;

import com.luckylee.springcloud.common.model.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "GOODS")
public interface GoodsServiceClient {

    @RequestMapping("/goods/goodsInfo/{goodsId}")
    public Result goodsInfo(@PathVariable("goodsId") String goodsId);
}

package com.luckylee.springcloud.common.fallback;

import com.luckylee.springcloud.common.client.GoodsServiceClient;
import com.luckylee.springcloud.common.model.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class GoodsServiceClientFallbackFactory implements FallbackFactory<GoodsServiceClient> {
    @Override
    public GoodsServiceClient create(Throwable throwable) {
        System.out.println(throwable.getMessage());
        return (goodsId) -> Result.fail(500, "商品服务系统出现异常oooo");
    }
}

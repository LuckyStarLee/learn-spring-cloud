package com.luckylee.springcloud.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {


    private String orderId;

    private String goodsId;

    private int num;

}

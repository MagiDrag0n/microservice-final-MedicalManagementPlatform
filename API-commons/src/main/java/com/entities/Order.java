package com.entities;

import java.math.BigDecimal;

public class Order {
    private String id;//主键，订单编号唯一
    private Long[] medicines;//药物品类
    private BigDecimal bill;//订单总价
}

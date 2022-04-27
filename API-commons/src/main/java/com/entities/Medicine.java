package com.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
    private Long id;//主键，药品编号唯一
    private Long orderid;//标记属于哪个订单
    private String name;//药品名称
    private String usage;//药品用量
    private Timestamp prod;//生产日期
    private String expd;//药品有效期
    private BigDecimal price;//药品价格
}

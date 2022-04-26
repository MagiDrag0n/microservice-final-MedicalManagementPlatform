package com.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
    private Long id;//主键，药品编号唯一
    private Long OrderId;//标记属于哪个订单
    private String name;//药品名称
    private String usage;//药品用量
    private Timestamp exp;//药品有效期
}

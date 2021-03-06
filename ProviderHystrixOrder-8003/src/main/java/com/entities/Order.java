package com.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;//主键，订单编号唯一
    private Long patientid;//患者id
    private BigDecimal bill;//订单总价
    private Timestamp time;//订单时间
    private int valid;//表示当前订单有效情况

    private List<Medicine> medicine;
}

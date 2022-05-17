package com.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;//主键，身份证号唯一
    private String name;//姓名
    private Timestamp birth;//生日
    private BigDecimal wallet;//医保余额
    private String token;//JWT token
}

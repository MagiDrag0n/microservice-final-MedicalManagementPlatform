package com.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Register {
    private Long id;//主键，挂号编号唯一
    private Long patientid;//患者编号
    private Long doctorid;//医生编号
    private Timestamp timestamp;//挂号时间
}

package com.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    private Long id;//主键，医生编号唯一
    private String name;//医生名称
    private String title;//医生职称
    private Long DeptId;//医生科室
    private Timestamp validTime;//工作时间
}

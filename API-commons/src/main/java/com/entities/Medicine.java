package com.entities;

import java.sql.Timestamp;

public class Medicine {
    private Long id;//主键，药品编号唯一
    private String name;//药品名称
    private String usage;//药品用量
    private Timestamp exp;//药品有效期
}

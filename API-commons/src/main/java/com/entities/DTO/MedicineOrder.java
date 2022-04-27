package com.entities.DTO;

import com.entities.Medicine;
import com.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicineOrder {
    private Medicine medicine;
    private Order order;
    private String TestOutput;
}

package com.idet.simple_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleItemDTO {

    private String productCode;
    private int qty;
    private double unitPrice;
    private double discount;

}

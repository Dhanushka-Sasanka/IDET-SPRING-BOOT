package com.idet.simple_api.dto;


import com.idet.simple_api.entity.Customer;
import com.idet.simple_api.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlaceOrderDTO {

    private Customer customer;
    private List<Item> items;


}

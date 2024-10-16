package com.idet.simple_api.controller;

import com.idet.simple_api.dto.PlaceOrderDTO;
import com.idet.simple_api.entity.Item;
import com.idet.simple_api.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order/")
public class OrderController {

    private final OrderService orderService;

    @PostMapping()
    public ResponseEntity<Boolean> createOrder(@RequestBody PlaceOrderDTO placeOrderDTO) {
        return new ResponseEntity<>(orderService.createOrder(placeOrderDTO), HttpStatus.OK);

//        steps to make an order

//        select customer
//        items search

//         1.add row to order
//         2.item stock must be updated
//         3.add rows to order_details

//        Transaction
//            ACID operation





    }
}

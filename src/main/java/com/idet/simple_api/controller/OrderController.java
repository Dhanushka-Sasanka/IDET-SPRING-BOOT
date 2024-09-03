package com.idet.simple_api.controller;

import com.idet.simple_api.entity.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order/")
public class OrderController {

    @PostMapping()
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        return new ResponseEntity<>(null, HttpStatus.OK);

    }
}

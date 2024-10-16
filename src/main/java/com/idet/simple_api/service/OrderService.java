package com.idet.simple_api.service;

import com.idet.simple_api.dto.PlaceOrderDTO;
import com.idet.simple_api.entity.Customer;
import com.idet.simple_api.entity.Item;
import com.idet.simple_api.entity.Order;
import com.idet.simple_api.entity.OrderDetails;
import com.idet.simple_api.repository.CustomerRepo;
import com.idet.simple_api.repository.ItemRepo;
import com.idet.simple_api.repository.OrderDetailRepo;
import com.idet.simple_api.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepo orderRepo;
    private final CustomerRepo customerRepo;
    private final ItemRepo itemRepo;
    private final OrderDetailRepo orderDetailRepo;

    @Transactional()
    public boolean createOrder(PlaceOrderDTO placeOrderDTO) {
        System.out.println("placeOrderDTO = " + placeOrderDTO);
        Order order = new Order();
        order.setOrderDate(new Date());

        Customer customer = customerRepo.findById(placeOrderDTO.getCustomer().getCustomerId()).orElseThrow();
        order.setCustomer(customer);

        Order savedOrder = orderRepo.save(order);

        placeOrderDTO.getItems().forEach(item -> {

            Item dbItem = itemRepo.findById(item.getCode()).orElseThrow();

            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setOrder(savedOrder);
            orderDetails.setDiscount(0);
            orderDetails.setItem(dbItem);
            orderDetails.setQty(item.getQytOnHand());
            orderDetails.setUnitPrice(item.getUnitPrice());
            orderDetails.setTotal(item.getUnitPrice() * item.getQytOnHand());

            orderDetailRepo.save(orderDetails);

            dbItem.setQytOnHand(dbItem.getQytOnHand() - item.getQytOnHand());
            itemRepo.save(dbItem);
        });

        return true;
    }
}

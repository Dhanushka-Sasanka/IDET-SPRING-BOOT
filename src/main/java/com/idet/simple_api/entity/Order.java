package com.idet.simple_api.entity;


import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "customerId", insertable = false, updatable = false)
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetails> orderDetails;

    public Order() {
    }

    public Order(int orderId, Date orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                '}';
    }
}

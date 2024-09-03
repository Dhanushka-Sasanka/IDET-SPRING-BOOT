package com.idet.simple_api.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderDetailsId;

    private int qty;

    private double unitPrice;

    private double discount;

    private double total;

    @ManyToOne
    @JoinColumn(name = "orderId" , referencedColumnName = "orderId")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "code" , referencedColumnName = "code")
    private Item item;

}

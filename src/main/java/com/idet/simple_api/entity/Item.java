package com.idet.simple_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "item")
public class Item {

    @Id
    private String code;
    private String description;
    private double unitPrice;
    private int qytOnHand;

    @OneToMany(mappedBy = "item")
    private Set<OrderDetails> orderDetails;

    public Item() {
    }

    public Item(String code, String description, double unitPrice, int qytOnHand) {
        this.code = code;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qytOnHand = qytOnHand;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQytOnHand() {
        return qytOnHand;
    }

    public void setQytOnHand(int qytOnHand) {
        this.qytOnHand = qytOnHand;
    }

    @Override
    public String toString() {
        return "Item{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", qytOnHand=" + qytOnHand +
                '}';
    }
}

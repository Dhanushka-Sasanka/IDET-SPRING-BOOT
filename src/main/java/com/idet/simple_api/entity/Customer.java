package com.idet.simple_api.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@RequiredArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
//    @Column(name = "id")
    private String customerId; //C001, C002, C003

    private String name;

    private String address;

    private double salary;

    @OneToMany(mappedBy = "customer")
    private Set<Order> order;


    public Customer() {
    }

    public Customer(String customerId, String name, String address, double salary) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    //    getters and setters

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                '}';
    }


}

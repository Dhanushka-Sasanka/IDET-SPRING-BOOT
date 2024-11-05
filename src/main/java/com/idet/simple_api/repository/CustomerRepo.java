package com.idet.simple_api.repository;


import com.idet.simple_api.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {

    /*Derived Query Methods*/
    Customer findByName(@Param("name") String name);

    List<Customer> findByNameStartingWith(String name);

    /*JPQL (Java persistence Query Language)*/
    @Query(value = "SELECT c FROM Customer c Where c.salary between ?1 and ?2")
    List<Customer> findCustomersBySalaryRange(double range1, double range2);

    /*Native Query*/
    @Query(value = "SELECT * from Customer c where c.salary > :range1", nativeQuery = true)
    List<Customer> findCustomersBySalaryGreaterThan(double range1);



}

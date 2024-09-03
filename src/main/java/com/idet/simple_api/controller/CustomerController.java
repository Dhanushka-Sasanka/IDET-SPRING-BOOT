package com.idet.simple_api.controller;


import com.idet.simple_api.entity.Customer;
import com.idet.simple_api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;

@RestController
@RequestMapping("/api/customer/")
public class CustomerController {


//    private final List<String> customerNamesList = new ArrayList<>();
//
//    @GetMapping("/get-all-customer")
//    List<String> findAllCustomers() {
//        return customerNamesList;
//    }
//
//
//    @PostMapping("create-customer")
//    String addCustomer(@RequestBody String customerName) {
//        if (!customerName.isEmpty()) {
//            customerNamesList.add(customerName);
//            return "customer name added";
//        }
//        return "customer not added";
//    }
//
//    @GetMapping("/get-customer/{id}")
//    String findCustomerById(@PathVariable String id) {
//        Optional<String> findByIdCustomer = customerNamesList.stream().filter(customer -> Objects.equals(customer, id)).findFirst();
//
////        return findByIdCustomer.orElseGet(() -> "Not Found Such a Customer like " + id);
//
//        if (findByIdCustomer.isPresent()) {
//            return findByIdCustomer.get();
//        }
//        return "Not Found Such a Customer like " + id;
//    }
//
//    @PutMapping("update-customer")
//    String updateCustomer(@RequestBody String customerOldName, @RequestBody String customerNewName) {
//        boolean contains = customerNamesList.contains(customerOldName);
//        if (contains) {
//            int index = customerNamesList.indexOf(customerOldName);
//            customerNamesList.set(index, customerNewName);
//            return "Customer " + customerOldName + "Updated to " + customerNewName + "successfully.";
//        }
//        return "Not Found Such a Customer";
//    }
//
//
////    @PatchMapping()
////    @DeleteMapping()
////

    //    @Autowired
    private final CustomerService customerService;

    @Autowired
    CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping()
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
//        CustomerService customerService = new CustomerService();

//        option 1
//        Customer serviceCustomer = customerService.createCustomer(customer);
//        return new ResponseEntity<>(serviceCustomer, HttpStatus.OK);

//        option 2
        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @DeleteMapping("{customerId}")
    public ResponseEntity<Map<String, Boolean>> removeCustomer(@PathVariable("customerId") String customerId) {
        return new ResponseEntity<>(customerService.removeCustomer(customerId), HttpStatus.OK);
    }

    @GetMapping("find-customer")
//    @RequestMapping(value = "/find-customer" , method = RequestMethod.GET)
    public ResponseEntity<Customer> findCustomerById(@RequestParam("customerId") String customerId) {
        Customer customerById = customerService.findCustomerById(customerId);
        return customerById != null ? new ResponseEntity<>(customerById, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    @PutMapping("{customerId}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer , @PathVariable("customerId") String customerId ) {
        Customer updateCustomer = customerService.updateCustomer(customer,customerId);
        return updateCustomer != null ? new ResponseEntity<>(updateCustomer, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    @PatchMapping("{customerId}")
    public ResponseEntity<Customer> updatePartialCustomer(@RequestBody Customer customer , @PathVariable("customerId") String customerId ) {
        Customer updateCustomer = customerService.updatePartialCustomer(customer,customerId);
        return updateCustomer != null ? new ResponseEntity<>(updateCustomer, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    //    this is for git testing
}

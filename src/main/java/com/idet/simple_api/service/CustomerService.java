package com.idet.simple_api.service;


import com.idet.simple_api.entity.Customer;
import com.idet.simple_api.repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

//    @Autowired
//    private CustomerRepo customerRepo;

    private final CustomerRepo customerRepo;

    public Customer createCustomer(Customer customer) {
        System.out.println("CustomerService.createCustomer");
//        Customer savedCustomer = customerRepo.save(customer);
//        return savedCustomer;
        return customerRepo.save(customer);
    }


    public List<Customer> getAllCustomers() {
//        String.format("Danish is %s  %s %d" , "implement a project", "" , 45);
        List<Customer> customerList = customerRepo.findAll();
        log.info("All Customers : {} ", customerList);
        return customerList;
    }


    public Map<String, Boolean> removeCustomer(String customerId) {
        HashMap<String, Boolean> map = new HashMap<>();
        Optional<Customer> customerById = customerRepo.findById(customerId);
        if (customerById.isPresent()) {
//            delete logic
            customerRepo.deleteById(customerId);
            map.put("delete", Boolean.TRUE);
        } else {
//            data is not found
            map.put("not-found", Boolean.FALSE);
        }
        return map;
    }

    public Customer findCustomerById(String customerId) {

        Optional<Customer> customerById = customerRepo.findById(customerId);
        if (customerById.isPresent()) {
            return customerById.get();
        } else {
            return null;
        }

//        return customerById.orElse(null);

    }

    public Customer updateCustomer(Customer customer, String customerID) {

        Optional<Customer> customerById = customerRepo.findById(customerID);

        Customer existsCustomer = customerById.get();
        existsCustomer.setName(customer.getName());
        existsCustomer.setAddress(customer.getAddress());
        existsCustomer.setSalary(customer.getSalary());
        return customerRepo.save(existsCustomer);
    }

    public Customer updatePartialCustomer(Customer customer, String customerID) {


        Optional<Customer> customerById = customerRepo.findById(customerID);
        if (customerById.isPresent()) {
            Customer existsCustomer = customerById.get();

            if (customer.getName() != null) {
                existsCustomer.setName(customer.getName());
            }
            if (customer.getAddress() != null) {
                existsCustomer.setAddress(customer.getAddress());
            }
            if (customer.getSalary() != 0.00) {
                existsCustomer.setSalary(customer.getSalary());
            }

            return customerRepo.save(existsCustomer);
        } else {
            return null;
        }
    }
}

package com.mono.ekart.service.impl;

import com.mono.ekart.dto.CustomerRequestDTO;
import com.mono.ekart.model.Customer;
import com.mono.ekart.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addOneCustomer(CustomerRequestDTO customerSaveDTO) {
        var customerExists = customerRepository.findCustomerByEmailAndMobile(customerSaveDTO.getEmail(),
                customerSaveDTO.getMobile());
        if (customerExists.isPresent()) {
            return Customer.builder().id(0).build();
        }
        Customer customer = Customer.builder()
                .email(customerSaveDTO.getEmail())
                .name(customerSaveDTO.getName())
                .mobile(customerSaveDTO.getMobile())
                .location(customerSaveDTO.getLocation())
                .build();
        customer = customerRepository.save(customer);
        return customer;
    }

    public String addAllCustomers(List<CustomerRequestDTO> customerSaveList) {
        Customer customer;
        List<Customer> customerList = new ArrayList<>();
        for (var c : customerSaveList) {
            customer = Customer.builder()
                    .email(c.getEmail())
                    .name(c.getName())
                    .mobile(c.getMobile())
                    .location(c.getLocation())
                    .build();
            customerList.add(customer);
        }
        customerRepository.saveAll(customerList);
        return "Saved : " + customerList;
    }

    public List<Customer> getListOfCustomers() {
        var listOfCustomers = customerRepository.findAll();
        return listOfCustomers;
    }

    public Customer getOneCustomer(String email, String mobile) {
        var customerExists = customerRepository.findCustomerByEmailAndMobile(email, mobile);
        if (customerExists.isEmpty()) {
            return Customer.builder().id(0).build();
        }
        var customer = customerExists.get();
        return customer;
    }

    public String deleteOneCustomer(CustomerRequestDTO deleteCustomerDTO) {
        var customerExists = customerRepository.findCustomerByEmailAndMobile(deleteCustomerDTO.getEmail(),
                deleteCustomerDTO.getMobile());
        if (customerExists.isEmpty()) {
            return "No Customer found to Delete";
        }
        customerRepository.delete(customerExists.get());
        return "deleted customer id : " + customerExists.get().getEmail();
    }

    public String deleteAllCustomers() {
        var customers = customerRepository.findAll();
        if (customers.size() == 0) {
            return "customers are not present";
        }
        customerRepository.deleteAll();
        return "deleted all customers " + customers;
    }
}

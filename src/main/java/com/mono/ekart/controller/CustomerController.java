package com.mono.ekart.controller;

import com.mono.ekart.dto.CustomerRequestDTO;
import com.mono.ekart.model.Customer;
import com.mono.ekart.service.impl.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> saveOneCustomer(@RequestBody CustomerRequestDTO saveOneCustomer) {
        return ResponseEntity.ok(customerService.addOneCustomer(saveOneCustomer));
    }

    @PostMapping("/customers")
    public ResponseEntity<String> saveAllCustomers(@RequestBody List<CustomerRequestDTO> saveAllCustomers) {
        String message = customerService.addAllCustomers(saveAllCustomers);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/customer")
    public ResponseEntity<Customer> fetchOneCustomer(@RequestParam String email, @RequestParam String mobile) {
        return ResponseEntity.ok(customerService.getOneCustomer(email, mobile));
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> fetchAllCustomers() {
        return ResponseEntity.ok(customerService.getListOfCustomers());
    }


    //------------------------XXXXXX----------------------------------------
    @DeleteMapping("/customer")
    public ResponseEntity<String> deleteOneCustomer(@RequestParam String email, @RequestParam String mobile) {
        var deleteCustomer = CustomerRequestDTO.builder().email(email).mobile(mobile).build();
        return ResponseEntity.ok(customerService.deleteOneCustomer(deleteCustomer));
    }

    @DeleteMapping("/customers")
    public ResponseEntity<String> deleteAllCustomers() {
        return ResponseEntity.ok(customerService.deleteAllCustomers());
    }
}

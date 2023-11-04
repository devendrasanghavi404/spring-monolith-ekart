package com.mono.ekart.controller;

import com.mono.ekart.dto.CustomerRequestDTO;
import com.mono.ekart.dto.OrderDTO;
import com.mono.ekart.model.Order;
import com.mono.ekart.service.impl.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order/place")
    public ResponseEntity<Order> createOneOrder(@RequestBody OrderDTO createOrderDTO) {
        return ResponseEntity.ok(orderService.saveOneOrder(createOrderDTO));
    }

    @GetMapping("/order")
    public ResponseEntity<Order> fetchOneOrder(@RequestParam String orderDescription) {
        var dto = OrderDTO.builder().orderDescription(orderDescription).build();
        return ResponseEntity.ok(orderService.getOneOrder(dto));
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> fetchAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/orders/track")
    public ResponseEntity<String> trackMyOrder(@RequestParam String email, @RequestParam String mobile) {
        CustomerRequestDTO customerDTO = CustomerRequestDTO.builder().email(email).mobile(mobile).build();
        return ResponseEntity.ok(orderService.trackOrderByEmail(customerDTO));
    }
}

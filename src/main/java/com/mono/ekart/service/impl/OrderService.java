package com.mono.ekart.service.impl;

import com.mono.ekart.dto.CustomerRequestDTO;
import com.mono.ekart.dto.OrderDTO;
import com.mono.ekart.model.Order;
import com.mono.ekart.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final RestTemplate restTemplate;

    private final CustomerService customerService;

    private static LocalDate currentTime = LocalDate.now();

    public OrderService(OrderRepository orderRepository, RestTemplate restTemplate, CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
        this.customerService = customerService;
    }


    public Order saveOneOrder(OrderDTO orderDTO) {
        Order order = Order.builder().orderDescription(orderDTO.getOrderDescription()).createdAt(currentTime.toString()).updatedAt(currentTime.toString()).build();
        order = orderRepository.save(order);
        return order;
    }

    public Order getOneOrder(OrderDTO orderDTO) {
        var orderExist = orderRepository.findOrderByOrderDescription(orderDTO.getOrderDescription());
        if (orderExist.isEmpty()) {
            return Order.builder().id(0).orderDescription(orderDTO.getOrderDescription()).createdAt("00").updatedAt("00").build();
        }
        return orderExist.get();
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public String trackOrderByEmail(CustomerRequestDTO customerRequestDTO) {
//        var customer = customerService.getOneCustomer(customerRequestDTO.getEmail(), customerRequestDTO.getMobile());
//        var order = orderRepository.findOrdersByCustomer_Id(customer.getId());
//        var response = new ResponseDTO<CustomerResponseDTO>();
        return "null";
    }
}

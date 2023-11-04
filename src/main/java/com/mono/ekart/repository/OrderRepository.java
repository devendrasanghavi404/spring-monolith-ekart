package com.mono.ekart.repository;

import com.mono.ekart.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findOrderByOrderDescription(String orderDescription);

    List<Order> findOrdersByCustomer_Id(Integer cId);
}

package com.mono.ekart.dto;

import com.mono.ekart.model.Order;
import com.mono.ekart.model.ShoppingCart;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CustomerResponseDTO {
    private String name;
    private String email;
    private String mobile;
    private String location;
    private ShoppingCart customerCart;
    private List<Order> ordersPlacedByCustomer;

}



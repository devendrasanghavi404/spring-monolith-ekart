package com.mono.ekart.dto;

import com.mono.ekart.model.Customer;
import com.mono.ekart.model.Product;
import lombok.*;

import java.util.List;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderResponseDTO {
    private Integer orderId;
    private String orderDescription;
    private String createdAt;
    private String updatedAt;
    private List<PlacedItems> productsInThisOrder;
    private Customer ofCustomer;
}

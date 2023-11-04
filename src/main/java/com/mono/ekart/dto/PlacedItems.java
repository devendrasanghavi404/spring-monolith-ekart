package com.mono.ekart.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PlacedItems {
    private Integer productId;
    private String productName;
    private String productModel;
    private Integer quantity;
    private Double amount;
}

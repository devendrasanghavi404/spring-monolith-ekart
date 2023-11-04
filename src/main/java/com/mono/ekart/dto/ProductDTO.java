package com.mono.ekart.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ProductDTO {

    private String productName;
    private String productModel;
    private Integer productQty;
    private Double productCost;
}

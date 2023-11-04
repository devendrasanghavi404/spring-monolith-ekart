package com.mono.ekart.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CustomerRequestDTO {
    private String name;
    private String email;
    private String mobile;
    private String location;
}

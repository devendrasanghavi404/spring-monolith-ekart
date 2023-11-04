package com.mono.ekart.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
public class ResponseDTO<T> {
    private T response;
}

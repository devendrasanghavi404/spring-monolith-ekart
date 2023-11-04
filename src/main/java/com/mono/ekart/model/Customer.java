package com.mono.ekart.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String mobile;
    private String location;

    //    @OneToOne(mappedBy = "customer")
//    private ShoppingCart shoppingCart;
//
    @OneToMany(mappedBy = "customer")
    @JsonBackReference
    private List<Order> orders;
}

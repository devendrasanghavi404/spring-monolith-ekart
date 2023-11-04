package com.mono.ekart.repository;

import com.mono.ekart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findProductByProductNameAndProductModel(String pname, String pmodel);
}

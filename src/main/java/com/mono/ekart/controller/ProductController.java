package com.mono.ekart.controller;

import com.mono.ekart.dto.ProductDTO;
import com.mono.ekart.model.Product;
import com.mono.ekart.service.impl.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<Product> saveOneProduct(@RequestBody ProductDTO addProductDTO) {
        return ResponseEntity.ok(productService.addOneProduct(addProductDTO));
    }

    @PostMapping("/products")
    public ResponseEntity<String> saveAllProducts(@RequestBody List<ProductDTO> addAllProductDTO) {
        return ResponseEntity.ok(productService.saveAllProducts(addAllProductDTO));
    }

    @GetMapping("/product")
    public ResponseEntity<Product> fetchOneProduct(@RequestParam String productName, String model) {
        ProductDTO productDTO = ProductDTO.builder().productName(productName).productModel(model).build();
        return ResponseEntity.ok(productService.getOneProduct(productDTO));
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> fetchAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
}


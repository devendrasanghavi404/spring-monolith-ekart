package com.mono.ekart.service.impl;

import com.mono.ekart.dto.ProductDTO;
import com.mono.ekart.model.Product;
import com.mono.ekart.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addOneProduct(ProductDTO saveProductDTO) {
        var productExists = productRepository.findProductByProductNameAndProductModel(saveProductDTO.getProductName(),
                saveProductDTO.getProductModel());
        if (productExists.isPresent()) {
            return Product.builder()
                    .productName(saveProductDTO.getProductName())
                    .productModel(saveProductDTO.getProductModel())
                    .build();
        }
        var product = Product.builder()
                .productName(saveProductDTO.getProductName())
                .productModel(saveProductDTO.getProductModel())
                .productQty(saveProductDTO.getProductQty())
                .productCost(saveProductDTO.getProductCost())
                .build();
        product = productRepository.save(product);
        return product;
    }

    public String saveAllProducts(List<ProductDTO> saveProductList) {
        Product product;
        List<Product> productList = new ArrayList<>();
        for (var p : saveProductList) {
            product = Product.builder()
                    .productName(p.getProductName())
                    .productModel(p.getProductModel())
                    .productQty(p.getProductQty())
                    .productCost(p.getProductCost())
                    .build();
            productList.add(product);
        }
        productRepository.saveAll(productList);
        return "saved all : " + productList;
    }

    public Product getOneProduct(ProductDTO getProductDto) {
        var productExists = productRepository.findProductByProductNameAndProductModel(getProductDto.getProductName(),
                getProductDto.getProductModel());
        if (productExists.isEmpty()) {
            return Product.builder()
                    .id(0)
                    .productName(getProductDto.getProductName())
                    .productModel(getProductDto.getProductModel())
                    .build();
        }
        return productExists.get();
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}

package com.example.springbootjwt.controller;

import com.example.springbootjwt.entity.Product;
import com.example.springbootjwt.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

        private final ProductRepository productRepository;

//        @PostMapping
//        public ResponseEntity<Product> create(@RequestBody Product product) {
//            Product savedProduct = productRepository.save(product);
//            URI productURI = URI.create("/products/" + savedProduct.getId());
//            return ResponseEntity.created(productURI).body(savedProduct);
//        }

        @GetMapping
        public List<Product> list() {
            return productRepository.findAll();
        }
}

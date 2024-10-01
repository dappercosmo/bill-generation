package com.trial.billGeneration.controller;

import com.trial.billGeneration.model.Product;
import com.trial.billGeneration.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products/v1/")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
    ResponseEntity<?> addProduct(@RequestBody Product product){
        try{
            productService.addProduct(product);
            return ResponseEntity.ok(product);
        }catch (Exception e){
            e.printStackTrace();
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }
}

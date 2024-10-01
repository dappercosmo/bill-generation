package com.trial.billGeneration.serviceImpl;

import com.trial.billGeneration.model.Product;
import com.trial.billGeneration.repository.ProductRepository;
import com.trial.billGeneration.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public Product addProduct(Product product) {
        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setDescription(product.getDescription());
        newProduct.setCreatedAt(new Date());
        newProduct.setUpdatedAt(new Date());
        newProduct.setDeleted(false);
        return productRepository.save(newProduct);
    }
}

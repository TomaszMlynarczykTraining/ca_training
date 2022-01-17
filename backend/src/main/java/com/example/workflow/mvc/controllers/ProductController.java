package com.example.workflow.mvc.controllers;


import com.example.workflow.mvc.entity.Product;
import com.example.workflow.mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product submitProducts(Product product) {
        System.out.println(product.getIsChecked());
        return product;
    }
}

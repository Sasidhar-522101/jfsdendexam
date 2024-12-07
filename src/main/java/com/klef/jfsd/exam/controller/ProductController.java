package com.klef.jfsd.exam.controller;

import com.klef.jfsd.exam.dto.ProductDTO;
import com.klef.jfsd.exam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Fetch all products
    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    // Fetch a product by ID (input from URL)
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable("id") int id) {
        return productService.getProductById(id);
    }
}

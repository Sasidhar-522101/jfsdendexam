package com.klef.jfsd.exam.service;

import com.klef.jfsd.exam.dto.ProductDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private final RestTemplate restTemplate;

    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Fetch all products
    public List<ProductDTO> getAllProducts() {
        String apiUrl = "https://fakestoreapi.com/products";
        ProductDTO[] productArray = restTemplate.getForObject(apiUrl, ProductDTO[].class);
        return Arrays.asList(productArray);
    }

    // Fetch product by ID (from URL)
    public ProductDTO getProductById(int id) {
        String apiUrl = "https://fakestoreapi.com/products/" + id;
        return restTemplate.getForObject(apiUrl, ProductDTO.class);
    }
}

package com.packt.webstore.service.impl;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product getProductById(String productId) {
        return productRepository.getProductById(productId);
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.getProductsByCategory(category);
    }

    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        return productRepository.getProductsByFilter(filterParams);
    }

    public Set<Product> getProductsByPriceFilter(Map<String, List<String>> filterParams) {
        return productRepository.getProductsByPriceFilter(filterParams);
    }

    public List<Product> getProductsByManufacturer(String manufacturer) {
        return productRepository.getProductsByManufacturer(manufacturer);
    }

    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }
}

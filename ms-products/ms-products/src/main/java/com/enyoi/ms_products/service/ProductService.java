package com.enyoi.ms_products.service;

import com.enyoi.ms_products.model.Product;
import com.enyoi.ms_products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product saveNewProduct(String name){
        Product product = new Product();
        product.setStock(100);
        product.setName(name);
        return productRepository.save(product);
    }

    public Product getProductByName(String name){
        return productRepository.findByName(name);
    }

    public Product updateStock(String id, Integer quantitySold){
        Product product = productRepository.findById(id).get();
        product.setStock(product.getStock() - quantitySold);
        return productRepository.save(product);
    }

}

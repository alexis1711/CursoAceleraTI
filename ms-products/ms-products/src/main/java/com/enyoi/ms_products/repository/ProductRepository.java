package com.enyoi.ms_products.repository;

import com.enyoi.ms_products.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String>{

    Product findByName(String name);

}

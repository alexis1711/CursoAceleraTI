package com.enyoi.ms_products.controller;

import com.enyoi.ms_products.dto.SaveNewProductDto;
import com.enyoi.ms_products.dto.UpdateProductDto;
import com.enyoi.ms_products.model.Product;
import com.enyoi.ms_products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> saveNewProduct(@RequestBody SaveNewProductDto dto){
        Product response = productService.saveNewProduct(dto.getName());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable("name") String name){
        Product response = productService.getProductByName(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateStock(@PathVariable("id") String id, @RequestBody UpdateProductDto dto){
        Product response = productService.updateStock(id, dto.getStock());
        return ResponseEntity.ok(response);
    }


}

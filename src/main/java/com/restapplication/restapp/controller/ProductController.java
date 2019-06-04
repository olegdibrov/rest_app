package com.restapplication.restapp.controller;

import com.restapplication.restapp.domain.Product;
import com.restapplication.restapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.awt.color.ProfileDataException;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @PostMapping(value = "/products")
    public ResponseEntity<Product> createNewProduct(@RequestBody Product newProduct) {
        return new ResponseEntity<>(productService.save(newProduct), HttpStatus.OK);
    }


    @GetMapping(value = "/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        return productService.get(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

//    @GetMapping(value = "/products/{id}")
//    public Product getProductById(@PathVariable int id) {
//        return productService.get(id).get();
//
//    }

    @PutMapping("/products/{id}")
    Product replaceProduct(@RequestBody Product newProduct, @PathVariable int id) {
        return productService.get(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setPrice(newProduct.getPrice());
                    product.setDescription(newProduct.getDescription());
                    product.setCategory(newProduct.getCategory());
                    return productService.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return productService.save(newProduct);
                });
    }

    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable int id) {
        productService.deleteById(id);
    }
}

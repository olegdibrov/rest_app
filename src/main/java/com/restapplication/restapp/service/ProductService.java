package com.restapplication.restapp.service;

import com.restapplication.restapp.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    Product save(Product product);

    Product update(Product product);

    Optional<Product> get(int id);

    void deleteById(int id);

    List<Product> findAll();

}

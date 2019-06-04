package com.restapplication.restapp.controller;

import com.restapplication.restapp.domain.Category;
import com.restapplication.restapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/category")
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @PostMapping(value = "/category")
    public ResponseEntity<Category> createNewCategory(@RequestBody Category newCategory) {
       return Optional.of(categoryService.save(newCategory))
               .map((x) -> new ResponseEntity<>(x, HttpStatus.OK ))
               .orElse(ResponseEntity.badRequest().build());
//        Optional<Category> category1 = Optional<category>;
//        ResponseEntity responseEntity = new ResponseEntity<>(, HttpStatus.OK);
    }


    @GetMapping(value = "/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
        return categoryService.get(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    @PutMapping("/category/{id}")
    public Category replaceCategory(@RequestBody Category newCategory, @PathVariable int id) {
        return categoryService.get(id)
                .map(category -> {
                    category.setName(newCategory.getName());
                    category.setId(newCategory.getId());
                    category.setProducts(newCategory.getProducts());
                    return categoryService.save(category);
                })
                .orElseGet(() -> {
                    newCategory.setId(id);
                    return categoryService.save(newCategory);
                });
    }

    @DeleteMapping("/category/{id}")
    void deleteProduct(@PathVariable int id) {
        categoryService.deleteById(id);
    }
}

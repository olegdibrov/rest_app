package com.restapplication.restapp.service.impl;

import com.restapplication.restapp.domain.Category;
import com.restapplication.restapp.repository.CategoryRepository;
import com.restapplication.restapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> get(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);

    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}

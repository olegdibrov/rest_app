package com.restapplication.restapp.service;

import com.restapplication.restapp.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {
    Category save(Category category);

    Category update(Category category);

    Optional<Category> get(int id);

    void deleteById(int id);

    List<Category> findAll();
}

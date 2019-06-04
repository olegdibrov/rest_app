package com.restapplication.restapp.repository;

import com.restapplication.restapp.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Calendar;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

package com.example.demo.repository;

import com.example.demo.models.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer> {
}

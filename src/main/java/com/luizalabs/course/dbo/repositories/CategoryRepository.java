package com.luizalabs.course.dbo.repositories;

import com.luizalabs.course.dbo.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

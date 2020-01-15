package com.luizalabs.course.dbo.repositories;

import com.luizalabs.course.dbo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

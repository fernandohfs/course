package com.luizalabs.course.dbo.repositories;

import com.luizalabs.course.dbo.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

package com.luizalabs.course.dbo.repositories;

import com.luizalabs.course.dbo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

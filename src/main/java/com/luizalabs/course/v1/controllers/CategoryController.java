package com.luizalabs.course.v1.controllers;

import com.luizalabs.course.business.CategoryBusiness;
import com.luizalabs.course.v1.dto.response.CategoryResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/categories")
public class CategoryController {

  private CategoryBusiness categoryBusiness;

  @Autowired
  public CategoryController(final CategoryBusiness categoryBusiness) {
    this.categoryBusiness = categoryBusiness;
  }

  @GetMapping
  public ResponseEntity<List<CategoryResponseDto>> findAll() {
    Optional<List<CategoryResponseDto>> categories = categoryBusiness.findAll();

    return ResponseEntity.status(HttpStatus.OK).body(categories.orElse(new ArrayList<>()));
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<CategoryResponseDto> findById(@PathVariable Long id) {
    Optional<CategoryResponseDto> category = categoryBusiness.findById(id);

    return ResponseEntity.status(HttpStatus.OK).body(category.orElse(null));
  }

}

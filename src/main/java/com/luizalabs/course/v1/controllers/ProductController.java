package com.luizalabs.course.v1.controllers;

import com.luizalabs.course.business.ProductBusiness;
import com.luizalabs.course.v1.dto.response.ProductResponseDto;
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
@RequestMapping(value = "/v1/products")
public class ProductController {

  private ProductBusiness productBusiness;

  @Autowired
  public ProductController(final ProductBusiness productBusiness) {
    this.productBusiness = productBusiness;
  }

  @GetMapping
  public ResponseEntity<List<ProductResponseDto>> findAll() {
    Optional<List<ProductResponseDto>> products = productBusiness.findAll();

    return ResponseEntity.status(HttpStatus.OK).body(products.orElse(new ArrayList<>()));
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<ProductResponseDto> findById(@PathVariable Long id) {
    Optional<ProductResponseDto> product = productBusiness.findById(id);

    return ResponseEntity.status(HttpStatus.OK).body(product.orElse(null));
  }

}

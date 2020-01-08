package com.luizalabs.course.v1.controllers;

import com.luizalabs.course.business.OrderBusiness;
import com.luizalabs.course.v1.dto.response.OrderResponseDto;
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
@RequestMapping(value = "/v1/orders")
public class OrderController {

  private OrderBusiness orderBusiness;

  @Autowired
  public OrderController(final OrderBusiness orderBusiness) {
    this.orderBusiness = orderBusiness;
  }

  @GetMapping
  public ResponseEntity<List<OrderResponseDto>> findAll() {
    Optional<List<OrderResponseDto>> orders = orderBusiness.findAll();

    return ResponseEntity.status(HttpStatus.OK).body(orders.orElse(new ArrayList<>()));
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<OrderResponseDto> findById(@PathVariable Long id) {
    Optional<OrderResponseDto> order = orderBusiness.findById(id);

    return ResponseEntity.status(HttpStatus.OK).body(order.orElse(null));
  }

}

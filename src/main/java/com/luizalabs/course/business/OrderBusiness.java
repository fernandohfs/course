package com.luizalabs.course.business;

import com.luizalabs.course.v1.dto.response.OrderResponseDto;

import java.util.List;
import java.util.Optional;

public interface OrderBusiness {

  Optional<List<OrderResponseDto>> findAll();
  Optional<OrderResponseDto> findById(Long id);

}

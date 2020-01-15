package com.luizalabs.course.business;

import com.luizalabs.course.v1.dto.response.ProductResponseDto;

import java.util.List;
import java.util.Optional;

public interface ProductBusiness {

  Optional<List<ProductResponseDto>> findAll();
  Optional<ProductResponseDto> findById(Long id);

}

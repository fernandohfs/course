package com.luizalabs.course.business;

import com.luizalabs.course.v1.dto.response.CategoryResponseDto;

import java.util.List;
import java.util.Optional;

public interface CategoryBusiness {

  Optional<List<CategoryResponseDto>> findAll();
  Optional<CategoryResponseDto> findById(Long id);

}

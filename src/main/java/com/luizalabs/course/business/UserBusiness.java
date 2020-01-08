package com.luizalabs.course.business;

import com.luizalabs.course.v1.dto.response.UserResponseDto;

import java.util.List;
import java.util.Optional;

public interface UserBusiness {

  Optional<List<UserResponseDto>> findAll();
  Optional<UserResponseDto> findById(Long id);

}

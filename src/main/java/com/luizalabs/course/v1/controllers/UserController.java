package com.luizalabs.course.v1.controllers;

import com.luizalabs.course.business.UserBusiness;
import com.luizalabs.course.v1.dto.response.UserResponseDto;
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
@RequestMapping(value = "/v1/users")
public class UserController {

  private UserBusiness userBusiness;

  @Autowired
  public UserController(final UserBusiness userBusiness) {
    this.userBusiness = userBusiness;
  }

  @GetMapping
  public ResponseEntity<List<UserResponseDto>> findAll() {
    Optional<List<UserResponseDto>> users = userBusiness.findAll();

    return ResponseEntity.status(HttpStatus.OK).body(users.orElse(new ArrayList<>()));
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {
    Optional<UserResponseDto> user = userBusiness.findById(id);

    return ResponseEntity.status(HttpStatus.OK).body(user.orElse(null));
  }

}

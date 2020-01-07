package com.luizalabs.course.v1.controllers;

import com.luizalabs.course.dbo.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {

  @GetMapping
  public ResponseEntity<List<User>> findAll() {

    User fernando = User.builder()
        .id(1L)
        .name("Fernando")
        .email("fernando@gmail.com")
        .phone("16999999999")
        .password("123456")
        .build();

    User amanda = User.builder()
        .id(2L)
        .name("Amanda")
        .email("amanda@gmail.com")
        .phone("16999999998")
        .password("123456")
        .build();

    List<User> users = new ArrayList<>();

    users.add(fernando);
    users.add(amanda);

    return ResponseEntity.ok().body(users);

  }

}

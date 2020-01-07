package com.luizalabs.course.dbo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
@Builder
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;
  private String email;
  private String phone;
  private String password;

}

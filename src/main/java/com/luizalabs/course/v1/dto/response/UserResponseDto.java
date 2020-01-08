package com.luizalabs.course.v1.dto.response;

import com.luizalabs.course.dbo.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserResponseDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;
  private String email;
  private String phone;
  private String password;

  public static List<UserResponseDto> usersToUsersDto(List<User> users) {
    List<UserResponseDto> usersDto = new ArrayList<>();

    users.forEach(user -> {
      usersDto.add(UserResponseDto.builder()
          .id(user.getId())
          .name(user.getName())
          .email(user.getEmail())
          .phone(user.getPhone())
          .password(user.getPassword())
          .build());
    });

    return usersDto;
  }

  public static UserResponseDto userToUserDto(User user) {
    return UserResponseDto.builder()
        .id(user.getId())
        .name(user.getName())
        .email(user.getEmail())
        .phone(user.getPhone())
        .password(user.getPassword())
        .build();
  }

}

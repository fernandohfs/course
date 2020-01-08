package com.luizalabs.course.business.impl;

import com.luizalabs.course.business.UserBusiness;
import com.luizalabs.course.dbo.models.User;
import com.luizalabs.course.dbo.repositories.UserRepository;
import com.luizalabs.course.v1.dto.response.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserBusinessImpl implements UserBusiness {

  private UserRepository userRepository;

  @Autowired
  public UserBusinessImpl(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Optional<List<UserResponseDto>> findAll() {
    List<User> users = userRepository.findAll();
    List<UserResponseDto> usersDto = UserResponseDto.usersToUsersDto(users);

    return Optional.of(usersDto);
  }

  @Override
  public Optional<UserResponseDto> findById(Long id) {
    Optional<User> user = userRepository.findById(id);
    UserResponseDto userDto = UserResponseDto.userToUserDto(user.orElse(new User()));

    return Optional.of(userDto);
  }

}

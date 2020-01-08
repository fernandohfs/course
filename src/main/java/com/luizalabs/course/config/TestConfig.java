package com.luizalabs.course.config;

import com.luizalabs.course.dbo.models.User;
import com.luizalabs.course.dbo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner {

  private UserRepository userRepository;

  @Autowired
  public TestConfig(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    User user1 = User.builder()
        .id(null)
        .name("Fernando Soares")
        .email("fernando@gmail.com")
        .phone("16999887788")
        .password("123456")
        .build();

    User user2 = User.builder()
        .id(null)
        .name("Amanda Rigoni")
        .email("amanda@gmail.com")
        .phone("16999887799")
        .password("123456")
        .build();

    userRepository.saveAll(Arrays.asList(user1, user2));
  }
}

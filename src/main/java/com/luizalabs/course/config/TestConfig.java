package com.luizalabs.course.config;

import com.luizalabs.course.dbo.models.Order;
import com.luizalabs.course.dbo.models.User;
import com.luizalabs.course.dbo.repositories.OrderRepository;
import com.luizalabs.course.dbo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner {

  private UserRepository userRepository;
  private OrderRepository orderRepository;

  @Autowired
  public TestConfig(final UserRepository userRepository,
                    final OrderRepository orderRepository) {
    this.userRepository = userRepository;
    this.orderRepository = orderRepository;
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

    Order order1 = Order.builder()
        .id(null)
        .moment(Instant.parse("2019-06-20T19:53:07Z"))
        .client(user1)
        .build();

    Order order2 = Order.builder()
        .id(null)
        .moment(Instant.parse("2019-07-21T03:42:10Z"))
        .client(user2)
        .build();

    Order order3 = Order.builder()
        .id(null)
        .moment(Instant.parse("2019-06-22T15:21:22Z"))
        .client(user1)
        .build();

    userRepository.saveAll(Arrays.asList(user1, user2));
    orderRepository.saveAll(Arrays.asList(order1, order2, order3));

  }
}

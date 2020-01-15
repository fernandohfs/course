package com.luizalabs.course.config;

import com.luizalabs.course.dbo.models.Category;
import com.luizalabs.course.dbo.models.Order;
import com.luizalabs.course.dbo.models.Product;
import com.luizalabs.course.dbo.models.User;
import com.luizalabs.course.dbo.repositories.CategoryRepository;
import com.luizalabs.course.dbo.repositories.OrderRepository;
import com.luizalabs.course.dbo.repositories.ProductRepository;
import com.luizalabs.course.dbo.repositories.UserRepository;
import com.luizalabs.course.enumeration.OrderStatus;
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
  private CategoryRepository categoryRepository;
  private ProductRepository productRepository;

  @Autowired
  public TestConfig(final UserRepository userRepository,
                    final OrderRepository orderRepository,
                    final CategoryRepository categoryRepository,
                    final ProductRepository productRepository) {
    this.userRepository = userRepository;
    this.orderRepository = orderRepository;
    this.categoryRepository = categoryRepository;
    this.productRepository = productRepository;
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
        .orderStatus(OrderStatus.PAID.getCode())
        .client(user1)
        .build();

    Order order2 = Order.builder()
        .id(null)
        .moment(Instant.parse("2019-07-21T03:42:10Z"))
        .orderStatus(OrderStatus.WAITING_PAYMENT.getCode())
        .client(user2)
        .build();

    Order order3 = Order.builder()
        .id(null)
        .moment(Instant.parse("2019-06-22T15:21:22Z"))
        .orderStatus(OrderStatus.WAITING_PAYMENT.getCode())
        .client(user1)
        .build();

    Category category1 = Category.builder()
        .id(null)
        .name("Electronics")
        .build();

    Category category2 = Category.builder()
        .id(null)
        .name("Books")
        .build();

    Category category3 = Category.builder()
        .id(null)
        .name("Computers")
        .build();

    Product product1 = Product.builder()
        .id(null)
        .name("The Lord of the Rings")
        .description("Lorem ipsum dolor sit amet, consectetur.")
        .price(90.5)
        .imgUrl("")
        .category(category2)
        .build();

    Product product2 = Product.builder()
        .id(null)
        .name("Smart TV")
        .description("Nulla eu imperdiet purus. Maecenas ante.")
        .price(2190.0)
        .imgUrl("")
        .category(category1)
        .build();

    Product product3 = Product.builder()
        .id(null)
        .name("Macbook Pro")
        .description("Nam eleifend maximus tortor, at mollis.")
        .price(1250.0)
        .imgUrl("")
        .category(category3)
        .build();

    Product product4 = Product.builder()
        .id(null)
        .name("PC Gamer")
        .description("Donec aliquet odio ac rhoncus cursus.")
        .price(1200.0)
        .imgUrl("")
        .category(category3)
        .build();

    Product product5 = Product.builder()
        .id(null)
        .name("Rails for Dummies")
        .description("Cras fringilla convallis sem vel faucibus.")
        .price(100.99)
        .imgUrl("")
        .category(category1)
        .build();

    userRepository.saveAll(Arrays.asList(user1, user2));
    orderRepository.saveAll(Arrays.asList(order1, order2, order3));
    categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
    productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));

  }
}

package com.luizalabs.course.business.impl;

import com.luizalabs.course.business.OrderBusiness;
import com.luizalabs.course.dbo.models.Order;
import com.luizalabs.course.dbo.repositories.OrderRepository;
import com.luizalabs.course.v1.dto.response.OrderResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderBusinessImpl implements OrderBusiness {

  private OrderRepository orderRepository;

  @Autowired
  public OrderBusinessImpl(final OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Override
  public Optional<List<OrderResponseDto>> findAll() {
    List<Order> orders = orderRepository.findAll();
    List<OrderResponseDto> ordersDto = OrderResponseDto.ordersToOrdersDto(orders);

    return Optional.of(ordersDto);
  }

  @Override
  public Optional<OrderResponseDto> findById(Long id) {
    Optional<Order> order = orderRepository.findById(id);
    OrderResponseDto orderDto = OrderResponseDto.orderToOrderDto(order.orElse(new Order()));

    return Optional.of(orderDto);
  }
}

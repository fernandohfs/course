package com.luizalabs.course.v1.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luizalabs.course.dbo.models.Order;
import com.luizalabs.course.dbo.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderResponseDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private Instant moment;

  @JsonIgnore
  private User client;

  public static List<OrderResponseDto> ordersToOrdersDto(List<Order> orders) {
    List<OrderResponseDto> ordersDto = new ArrayList<>();

    orders.forEach(order -> {
      ordersDto.add(OrderResponseDto.builder()
          .id(order.getId())
          .moment(order.getMoment())
          .client(order.getClient())
          .build());
    });

    return ordersDto;
  }

  public static OrderResponseDto orderToOrderDto(Order order) {
    return OrderResponseDto.builder()
        .id(order.getId())
        .moment(order.getMoment())
        .client(order.getClient())
        .build();
  }

}

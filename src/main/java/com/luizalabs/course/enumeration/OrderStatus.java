package com.luizalabs.course.enumeration;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum OrderStatus {
  WAITING_PAYMENT(1),
  PAID(2),
  SHIPPED(3),
  DELIVERED(4),
  CANCELED(5);

  @Getter
  private int code;

  public static OrderStatus valueOf(int code) {
    for (OrderStatus value : OrderStatus.values()) {
      if (value.getCode() == code) {
        return value;
      }
    }

    throw new IllegalArgumentException("Invalid OrderStatus code");
  }
}

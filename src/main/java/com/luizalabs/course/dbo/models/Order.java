package com.luizalabs.course.dbo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luizalabs.course.enumeration.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
@Builder
@Entity
@Table(name = "orders")
public class Order implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
  private Instant moment;
  private Integer orderStatus;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "client_id")
  private User client;

  public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
    this.id = id;
    this.moment = moment;
    setOrderStatus(orderStatus);
    this.client = client;
  }

  public OrderStatus getOrderStatus() {
    return OrderStatus.valueOf(orderStatus);
  }

  public void setOrderStatus(OrderStatus orderStatus) {
    this.orderStatus = orderStatus.getCode();
  }
}

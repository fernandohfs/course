package com.luizalabs.course.dbo.models;

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
  private Instant moment;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private User client;

}

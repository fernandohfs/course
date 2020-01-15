package com.luizalabs.course.v1.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luizalabs.course.dbo.models.Category;
import com.luizalabs.course.dbo.models.Product;
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
public class ProductResponseDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;
  private String description;
  private Double price;
  private String imgUrl;

  @JsonIgnore
  private Category category;

  public static List<ProductResponseDto> productsToProductsDto(List<Product> products) {
    List<ProductResponseDto> productsDto = new ArrayList<>();

    products.forEach(product -> {
      productsDto.add(ProductResponseDto.builder()
          .id(product.getId())
          .name(product.getName())
          .description(product.getDescription())
          .price(product.getPrice())
          .imgUrl(product.getImgUrl())
          .category(product.getCategory())
          .build());
    });

    return productsDto;
  }

  public static ProductResponseDto productToProductDto(Product product) {
    return ProductResponseDto.builder()
        .id(product.getId())
        .name(product.getName())
        .description(product.getDescription())
        .price(product.getPrice())
        .imgUrl(product.getImgUrl())
        .category(product.getCategory())
        .build();
  }

}

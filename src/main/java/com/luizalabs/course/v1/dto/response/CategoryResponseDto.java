package com.luizalabs.course.v1.dto.response;

import com.luizalabs.course.dbo.models.Category;
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
public class CategoryResponseDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;

  public static List<CategoryResponseDto> categoriesToCategoriesDto(List<Category> categories) {
    List<CategoryResponseDto> categoriesDto = new ArrayList<>();

    categories.forEach(category -> {
      categoriesDto.add(CategoryResponseDto.builder()
          .id(category.getId())
          .name(category.getName())
          .build());
    });

    return categoriesDto;
  }

  public static CategoryResponseDto categoryToCategoryDto(Category category) {
    return CategoryResponseDto.builder()
        .id(category.getId())
        .name(category.getName())
        .build();
  }
}

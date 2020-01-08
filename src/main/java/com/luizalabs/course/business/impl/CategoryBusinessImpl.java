package com.luizalabs.course.business.impl;

import com.luizalabs.course.business.CategoryBusiness;
import com.luizalabs.course.dbo.models.Category;
import com.luizalabs.course.dbo.repositories.CategoryRepository;
import com.luizalabs.course.v1.dto.response.CategoryResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryBusinessImpl implements CategoryBusiness {

  private CategoryRepository categoryRepository;

  @Autowired
  public CategoryBusinessImpl(final CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Override
  public Optional<List<CategoryResponseDto>> findAll() {
    List<Category> categories = categoryRepository.findAll();
    List<CategoryResponseDto> categoriesDto = CategoryResponseDto.categoriesToCategoriesDto(categories);

    return Optional.of(categoriesDto);
  }

  @Override
  public Optional<CategoryResponseDto> findById(Long id) {
    Optional<Category> category = categoryRepository.findById(id);
    CategoryResponseDto categoryDto = CategoryResponseDto.categoryToCategoryDto(category.orElse(new Category()));

    return Optional.of(categoryDto);
  }
}

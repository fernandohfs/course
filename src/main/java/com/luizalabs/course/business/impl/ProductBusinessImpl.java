package com.luizalabs.course.business.impl;

import com.luizalabs.course.business.ProductBusiness;
import com.luizalabs.course.dbo.models.Product;
import com.luizalabs.course.dbo.repositories.ProductRepository;
import com.luizalabs.course.v1.dto.response.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductBusinessImpl implements ProductBusiness {

  private ProductRepository productRepository;

  @Autowired
  public ProductBusinessImpl(final ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Optional<List<ProductResponseDto>> findAll() {
    List<Product> products = productRepository.findAll();
    List<ProductResponseDto> productsDto = ProductResponseDto.productsToProductsDto(products);

    return Optional.of(productsDto);
  }

  @Override
  public Optional<ProductResponseDto> findById(Long id) {
    Optional<Product> product = productRepository.findById(id);
    ProductResponseDto productDto = ProductResponseDto.productToProductDto(product.orElse(new Product()));

    return Optional.of(productDto);
  }
}

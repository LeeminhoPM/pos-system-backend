package com.bluesky.pos_system.mappers;

import com.bluesky.pos_system.models.Category;
import com.bluesky.pos_system.models.Product;
import com.bluesky.pos_system.models.Store;
import com.bluesky.pos_system.payload.dto.ProductDTO;

public class ProductMapper {
    public static ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .brand(product.getBrand())
                .sku(product.getSku())
                .description(product.getDescription())
                .mrp(product.getMrp())
                .sellingPrice(product.getSellingPrice())
                .image(product.getImage())
                .store(StoreMapper.toDTO(product.getStore()))
                .category(CategoryMapper.toDTO(product.getCategory()))
                .categoryId(product.getCategory().getId())
                .storeId(product.getStore().getId())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }

    public static Product toEntity(ProductDTO productDTO, Store store, Category category) {
        return Product.builder()
                .name(productDTO.getName())
                .brand(productDTO.getBrand())
                .sku(productDTO.getSku())
                .description(productDTO.getDescription())
                .mrp(productDTO.getMrp())
                .sellingPrice(productDTO.getSellingPrice())
                .image(productDTO.getImage())
                .category(category)
                .store(store)
                .build();
    }
}

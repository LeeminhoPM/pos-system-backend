package com.bluesky.pos_system.mappers;

import com.bluesky.pos_system.models.Category;
import com.bluesky.pos_system.models.Store;
import com.bluesky.pos_system.payload.dto.CategoryDTO;

public class CategoryMapper {
    public static CategoryDTO toDTO(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .storeId(category.getStore() != null ? category.getStore().getId() : null)
                .build();
    }

    public static Category toEntity(CategoryDTO dto, Store store) {
        return Category.builder()
                .name(dto.getName())
                .store(store)
                .build();
    }
}

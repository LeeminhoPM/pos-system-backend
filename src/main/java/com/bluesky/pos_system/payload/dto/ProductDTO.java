package com.bluesky.pos_system.payload.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDTO {
    UUID id;

    String name;

    String sku;

    String description;

    Double mrp;

    Double sellingPrice;

    String brand;

    String image;

//    CategoryDTO category;

//    UUID categoryId;

    StoreDTO store;

    UUID storeId;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;
}

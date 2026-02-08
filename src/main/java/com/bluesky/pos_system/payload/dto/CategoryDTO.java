package com.bluesky.pos_system.payload.dto;

import com.bluesky.pos_system.models.Store;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryDTO {
    UUID id;

    String name;

    Store store;

    UUID storeId;
}

package com.bluesky.pos_system.payload.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BranchDTO {
    UUID id;

    String name;

    String address;

    String phone;

    String email;

    List<String> workingDays;

    LocalTime openTime;

    LocalTime closeTime;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

    UUID storeId;

    StoreDTO store;

    UserDTO manager;
}

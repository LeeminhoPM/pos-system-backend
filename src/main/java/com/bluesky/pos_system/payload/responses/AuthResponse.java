package com.bluesky.pos_system.payload.responses;

import com.bluesky.pos_system.payload.dto.UserDTO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthResponse {
    String jwt;
    String message;
    UserDTO user;
}

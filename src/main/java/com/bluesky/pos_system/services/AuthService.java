package com.bluesky.pos_system.services;

import com.bluesky.pos_system.exceptions.UserException;
import com.bluesky.pos_system.payload.dto.UserDTO;
import com.bluesky.pos_system.payload.responses.AuthResponse;

public interface AuthService {
    AuthResponse signup(UserDTO userDTO) throws UserException;
    AuthResponse login(UserDTO userDTO) throws UserException;
}

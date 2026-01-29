package com.bluesky.pos_system.controllers;

import com.bluesky.pos_system.exceptions.UserException;
import com.bluesky.pos_system.mappers.UserMapper;
import com.bluesky.pos_system.models.User;
import com.bluesky.pos_system.payload.dto.UserDTO;
import com.bluesky.pos_system.services.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserDTO> getUserProfile(@RequestHeader("Authorization") String jwtToken) throws UserException {
        User user = userService.getUserFromJwtToken(jwtToken);
        return ResponseEntity.status(HttpStatus.OK).body(UserMapper.toDTO(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable UUID id) throws UserException {
        User user = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(UserMapper.toDTO(user));
    }
}

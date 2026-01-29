package com.bluesky.pos_system.models;

import com.bluesky.pos_system.domains.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @Column(nullable = false)
    String fullName;

    @Column(nullable = false, unique = true)
    @Email(message = "Email không hợp lệ")
    String email;

    String phone;

    @Column(nullable = false)
    UserRole roles;

    @Column(nullable = false)
    String password;

    LocalDate createdAt;

    LocalDate updatedAt;

    LocalDateTime lastLogin;
}

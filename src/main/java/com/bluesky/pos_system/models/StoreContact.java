package com.bluesky.pos_system.models;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
// Embeddable: Dùng để khai báo bảng dữ liệu nhưng không có bảng riêng hay id (không phải entity)
// Dùng để tái sử dụng ở các entity khác
// Các trường trong Embeddable sẽ thành các column trong entity sử dụng nó
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StoreContact {
    String address;

    String phone;

    @Email(message = "Email không hợp lệ")
    String email;
}

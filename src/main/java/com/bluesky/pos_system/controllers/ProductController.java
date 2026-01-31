package com.bluesky.pos_system.controllers;

import com.bluesky.pos_system.models.User;
import com.bluesky.pos_system.payload.dto.ProductDTO;
import com.bluesky.pos_system.payload.responses.ApiResponse;
import com.bluesky.pos_system.services.ProductService;
import com.bluesky.pos_system.services.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {
    ProductService productService;
    UserService userService;

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO, @RequestHeader("Authorization") String token) {
        User user = userService.getUserFromJwtToken(token);
        ProductDTO response = productService.createProduct(productDTO, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/store/{id}")
    public ResponseEntity<List<ProductDTO>> getProductByStoreId(@PathVariable UUID id) {
        List<ProductDTO> response = productService.getAllProductsByStoreId(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/store/{id}/search")
//    Với requestParam thì keyword sẽ nằm sau dấu ? ngăn cách với url
//    VD: http://localhost:8080/api/products/store/{storeId}/search?keyword={keyword}
    public ResponseEntity<List<ProductDTO>> getProductByKeyword(@PathVariable UUID id, @RequestParam String keyword) {
        List<ProductDTO> response = productService.searchByKeyword(id, keyword);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable UUID id, @RequestBody ProductDTO productDTO, @RequestHeader("Authorization") String token) {
        User user = userService.getUserFromJwtToken(token);
        ProductDTO response = productService.updateProduct(id, productDTO, user);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable UUID id, @RequestHeader("Authorization") String token) {
        User user = userService.getUserFromJwtToken(token);
        productService.deleteProduct(id, user);
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.builder().message("Xóa sản phẩm thành công").build()
        );
    }
}

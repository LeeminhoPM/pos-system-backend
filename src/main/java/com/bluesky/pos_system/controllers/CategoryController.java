package com.bluesky.pos_system.controllers;

import com.bluesky.pos_system.payload.dto.CategoryDTO;
import com.bluesky.pos_system.payload.responses.ApiResponse;
import com.bluesky.pos_system.services.CategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryController {
    CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO response = categoryService.createCategory(categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<CategoryDTO>> getAllCategoriesByStore(@PathVariable UUID storeId) {
        List<CategoryDTO> response = categoryService.getAllCategoriesByStore(storeId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable UUID id, @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO response = categoryService.updateCategory(id, categoryDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable UUID id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Danh mục được xóa thành công"));
    }
}

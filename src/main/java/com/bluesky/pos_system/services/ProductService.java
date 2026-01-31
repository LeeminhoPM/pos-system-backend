package com.bluesky.pos_system.services;

import com.bluesky.pos_system.models.User;
import com.bluesky.pos_system.payload.dto.ProductDTO;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO, User user);

    ProductDTO updateProduct(UUID id, ProductDTO productDTO, User user);

    void deleteProduct(UUID id, User user);

    List<ProductDTO> getAllProductsByStoreId(UUID storeId);

    List<ProductDTO> searchByKeyword(UUID storeId, String keyword);
}

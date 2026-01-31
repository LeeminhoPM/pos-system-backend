package com.bluesky.pos_system.services.impl;

import com.bluesky.pos_system.mappers.ProductMapper;
import com.bluesky.pos_system.models.Product;
import com.bluesky.pos_system.models.Store;
import com.bluesky.pos_system.models.User;
import com.bluesky.pos_system.payload.dto.ProductDTO;
import com.bluesky.pos_system.repositories.ProductRepository;
import com.bluesky.pos_system.repositories.StoreRepository;
import com.bluesky.pos_system.services.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;
    StoreRepository storeRepository;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO, User user) {
        Store store = storeRepository.findById(productDTO.getStoreId()).orElseThrow(
                () -> new RuntimeException("Cửa hàng với id: " + productDTO.getStoreId() + " không được tìm thấy")
        );
        Product product = ProductMapper.toEntity(productDTO, store);
        return ProductMapper.toDTO(productRepository.save(product));
    }

    @Override
    public ProductDTO updateProduct(UUID id, ProductDTO productDTO, User user) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Không tìm thấy sản phẩm")
        );

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setSku(productDTO.getSku());
        product.setImage(productDTO.getImage());
        product.setMrp(productDTO.getMrp());
        product.setSellingPrice(productDTO.getSellingPrice());
        product.setBrand(productDTO.getBrand());

        return ProductMapper.toDTO(productRepository.save(product));
    }

    @Override
    public void deleteProduct(UUID id, User user) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Không tìm thấy sản phẩm")
        );
        productRepository.delete(product);
    }

    @Override
    public List<ProductDTO> getAllProductsByStoreId(UUID storeId) {
        List<Product> products = productRepository.findByStoreId(storeId);
        return products.stream().map(ProductMapper::toDTO).toList();
    }

    @Override
    public List<ProductDTO> searchByKeyword(UUID storeId, String keyword) {
        List<Product> products = productRepository.searchByKeyword(storeId, keyword);
        return products.stream().map(ProductMapper::toDTO).toList();
    }
}

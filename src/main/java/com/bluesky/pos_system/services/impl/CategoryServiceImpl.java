package com.bluesky.pos_system.services.impl;

import com.bluesky.pos_system.domains.UserRole;
import com.bluesky.pos_system.mappers.CategoryMapper;
import com.bluesky.pos_system.models.Category;
import com.bluesky.pos_system.models.Store;
import com.bluesky.pos_system.models.User;
import com.bluesky.pos_system.payload.dto.CategoryDTO;
import com.bluesky.pos_system.repositories.CategoryRepository;
import com.bluesky.pos_system.repositories.StoreRepository;
import com.bluesky.pos_system.services.CategoryService;
import com.bluesky.pos_system.services.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository;
    StoreRepository storeRepository;
    UserService userService;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        User user = userService.getCurrentUser();
        Store store = storeRepository.findById(categoryDTO.getStoreId()).orElseThrow(
                () -> new RuntimeException("Không tìm thấy cửa hàng")
        );
        checkAuthority(user, store);
        Category category = CategoryMapper.toEntity(categoryDTO, store);
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.toDTO(savedCategory);
    }

    @Override
    public List<CategoryDTO> getAllCategoriesByStore(UUID storeId) {
        List<Category> categories = categoryRepository.findByStoreId(storeId);
        return categories.stream().map(CategoryMapper::toDTO).toList();
    }

    @Override
    public CategoryDTO updateCategory(UUID id, CategoryDTO categoryDTO) {
        User user = userService.getCurrentUser();
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Không tìm thấy danh mục")
        );
        category.setName(categoryDTO.getName());
        checkAuthority(user, category.getStore());
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.toDTO(savedCategory);
    }

    @Override
    public void deleteCategory(UUID id) {
        User user = userService.getCurrentUser();
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Không tìm thấy danh mục")
        );
        checkAuthority(user, category.getStore());
        categoryRepository.delete(category);
    }

    private void checkAuthority(User user, Store store) {
        boolean isAdmin = user.getRoles().equals(UserRole.ROLE_STORE_ADMIN);
        boolean isManager = user.getRoles().equals(UserRole.ROLE_STORE_MANAGER);
        boolean isSameStore = user.equals(store.getStoreAdmin());

        if (!(isAdmin && isSameStore) && !isManager) {
            throw new RuntimeException("Bạn không có quyền thực hiện tác vụ này");
        }
    }
}

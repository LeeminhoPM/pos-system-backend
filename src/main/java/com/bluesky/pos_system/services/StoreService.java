package com.bluesky.pos_system.services;

import com.bluesky.pos_system.domains.StoreStatus;
import com.bluesky.pos_system.models.Store;
import com.bluesky.pos_system.models.User;
import com.bluesky.pos_system.payload.dto.StoreDTO;

import java.util.List;
import java.util.UUID;

public interface StoreService {
    StoreDTO createStore(StoreDTO storeDTO, User user);

    StoreDTO getStoreById(UUID storeId);

    List<StoreDTO> getAllStores();

    Store getStoreByAdmin();

    StoreDTO updateStore(StoreDTO storeDTO, UUID storeId);

    void deleteStore(UUID storeId);

    StoreDTO getStoreByEmployee();

    StoreDTO moderateStore(UUID storeId, StoreStatus storeStatus);
}

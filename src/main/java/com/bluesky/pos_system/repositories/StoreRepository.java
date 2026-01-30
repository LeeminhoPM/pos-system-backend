package com.bluesky.pos_system.repositories;

import com.bluesky.pos_system.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StoreRepository extends JpaRepository<Store, UUID> {
    Store findByStoreAdminId(UUID storeAdminId);
}

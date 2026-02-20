package com.bluesky.pos_system.repositories;

import com.bluesky.pos_system.models.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BranchRepository extends JpaRepository<Branch, UUID> {
    List<Branch> findByStoreId(UUID storeId);
}

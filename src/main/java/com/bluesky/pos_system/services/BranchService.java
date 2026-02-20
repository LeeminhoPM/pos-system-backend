package com.bluesky.pos_system.services;

import com.bluesky.pos_system.models.User;
import com.bluesky.pos_system.payload.dto.BranchDTO;

import java.util.List;
import java.util.UUID;

public interface BranchService {
    BranchDTO createBranch(BranchDTO branchDTO);

    BranchDTO updateBranch(UUID id, BranchDTO branchDTO);

    void deleteBranch(UUID id);

    List<BranchDTO> getAllBranchesByStoreId(UUID storeId);

    BranchDTO getBranchById(UUID id);
}

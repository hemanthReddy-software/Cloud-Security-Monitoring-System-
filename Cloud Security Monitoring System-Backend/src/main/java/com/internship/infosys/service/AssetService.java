package com.internship.infosys.service;

import java.util.List;

import com.internship.infosys.dto.AssetRequest;
import com.internship.infosys.dto.AssetResponse;

public interface AssetService {

    // ==========================================================
    // CRUD Operations
    // ==========================================================

    AssetResponse createAsset(AssetRequest request);

    AssetResponse updateAsset(Long id, AssetRequest request);

    void deleteAsset(Long id);

    AssetResponse getAssetById(Long id);

    List<AssetResponse> getAllAssets();

    // ==========================================================
    // Auto Discovery
    // ==========================================================

    List<AssetResponse> discoverAssets();

    List<AssetResponse> scanNetwork(String subnet);

    // ==========================================================
    // Dashboard Filters
    // ==========================================================

    List<AssetResponse> getAssetsByDepartment(String department);

    List<AssetResponse> getAssetsByAssignedDepartment(String department);

    List<AssetResponse> getAssetsByOwner(String owner);

    List<AssetResponse> getAssetsByAssignedUser(String username);

    List<AssetResponse> getAssetsByStatus(String status);

    List<AssetResponse> getAssetsByHealth(String health);

    List<AssetResponse> getAssetsByOperatingSystem(String operatingSystem);

    List<AssetResponse> getAssetsByAssetType(String assetType);

    List<AssetResponse> getAssetsByDeviceType(String deviceType);

    List<AssetResponse> getAssetsByLocation(String location);

    // ==========================================================
    // Search
    // ==========================================================

    List<AssetResponse> searchAssets(String keyword);

    AssetResponse getAssetByIpAddress(String ipAddress);

    AssetResponse getAssetByHostname(String hostname);

    AssetResponse getAssetByAssetTag(String assetTag);

    AssetResponse getAssetBySerialNumber(String serialNumber);

    // ==========================================================
    // Assignment
    // ==========================================================

    AssetResponse assignAssetToUser(
            Long assetId,
            String username,
            String department);

    AssetResponse transferAsset(
            Long assetId,
            String newDepartment,
            String newOwner);

    // ==========================================================
    // Dashboard Statistics
    // ==========================================================

    long getTotalAssets();

    long getHealthyAssets();

    long getCriticalAssets();

    long getActiveAssets();

    long getInactiveAssets();

    long getAssetsByDepartmentCount(String department);

    long getAssetsByOperatingSystemCount(String operatingSystem);

    long getAssetsByAssetTypeCount(String assetType);
 

    // ==========================================================
    // Reports
    // ==========================================================

    List<AssetResponse> getHighRiskAssets();

    List<AssetResponse> getLowAvailabilityAssets();

    List<AssetResponse> getRecentlyDiscoveredAssets();

    List<AssetResponse> getRecentlyScannedAssets();

}
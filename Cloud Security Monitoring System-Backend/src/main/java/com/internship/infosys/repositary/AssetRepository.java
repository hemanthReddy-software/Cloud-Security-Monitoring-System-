package com.internship.infosys.repositary;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internship.infosys.model.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {

    // ==========================================================
    // FIND SINGLE
    // ==========================================================

    Optional<Asset> findById(Long id);

    Optional<Asset> findByIpAddress(String ipAddress);

    Optional<Asset> findByMacAddress(String macAddress);

    Optional<Asset> findByHostname(String hostname);

    Optional<Asset> findByAssetTag(String assetTag);

    Optional<Asset> findBySerialNumber(String serialNumber);

    // ==========================================================
    // EXISTS
    // ==========================================================

    boolean existsByIpAddress(String ipAddress);

    boolean existsByMacAddress(String macAddress);

    boolean existsByHostname(String hostname);

    boolean existsByAssetTag(String assetTag);

    boolean existsBySerialNumber(String serialNumber);

    // ==========================================================
    // OWNER / ASSIGNMENT
    // ==========================================================

    List<Asset> findByDepartment(String department);

    List<Asset> findByAssignedDepartment(String assignedDepartment);

    List<Asset> findByOwner(String owner);

    List<Asset> findByAssignedUser(String assignedUser);

    List<Asset> findByAssignmentStatus(String assignmentStatus);

    // ==========================================================
    // STATUS
    // ==========================================================

    List<Asset> findByStatus(String status);

    List<Asset> findByHealth(String health);

    List<Asset> findByScanStatus(String scanStatus);

    // ==========================================================
    // NETWORK
    // ==========================================================

    List<Asset> findByWifiName(String wifiName);

    List<Asset> findByLocation(String location);

    List<Asset> findByIpAddressContaining(String ip);

    List<Asset> findByHostnameContainingIgnoreCase(String hostname);

    // ==========================================================
    // OPERATING SYSTEM
    // ==========================================================

    List<Asset> findByOperatingSystem(String operatingSystem);

    List<Asset> findByArchitecture(String architecture);

    // ==========================================================
    // ASSET DETAILS
    // ==========================================================

    List<Asset> findByAssetType(String assetType);

    List<Asset> findByAssetTypeIgnoreCase(String assetType);

    List<Asset> findByDeviceType(String deviceType);

    List<Asset> findByDeviceTypeIgnoreCase(String deviceType);

    List<Asset> findByManufacturer(String manufacturer);

    List<Asset> findByModel(String model);

    // ==========================================================
    // RISK
    // ==========================================================

    List<Asset> findByRiskScoreGreaterThan(Integer score);

    List<Asset> findByAvailabilityGreaterThan(Double availability);

    List<Asset> findByAvailabilityLessThan(Double availability);

    // ==========================================================
    // SEARCH
    // ==========================================================

    List<Asset> findByAssetNameContainingIgnoreCase(String keyword);

    List<Asset> findByDescriptionContainingIgnoreCase(String keyword);

    List<Asset> findByOwnerContainingIgnoreCase(String keyword);

    List<Asset> findByDepartmentContainingIgnoreCase(String keyword);

    List<Asset> findByManufacturerContainingIgnoreCase(String keyword);

    List<Asset> findByModelContainingIgnoreCase(String keyword);

    // ==========================================================
    // DELETE
    // ==========================================================

    void deleteByIpAddress(String ipAddress);

    void deleteByMacAddress(String macAddress);

    // ==========================================================
    // DASHBOARD COUNTS
    // ==========================================================

    long count();

    long countByStatus(String status);

    long countByHealth(String health);

    long countByDepartment(String department);

    long countByOperatingSystem(String operatingSystem);

    long countByAssetType(String assetType);

    long countByAssetTypeIgnoreCase(String assetType);

    long countByDeviceType(String deviceType);

    long countByDeviceTypeIgnoreCase(String deviceType);

    long countByManufacturer(String manufacturer);

    long countByLocation(String location);

    long countByRiskScoreGreaterThan(Integer score);

}
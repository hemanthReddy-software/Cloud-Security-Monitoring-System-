package com.internship.infosys.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
@Data 
@Entity
@Table(name = "assets")
public class Asset {

    // =====================================================
    // Primary Key
    // =====================================================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // =====================================================
    // Asset Information
    // =====================================================

    @Column(nullable = false)
    private String assetName;

    @Column(length = 3000)
    private String description;

    private String assetType;

    private String assetTag;

    private String serialNumber;

    private String manufacturer;

    private String model;

    private String deviceType;

    // =====================================================
    // Ownership
    // =====================================================

    private String owner;

    private String department;

    private String assignedDepartment;

    private String assignedUser;

    private String assignedBy;

    private String assignmentStatus;

    private LocalDate assignedDate;

    private String location;

    // =====================================================
    // Host Information
    // =====================================================

    private String hostname;

    @Column(unique = true)
    private String ipAddress;

    private String macAddress;

    private String wifiName;

    private String gateway;

    private String subnetMask;

    private String dnsServer;

    // =====================================================
    // Operating System
    // =====================================================

    private String operatingSystem;

    private String osVersion;

    private String architecture;

    // =====================================================
    // Hardware
    // =====================================================

    @Column(length = 500)
    private String processor;

    private Integer cpuCores;

    private Integer cpuUsage;

    private Integer memoryUsage;

    private Integer diskUsage;

    private Integer networkUsage;

    private Integer gpuUsage;

    // =====================================================
    // Security
    // =====================================================

    private String status;

    private String health;

    private Integer riskScore;

    private Double availability;

    private Integer vulnerabilityCount;

    private Integer incidentCount;

    private String patchLevel;

    // =====================================================
    // Discovery
    // =====================================================

    private String discoveredBy;

    private String scanStatus;

    private String scanDuration;

    private LocalDate discoveryDate;

    private LocalTime discoveryTime;

    private LocalDateTime discoveredAt;
   
    // =====================================================
    // Audit Information
    // =====================================================

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime lastSeen;

    private LocalDateTime lastScan;
    // =====================================================
    // Constructors
    // =====================================================

    public Asset() {

    }

    // =====================================================
    // Entity Lifecycle
    // =====================================================

    @PrePersist
    public void onCreate() {

        LocalDateTime now = LocalDateTime.now();

        createdAt = now;
        updatedAt = now;
        lastSeen = now;
        lastScan = now;
        discoveredAt = now;

        discoveryDate = LocalDate.now();
        discoveryTime = LocalTime.now();

        // ===============================
        // Default Status
        // ===============================

        if (status == null || status.isBlank()) {
            status = "ACTIVE";
        }

        if (health == null || health.isBlank()) {
            health = "Healthy";
        }

        if (assignmentStatus == null || assignmentStatus.isBlank()) {
            assignmentStatus = "Assigned";
        }

        if (scanStatus == null || scanStatus.isBlank()) {
            scanStatus = "Completed";
        }

        if (scanDuration == null || scanDuration.isBlank()) {
            scanDuration = "1 sec";
        }

        // ===============================
        // Default Security Values
        // ===============================

        if (availability == null) {
            availability = 99.99;
        }

        if (riskScore == null) {
            riskScore = 0;
        }

        if (vulnerabilityCount == null) {
            vulnerabilityCount = 0;
        }

        if (incidentCount == null) {
            incidentCount = 0;
        }

        if (patchLevel == null || patchLevel.isBlank()) {
            patchLevel = "Latest";
        }

        // ===============================
        // Assignment
        // ===============================

        if (assignedDate == null) {
            assignedDate = LocalDate.now();
        }

        if (assignedDepartment == null || assignedDepartment.isBlank()) {
            assignedDepartment = department;
        }

        if (assignedUser == null || assignedUser.isBlank()) {
            assignedUser = owner;
        }

        if (assignedBy == null || assignedBy.isBlank()) {
            assignedBy = "SentinelCore";
        }

        // ===============================
        // Discovery
        // ===============================

        if (discoveredBy == null || discoveredBy.isBlank()) {
            discoveredBy = "SentinelCore Auto Discovery";
        }

    }

    @PreUpdate
    public void onUpdate() {

        updatedAt = LocalDateTime.now();

        lastSeen = LocalDateTime.now();

        lastScan = LocalDateTime.now();

    }
    // =====================================================
    // Getters & Setters
    // =====================================================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAssignedDepartment() {
        return assignedDepartment;
    }

    public void setAssignedDepartment(String assignedDepartment) {
        this.assignedDepartment = assignedDepartment;
    }

    public String getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }

    public String getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }

    public String getAssignmentStatus() {
        return assignmentStatus;
    }

    public void setAssignmentStatus(String assignmentStatus) {
        this.assignmentStatus = assignmentStatus;
    }

    public LocalDate getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(LocalDate assignedDate) {
        this.assignedDate = assignedDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getWifiName() {
        return wifiName;
    }

    public void setWifiName(String wifiName) {
        this.wifiName = wifiName;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getSubnetMask() {
        return subnetMask;
    }

    public void setSubnetMask(String subnetMask) {
        this.subnetMask = subnetMask;
    }

    public String getDnsServer() {
        return dnsServer;
    }

    public void setDnsServer(String dnsServer) {
        this.dnsServer = dnsServer;
    }
    // =====================================================
    // Operating System
    // =====================================================

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    // =====================================================
    // Hardware
    // =====================================================

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public Integer getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(Integer cpuCores) {
        this.cpuCores = cpuCores;
    }

    public Integer getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(Integer cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public Integer getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(Integer memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public Integer getDiskUsage() {
        return diskUsage;
    }

    public void setDiskUsage(Integer diskUsage) {
        this.diskUsage = diskUsage;
    }

    public Integer getNetworkUsage() {
        return networkUsage;
    }

    public void setNetworkUsage(Integer networkUsage) {
        this.networkUsage = networkUsage;
    }

    public Integer getGpuUsage() {
        return gpuUsage;
    }

    public void setGpuUsage(Integer gpuUsage) {
        this.gpuUsage = gpuUsage;
    }

    // =====================================================
    // Security
    // =====================================================

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public Integer getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(Integer riskScore) {
        this.riskScore = riskScore;
    }

    public Double getAvailability() {
        return availability;
    }

    public void setAvailability(Double availability) {
        this.availability = availability;
    }

    public Integer getVulnerabilityCount() {
        return vulnerabilityCount;
    }

    public void setVulnerabilityCount(Integer vulnerabilityCount) {
        this.vulnerabilityCount = vulnerabilityCount;
    }

    public Integer getIncidentCount() {
        return incidentCount;
    }

    public void setIncidentCount(Integer incidentCount) {
        this.incidentCount = incidentCount;
    }

    public String getPatchLevel() {
        return patchLevel;
    }

    public void setPatchLevel(String patchLevel) {
        this.patchLevel = patchLevel;
    }

    // =====================================================
    // Scan Information
    // =====================================================

    public String getDiscoveredBy() {
        return discoveredBy;
    }

    public void setDiscoveredBy(String discoveredBy) {
        this.discoveredBy = discoveredBy;
    }

    public String getScanStatus() {
        return scanStatus;
    }

    public void setScanStatus(String scanStatus) {
        this.scanStatus = scanStatus;
    }

    public String getScanDuration() {
        return scanDuration;
    }

    public void setScanDuration(String scanDuration) {
        this.scanDuration = scanDuration;
    }

    // =====================================================
    // Discovery
    // =====================================================

    public LocalDate getDiscoveryDate() {
        return discoveryDate;
    }

    public void setDiscoveryDate(LocalDate discoveryDate) {
        this.discoveryDate = discoveryDate;
    }

    public LocalTime getDiscoveryTime() {
        return discoveryTime;
    }

    public void setDiscoveryTime(LocalTime discoveryTime) {
        this.discoveryTime = discoveryTime;
    }

    public LocalDateTime getDiscoveredAt() {
        return discoveredAt;
    }

    public void setDiscoveredAt(LocalDateTime discoveredAt) {
        this.discoveredAt = discoveredAt;
    }

    // =====================================================
    // Audit Information
    // =====================================================

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(LocalDateTime lastSeen) {
        this.lastSeen = lastSeen;
    }

    public LocalDateTime getLastScan() {
        return lastScan;
    }

    public void setLastScan(LocalDateTime lastScan) {
        this.lastScan = lastScan;
    }

}
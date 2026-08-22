package com.internship.infosys.service;

import java.net.InetAddress;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internship.infosys.model.Asset;
import com.internship.infosys.repositary.AssetRepository;

@Service
public class NetworkScannerService {

    @Autowired
    private AssetRepository repository;

    public List<Asset> scanNetwork(String subnet) {

        List<Asset> discoveredAssets = new ArrayList<>();

        for (int i = 1; i <= 254; i++) {

            String ip = subnet + "." + i;

            try {

                InetAddress address = InetAddress.getByName(ip);

                if (!address.isReachable(1000)) {
                    continue;
                }

                Asset asset = repository
                        .findByIpAddress(ip)
                        .orElse(new Asset());

                // ==========================
                // Basic Information
                // ==========================

                asset.setIpAddress(ip);

                String host =
                        address.getHostName();

                if (host == null ||
                        host.equals(ip)) {

                    host = "Unknown-" + i;
                }

                asset.setHostname(host);

                if (asset.getAssetName() == null) {

                    asset.setAssetName(host);
                }

                // ==========================
                // IMPORTANT
                // ==========================

                if (asset.getAssetType() == null) {

                    asset.setAssetType("Server");
                }

                // ==========================
                // Status
                // ==========================

                asset.setStatus("ACTIVE");
                asset.setHealth("Healthy");

                // ==========================
                // Default values
                // ==========================

                if (asset.getRiskScore() == null)
                    asset.setRiskScore(0);

                if (asset.getAvailability() == null)
                    asset.setAvailability(99.99);

                if (asset.getPatchLevel() == null)
                    asset.setPatchLevel("Latest");

                if (asset.getScanStatus() == null)
                    asset.setScanStatus("Completed");

                if (asset.getScanDuration() == null)
                    asset.setScanDuration("1 sec");

                asset.setDiscoveryDate(LocalDate.now());
                asset.setDiscoveryTime(LocalTime.now());
                asset.setDiscoveredAt(LocalDateTime.now());
                asset.setLastSeen(LocalDateTime.now());
                asset.setLastScan(LocalDateTime.now());

                repository.save(asset);

                discoveredAssets.add(asset);

            } catch (Exception e) {

                // ignore unreachable hosts

            }

        }

        return discoveredAssets;
    }

}
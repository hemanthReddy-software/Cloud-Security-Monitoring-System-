package com.internship.infosys.scheduler;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.internship.infosys.service.AssetService;

@Component
public class AssetDiscoveryScheduler {

    @Autowired
    private AssetService assetService;

    // ==========================================================
    // Automatic Local Asset Discovery
    // Every 5 Minutes
    // ==========================================================

    @Scheduled(fixedRate = 300000)
    public void discoverLocalMachine() {

        System.out.println("==========================================");
        System.out.println("Local Asset Discovery Started");
        System.out.println("Time : " + LocalDateTime.now());
        System.out.println("==========================================");

        try {

            assetService.discoverAssets();

            System.out.println("Local Asset Discovery Completed");

        } catch (Exception e) {

            System.out.println("Discovery Failed");

            e.printStackTrace();

        }

    }

    // ==========================================================
    // Automatic Network Scan
    // Every 30 Minutes
    // ==========================================================

    @Scheduled(fixedRate = 1800000)
    public void networkScan() {

        System.out.println("==========================================");
        System.out.println("Network Scan Started");
        System.out.println("Time : " + LocalDateTime.now());
        System.out.println("==========================================");

        try {

            /*
             * Change subnet according to your network
             *
             * Example:
             * 192.168.1
             * 192.168.0
             * 10.0.0
             */

            assetService.scanNetwork("192.168.1");

            System.out.println("Network Scan Completed");

        } catch (Exception e) {

            System.out.println("Network Scan Failed");

            e.printStackTrace();

        }

    }

    // ==========================================================
    // Refresh Asset Information
    // Every 10 Minutes
    // ==========================================================

    @Scheduled(fixedRate = 600000)
    public void refreshAssets() {

        System.out.println("Refreshing Asset Information...");

        try {

            assetService.discoverAssets();

        } catch (Exception ex) {

            ex.printStackTrace();

        }

    }

    // ==========================================================
    // Daily Maintenance
    // Every Day at 02:00 AM
    // ==========================================================

    @Scheduled(cron = "0 0 2 * * *")
    public void dailyMaintenance() {

        System.out.println("==========================================");
        System.out.println("Daily Maintenance Started");
        System.out.println("==========================================");

        try {

            assetService.getRecentlyScannedAssets();

            System.out.println("Maintenance Completed");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
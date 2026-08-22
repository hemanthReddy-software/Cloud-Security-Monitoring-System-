package com.internship.infosys.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.internship.infosys.dto.AlertDto;
import com.internship.infosys.dto.DashboardResponse;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.NetworkIF;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Override
    public DashboardResponse getDashboard() {

        DashboardResponse response = new DashboardResponse();

        SystemInfo systemInfo = new SystemInfo();

        // ================= CPU =================

        CentralProcessor processor =
                systemInfo.getHardware().getProcessor();

        long[] ticks = processor.getSystemCpuLoadTicks();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        int cpu =
                (int)(processor.getSystemCpuLoadBetweenTicks(ticks) * 100);

        // ================= Memory =================

        GlobalMemory memory =
                systemInfo.getHardware().getMemory();

        long totalMemory = memory.getTotal();

        long availableMemory = memory.getAvailable();

        int memoryUsage =
                (int)(((double)(totalMemory - availableMemory) / totalMemory) * 100);

        // ================= Disk =================

        File disk = File.listRoots()[0];

        long totalDisk = disk.getTotalSpace();

        long freeDisk = disk.getFreeSpace();

        int diskUsage =
                (int)(((double)(totalDisk - freeDisk) / totalDisk) * 100);

        // ================= Network =================

        long upload = 0;

        long download = 0;

        for (NetworkIF net : systemInfo.getHardware().getNetworkIFs()) {

            net.updateAttributes();

            upload += net.getBytesSent();

            download += net.getBytesRecv();
        }

        int networkUsage =
                (int)((upload + download) / 1024 / 1024);

        // ================= Dashboard =================

        response.setAssets(
                systemInfo.getOperatingSystem().getProcessCount());

        response.setServers(1);

        response.setEndpoints(1);

        response.setUsers(1);

        response.setIncidents(2);

        response.setVulnerabilities(4);

        response.setSecurityScore(94);

        response.setHealthy(1);

        response.setWarning(cpu > 70 ? 1 : 0);

        response.setCritical(cpu > 90 ? 1 : 0);

        response.setOffline(0);

        response.setAlerts(response.getWarning()
                + response.getCritical());

        response.setCpu(cpu);

        response.setMemory(memoryUsage);

        response.setDisk(diskUsage);

        response.setNetwork(networkUsage);

        response.setGpu(35);

        response.setDatabase(22);

        response.setUpload((int)(upload / 1024 / 1024));

        response.setDownload((int)(download / 1024 / 1024));

        response.setLatency(12);

        response.setPacketLoss(0);

        response.setMalware(0);

        response.setPhishing(1);

        response.setRansomware(0);

        response.setDdos(0);

        response.setUptime(99.98);

        // ================= Cloud =================

        List<String> cloud = new ArrayList<>();

        cloud.add(systemInfo.getOperatingSystem().toString());

        cloud.add(processor.getProcessorIdentifier().getName());

        cloud.add(Runtime.getRuntime().availableProcessors() + " Cores");

        cloud.add((totalMemory / 1024 / 1024 / 1024) + " GB RAM");

        response.setCloud(cloud);

        // ================= Activities =================

        List<String> activities = new ArrayList<>();

        activities.add("User admin logged in");

        activities.add("Firewall policy updated");

        activities.add("System scan completed");

        activities.add("Database backup successful");

        response.setActivities(activities);

        // ================= Recommendations =================

        List<String> recommendations = new ArrayList<>();

        recommendations.add("Enable Multi-Factor Authentication");

        recommendations.add("Update Windows Security Patches");

        recommendations.add("Review Firewall Rules");

        recommendations.add("Backup Critical Data");

        response.setRecommendations(recommendations);

        // ================= Alerts =================

        List<AlertDto> alerts = new ArrayList<>();

        alerts.add(new AlertDto(
                1L,
                "CRITICAL",
                "Server-01",
                "CPU",
                "CPU Usage exceeded 90%",
                "OPEN",
                "Admin",
                "OSHI",
                java.time.LocalDateTime.now().toString()
        ));

        alerts.add(new AlertDto(
                2L,
                "HIGH",
                "Database",
                "Memory",
                "Memory usage above threshold",
                "OPEN",
                "ITSM",
                "OSHI",
                java.time.LocalDateTime.now().toString()
        ));

        alerts.add(new AlertDto(
                3L,
                "LOW",
                "Firewall",
                "Security",
                "Firewall configuration verified",
                "RESOLVED",
                "Admin",
                "Firewall",
                java.time.LocalDateTime.now().toString()
        ));

        response.setAlertList(alerts);

        return response;
    }
}
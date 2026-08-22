package com.internship.infosys.dto;

import java.util.List;

import lombok.Data;


@Data
public class DashboardResponse {

    private int assets;
    private int servers;
    private int endpoints;
    private int users;

    private int alerts;
    private int incidents;
    private int vulnerabilities;

    private int healthy;
    private int warning;
    private int critical;
    private int offline;

    private int cpu;
    private int memory;
    private int disk;
    private int network;
    private int gpu;
    private int database;

    private int upload;
    private int download;

    private int latency;
    private int packetLoss;

    private int malware;
    private int phishing;
    private int ransomware;
    private int ddos;

    private int securityScore;

    private double uptime;

    private List<String> cloud;

    private List<String> recommendations;

    private List<String> activities;

    private List<AlertDto> alertList;

    // Generate Getters and Setters
}
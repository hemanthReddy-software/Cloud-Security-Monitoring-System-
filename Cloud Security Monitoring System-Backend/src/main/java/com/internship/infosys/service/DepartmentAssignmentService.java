package com.internship.infosys.service;



import org.springframework.stereotype.Service;

@Service
public class DepartmentAssignmentService {

    public String assignDepartment(
            String assetType,
            String operatingSystem,
            String hostname,
            String description) {

        String data = (
                assetType + " "
                        + operatingSystem + " "
                        + hostname + " "
                        + description)
                .toLowerCase();

        // ==========================
        // Finance
        // ==========================

        if (data.contains("finance")
                || data.contains("account")
                || data.contains("billing")
                || data.contains("invoice")) {

            return "Finance";

        }

        // ==========================
        // Human Resources
        // ==========================

        if (data.contains("hr")
                || data.contains("human")
                || data.contains("recruitment")
                || data.contains("payroll")) {

            return "Human Resources";

        }

        // ==========================
        // IT Support
        // ==========================

        if (data.contains("desktop")
                || data.contains("laptop")
                || data.contains("windows")) {

            return "IT Support";

        }

        // ==========================
        // Infrastructure
        // ==========================

        if (data.contains("server")
                || data.contains("linux")
                || data.contains("ubuntu")
                || data.contains("vm")) {

            return "Infrastructure";

        }

        // ==========================
        // Network Team
        // ==========================

        if (data.contains("switch")
                || data.contains("router")
                || data.contains("firewall")) {

            return "Network";

        }

        // ==========================
        // SOC
        // ==========================

        if (data.contains("security")
                || data.contains("soc")
                || data.contains("edr")
                || data.contains("siem")) {

            return "Security Operations";

        }

        // ==========================
        // Database
        // ==========================

        if (data.contains("mysql")
                || data.contains("oracle")
                || data.contains("postgres")
                || data.contains("database")) {

            return "Database";

        }

        // ==========================
        // Cloud
        // ==========================

        if (data.contains("aws")
                || data.contains("azure")
                || data.contains("gcp")
                || data.contains("kubernetes")) {

            return "Cloud";

        }

        return "General IT";
    }

}

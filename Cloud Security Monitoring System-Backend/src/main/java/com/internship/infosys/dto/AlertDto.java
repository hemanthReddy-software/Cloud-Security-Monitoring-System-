package com.internship.infosys.dto;

import lombok.Data;

@Data
public class AlertDto {

    private Long id;

    private String severity;

    private String asset;

    private String category;

    private String description;

    private String status;

    private String assignedTo;

    private String source;

    private String createdAt;

    public AlertDto(){}

    public AlertDto(Long id,String severity,String asset,String category,
                    String description,String status,String assignedTo,
                    String source,String createdAt){

        this.id=id;
        this.severity=severity;
        this.asset=asset;
        this.category=category;
        this.description=description;
        this.status=status;
        this.assignedTo=assignedTo;
        this.source=source;
        this.createdAt=createdAt;
    }

   
}
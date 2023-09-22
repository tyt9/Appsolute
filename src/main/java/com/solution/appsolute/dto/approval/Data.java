package com.solution.appsolute.dto.approval;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Data {
    private String name;
    private String plan;
    private String concept;
    private String customerStatus;
    private int materialCost;
    private int laborCost;
    private int productionCost;
    private String competitorComparison;
    private String developmentSchedule;
    private String salesPoint;
}

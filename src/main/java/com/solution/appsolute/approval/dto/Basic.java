package com.solution.appsolute.approval.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Basic {
    private String approvalName;
    private String deptName;
    private String approvalDate;
    private String approvalNum;
}

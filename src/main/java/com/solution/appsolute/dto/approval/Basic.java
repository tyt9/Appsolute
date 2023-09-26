package com.solution.appsolute.dto.approval;

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

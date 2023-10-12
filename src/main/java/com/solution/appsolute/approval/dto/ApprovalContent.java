package com.solution.appsolute.approval.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApprovalContent {
    private int appContentNum;
    private long approvalNum;
    private long documentNum;
    private String fieldKey;
    private String fieldValue;
}

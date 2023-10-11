package com.solution.appsolute.approval.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PurchaseVO {
    private long approvalNum;
    private String documentNum;
    private String fieldKey;
    private String fieldValue;
}

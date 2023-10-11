package com.solution.appsolute.approval.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PurchaseVO {
    private String totalKey;
    private int total;
    private String reasonKey;
    private String reason;
}

package com.solution.appsolute.dto.approval;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ExpenseReport {

    private String title;
    private String creationDate;
    private String department;
    private String author;
    private int totalAmount;
    private String reason;
}

package com.solution.appsolute.approval.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Approval {

    private long approvalNum;
    private int appCheck;
    private LocalDateTime approvalDate;
    private int appContent;
    private int appDel;
    private String appTitle;
    private int documentNum;
    private int empNum;
    private int lineNum;

}

package com.solution.appsolute.entity;

import javax.persistence.*;

@Entity
public class ApprovalContentDetail {

    @Id
    @Column(nullable = false)
    private Long approvalNum;

    @Column(nullable = false)
    private long documentNum;

    @Column(length = 50)
    private String data1;
    @Column(length = 50)
    private String data2;
    @Column(length = 50)
    private String data3;
    @Column(length = 50)
    private String data4;
    @Column(length = 50)
    private String data5;
    @Column(length = 50)
    private String data6;
    @Column(length = 50)
    private String data7;
    @Column(length = 50)
    private String data8;
    @Column(length = 50)
    private String data9;
    @Column(length = 50)
    private String data10;
}

package com.solution.appsolute.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long deptNo;

    @Column(length = 20, nullable = false)
    private String deptName;

    @Column(length = 30, nullable = false)
        private String deptLoc;

    @Column(nullable = false)
    @ColumnDefault("0")
        private int deptBranch;


};

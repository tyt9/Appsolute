package com.solution.appsolute.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDetail {

    @Id
    @Column(nullable = false)
    private Long documentNum;

    @Column(nullable = false)
    private String fieldName;

    @Column(nullable = false)
    private int sequence;

    @Column
    private int format;
}

package com.solution.appsolute.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mailNum;

    @Column(length = 100, nullable = false)
    private String mailTitle;

    @Column(length = 500, nullable = false)
    private String mailContent;

    @Column
    private LocalDateTime mailDate;

    @Column(nullable = false)
    private Long mailSender;

    @Column(nullable = false)
    private Long mailReceiver;

    @Column
    private int mailCheck;

}

package com.naukma.soccer.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Match {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45)
    @NotEmpty(message = "Please provide first team")
    private String t1_name;

    @Column(nullable = false, length = 45)
    @NotEmpty(message = "Please provide second team")
    private String t2_name;

    @Column(nullable = false, length = 45)
    @NotEmpty(message = "Please provide the score")
    private String score;

    @Column(nullable = false)
    @NotEmpty(message = "Please provide the match date")
    private Date match_date;

    @ManyToOne
    @JoinColumn(name = "championship", referencedColumnName = "id", nullable = false)
    private Championship championship;


}

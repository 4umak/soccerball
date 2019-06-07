package com.naukma.soccer.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "match_story")
public class Match {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String t1_name;

    @Column(nullable = false, length = 45)
    private String t2_name;

    @Column(nullable = false, length = 45)
    private String score;

    @Column(nullable = false)
    private Date match_date;

    @ManyToOne
    @JoinColumn(name = "championship_id", referencedColumnName = "id", nullable = false)
    private Championship championship;


}

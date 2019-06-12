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
public class Article {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotEmpty(message = "Please provide creation date")
    private Date create_date;

    @Column(nullable = false, length = 1000)
    @NotEmpty(message = "Please provide article's content")
    private String content;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "Please provide link to image")
    private String image_link;

    @ManyToOne
    @JoinColumn(name = "championship_id", referencedColumnName = "id")
    private Championship championship;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id", nullable = false)
    private Client client;
}

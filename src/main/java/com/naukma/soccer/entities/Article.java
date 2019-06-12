package com.naukma.soccer.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

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
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private Client user;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "article")
    private Set<Comment> comments = new HashSet<>();
}

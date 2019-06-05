package com.naukma.soccer.enteties;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private String id;
    
    @Column(name = "user_id")
    private int user_id;

    private String name;
}

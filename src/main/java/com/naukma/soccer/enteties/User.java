package com.naukma.soccer.enteties;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "username")
    @Email(message = "Please provide a valid email")
    @NotEmpty(message = "Please provide email")
    private String email;

    @NotEmpty(message = "Please provide your name")
    private String first_name;

    @NotEmpty(message = "Please provide your last name")
    private String last_name;

    @Length(min = 5, message = "Your password must have at least 5 characters")
    @NotEmpty(message = "Please provide your password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<Role> roleList;

}
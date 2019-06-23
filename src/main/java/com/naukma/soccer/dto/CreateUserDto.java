package com.naukma.soccer.dto;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class CreateUserDto {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
}

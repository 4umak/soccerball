package com.naukma.soccer.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
    private String email;
    private String first_name;
    private String last_name;
    private List<RoleDto> roleDtoList;
}

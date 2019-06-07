package com.naukma.soccer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CountryDto {
    private Integer id;
    private String name;
}

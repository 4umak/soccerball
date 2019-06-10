package com.naukma.soccer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
public class MatchDto {
    private Integer id;
    private String t1_name;
    private String t2_name;
    private String score;
    private Date match_date;
    private String championship;
}

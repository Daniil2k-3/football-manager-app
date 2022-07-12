package com.example.footballmanager.dto.response;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class TeamResponseDto {
    private Long id;
    private String title;
    private BigDecimal budget;
    private Integer commissionPercentage;
    private List<Long> playerIds;
}

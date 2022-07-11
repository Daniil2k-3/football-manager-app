package com.example.footballmanager.dto.request;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class TeamRequestDto {
    private String title;
    private BigDecimal budget;
    private Integer commissionPercentage;
    private List<Long> playerIds;
}

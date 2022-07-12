package com.example.footballmanager.dto.request;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class TeamRequestDto {
    private String title;
    private BigDecimal budget;
    private Integer commissionPercentage;
    private List<Long> playerIds;
}

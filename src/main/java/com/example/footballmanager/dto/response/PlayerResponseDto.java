package com.example.footballmanager.dto.response;

import lombok.Data;

@Data
public class PlayerResponseDto {
    private Long id;
    private String name;
    private Integer age;
    private Integer experienceMonths;
}

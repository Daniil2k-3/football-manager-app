package com.example.footballmanager.mapper.impl;

import com.example.footballmanager.dto.request.PlayerRequestDto;
import com.example.footballmanager.dto.response.PlayerResponseDto;
import com.example.footballmanager.mapper.DtoMapper;
import com.example.footballmanager.model.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerDtoMapper implements DtoMapper<PlayerResponseDto, PlayerRequestDto, Player> {
    @Override
    public PlayerResponseDto toDto(Player player) {
        PlayerResponseDto playerResponseDto = new PlayerResponseDto();
        playerResponseDto.setId(player.getId());
        playerResponseDto.setName(player.getName());
        playerResponseDto.setAge(player.getAge());
        playerResponseDto.setExperienceMonths(player.getExperienceMonths());
        return playerResponseDto;
    }

    @Override
    public Player toModel(PlayerRequestDto requestDto) {
        Player player = new Player();
        player.setName(requestDto.getName());
        player.setAge(requestDto.getAge());
        player.setExperienceMonths(requestDto.getExperienceMonths());
        return player;
    }
}

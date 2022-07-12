package com.example.footballmanager.mapper.impl;

import com.example.footballmanager.dto.request.TeamRequestDto;
import com.example.footballmanager.dto.response.TeamResponseDto;
import com.example.footballmanager.mapper.DtoMapper;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.service.PlayerService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class TeamDtoMapper implements DtoMapper<TeamResponseDto, TeamRequestDto, Team> {
    private final PlayerService playerService;

    public TeamDtoMapper(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public TeamResponseDto toDto(Team team) {
        TeamResponseDto responseDto = new TeamResponseDto();
        responseDto.setId(team.getId());
        responseDto.setTitle(team.getTitle());
        responseDto.setBudget(team.getBudget());
        responseDto.setCommissionPercentage(team.getCommissionPercentage());
        List<Long> list = team.getPlayers()
                .stream()
                .map(Player::getId)
                .collect(Collectors.toList());
        responseDto.setPlayerIds(list);
        return responseDto;
    }

    @Override
    public Team toModel(TeamRequestDto requestDto) {
        Team team = new Team();
        team.setTitle(requestDto.getTitle());
        team.setBudget(requestDto.getBudget());
        team.setCommissionPercentage(requestDto.getCommissionPercentage());
        List<Player> list = requestDto.getPlayerIds()
                .stream()
                .map(playerService::get)
                .collect(Collectors.toList());
        team.setPlayers(list);
        return team;
    }
}

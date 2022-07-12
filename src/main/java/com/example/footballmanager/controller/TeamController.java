package com.example.footballmanager.controller;

import com.example.footballmanager.dto.request.TeamRequestDto;
import com.example.footballmanager.dto.response.TeamResponseDto;
import com.example.footballmanager.mapper.DtoMapper;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.service.TeamService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;
    private final DtoMapper<TeamResponseDto, TeamRequestDto, Team> mapper;

    public TeamController(TeamService teamService,
                          DtoMapper<TeamResponseDto, TeamRequestDto, Team> mapper) {
        this.teamService = teamService;
        this.mapper = mapper;
    }

    @PostMapping
    public TeamResponseDto add(@Valid @RequestBody TeamRequestDto requestDto) {
        return mapper.toDto(teamService.add(mapper.toModel(requestDto)));
    }

    @GetMapping("/{id}")
    public TeamResponseDto get(@PathVariable Long id) {
        return mapper.toDto(teamService.get(id));
    }

    @GetMapping
    public List<TeamResponseDto> getAll(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return teamService.getAll(pageable)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public TeamResponseDto update(@PathVariable Long id, @RequestBody TeamRequestDto requestDto) {
        Team team = mapper.toModel(requestDto);
        team.setId(id);
        return mapper.toDto(teamService.add(team));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        teamService.delete(id);
    }
}

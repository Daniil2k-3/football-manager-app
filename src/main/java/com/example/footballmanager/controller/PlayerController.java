package com.example.footballmanager.controller;

import com.example.footballmanager.dto.request.PlayerRequestDto;
import com.example.footballmanager.dto.response.PlayerResponseDto;
import com.example.footballmanager.mapper.DtoMapper;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.service.PlayerService;
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
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;
    private final DtoMapper<PlayerResponseDto, PlayerRequestDto, Player> mapper;

    public PlayerController(PlayerService playerService,
                            DtoMapper<PlayerResponseDto,
                                    PlayerRequestDto,
                                    Player> mapper) {
        this.playerService = playerService;
        this.mapper = mapper;
    }

    @PostMapping
    public PlayerResponseDto add(@Valid @RequestBody PlayerRequestDto requestDto) {
        return mapper.toDto(playerService.add(mapper.toModel(requestDto)));
    }

    @GetMapping
    public List<PlayerResponseDto> getAll(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return playerService.getAll(pageable)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PlayerResponseDto get(@PathVariable Long id) {
        return mapper.toDto(playerService.get(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        playerService.delete(id);
    }

    @PutMapping("/{id}")
    public PlayerResponseDto update(@PathVariable Long id,
                                    @RequestBody PlayerRequestDto requestDto) {
        Player player = mapper.toModel(requestDto);
        player.setId(id);
        return mapper.toDto(playerService.add(player));
    }
}

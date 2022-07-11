package com.example.footballmanager.service.impl;

import com.example.footballmanager.repository.PlayerRepository;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player add(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player get(Long id) {
        return playerRepository.getReferenceById(id);
    }

    @Override
    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        playerRepository.delete(playerRepository.getReferenceById(id));
    }

    @Override
    public Player update(Player player) {
        return playerRepository.save(player);
    }
}

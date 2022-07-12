package com.example.footballmanager.service.impl;

import com.example.footballmanager.model.Player;
import com.example.footballmanager.repository.PlayerRepository;
import com.example.footballmanager.service.PlayerService;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public List<Player> getAll(Pageable pageable) {
        return playerRepository.findAll(pageable).toList();
    }

    @Override
    public void delete(Long id) {
        playerRepository.delete(playerRepository.getReferenceById(id));
    }
}

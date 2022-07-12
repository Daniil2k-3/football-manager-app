package com.example.footballmanager.service;

import com.example.footballmanager.model.Player;

import java.util.List;

public interface PlayerService {
    Player add(Player player);

    Player get(Long id);

    List<Player> getAll();

    void delete(Long id);
}

package com.example.footballmanager.service;

import com.example.footballmanager.model.Player;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface PlayerService {
    Player add(Player player);

    Player get(Long id);

    List<Player> getAll(Pageable pageable);

    void delete(Long id);
}

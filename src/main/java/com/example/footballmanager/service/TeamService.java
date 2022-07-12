package com.example.footballmanager.service;

import com.example.footballmanager.model.Team;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface TeamService {
    Team add(Team team);

    Team get(Long id);

    List<Team> getAll(Pageable pageable);

    void delete(Long id);
}

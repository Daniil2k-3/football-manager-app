package com.example.footballmanager.service;

import com.example.footballmanager.model.Team;

import java.util.List;

public interface TeamService {
    Team add(Team team);

    Team get(Long id);

    List<Team> getAll();

    void delete(Long id);
}

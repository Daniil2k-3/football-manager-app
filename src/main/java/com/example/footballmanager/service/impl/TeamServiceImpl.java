package com.example.footballmanager.service.impl;

import com.example.footballmanager.model.Team;
import com.example.footballmanager.repository.TeamRepository;
import com.example.footballmanager.service.TeamService;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team add(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team get(Long id) {
        return teamRepository.getReferenceById(id);
    }

    @Override
    public List<Team> getAll(Pageable pageable) {
        return teamRepository.findAll(pageable).toList();
    }

    @Override
    public void delete(Long id) {
        teamRepository.delete(teamRepository.getReferenceById(id));
    }
}

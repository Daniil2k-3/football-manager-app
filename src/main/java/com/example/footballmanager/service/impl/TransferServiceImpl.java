package com.example.footballmanager.service.impl;

import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.repository.PlayerRepository;
import com.example.footballmanager.repository.TeamRepository;
import java.math.BigDecimal;
import com.example.footballmanager.service.TransferService;
import com.example.footballmanager.util.TransferValidator;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {
    private static final double EXPERIENCE_MODIFIER = 100000.0;

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final TransferValidator transferValidator;

    public TransferServiceImpl(PlayerRepository playerRepository,
                               TeamRepository teamRepository,
                               TransferValidator transferValidator) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.transferValidator = transferValidator;
    }

    @Override
    public void transfer(Long playerId, Long teamFromId, Long teamToId) {
        Player player = playerRepository.getReferenceById(playerId);
        Team teamFrom = teamRepository.getReferenceById(teamFromId);
        Team teamTo = teamRepository.getReferenceById(teamToId);
        BigDecimal cost = calculateCost(player, teamFrom);
        transferValidator.validate(cost, teamFrom, teamTo, player);
        teamFrom.setBudget(teamFrom.getBudget().add(cost));
        teamTo.setBudget(teamTo.getBudget().subtract(cost));
        relocatePlayer(teamFrom, teamTo, player);
        teamRepository.save(teamFrom);
        teamRepository.save(teamTo);
    }

    private BigDecimal calculateCost(Player player, Team team) {
        double cost =  player.getExperienceMonths()
                * EXPERIENCE_MODIFIER
                / player.getAge();
        double percent = team.getCommissionPercentage() / 100.0;
        cost += cost * percent;
        return BigDecimal.valueOf(cost);
    }

    private void relocatePlayer(Team teamFrom, Team teamTo, Player player) {
        teamFrom.getPlayers().remove(player);
        teamTo.getPlayers().add(player);
    }
}

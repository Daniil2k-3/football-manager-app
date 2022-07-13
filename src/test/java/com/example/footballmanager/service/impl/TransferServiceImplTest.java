package com.example.footballmanager.service.impl;

import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.repository.PlayerRepository;
import com.example.footballmanager.repository.TeamRepository;
import com.example.footballmanager.service.TransferService;
import com.example.footballmanager.util.TransferValidator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TransferServiceImplTest {
    private static TransferService transferService;
    private static PlayerRepository playerRepository;
    private static TeamRepository teamRepository;
    private Player player;
    private Team team1;
    private Team team2;

    @BeforeAll
    static void beforeAll() {
        playerRepository = Mockito.mock(PlayerRepository.class);
        teamRepository = Mockito.mock(TeamRepository.class);
        TransferValidator transferValidator = new TransferValidator();
        transferService = new TransferServiceImpl(playerRepository,
                teamRepository,
                transferValidator);
    }

    @BeforeEach
    void setUp() {
        player = new Player();
        player.setId(1L);
        player.setName("Bob");
        player.setAge(20);
        team1 = new Team();
        team1.setTitle("Team One");
        List<Player> list1= new ArrayList<>();
        list1.add(player);
        team1.setPlayers(list1);
        team1.setBudget(BigDecimal.valueOf(1));
        team1.setCommissionPercentage(1);
        team2 = new Team();
        team1.setTitle("Team Two");
        List<Player> list2= new ArrayList<>();
        team2.setPlayers(list2);
        team2.setBudget(BigDecimal.valueOf(60601));
        team2.setCommissionPercentage(9);
    }

    @Test
    void validTransferGeneral_Ok() {
        player.setExperienceMonths(12);
        Mockito.when(playerRepository.getReferenceById(1L)).thenReturn(player);
        Mockito.when(teamRepository.getReferenceById(1L)).thenReturn(team1);
        Mockito.when(teamRepository.getReferenceById(2L)).thenReturn(team2);
        transferService.transfer(1L, 1L, 2L);
        Assertions.assertEquals(BigDecimal.valueOf(1.0), team2.getBudget());
        Assertions.assertEquals(BigDecimal.valueOf(60601.0), team1.getBudget());
    }

    @Test
    void validTransferCheckBudgets_Ok() {
        player.setExperienceMonths(12);
        Mockito.when(playerRepository.getReferenceById(1L)).thenReturn(player);
        Mockito.when(teamRepository.getReferenceById(1L)).thenReturn(team1);
        Mockito.when(teamRepository.getReferenceById(2L)).thenReturn(team2);
        transferService.transfer(1L, 1L, 2L);
        Assertions.assertEquals(BigDecimal.valueOf(1.0), team2.getBudget());
        Assertions.assertEquals(BigDecimal.valueOf(60601.0), team1.getBudget());
    }

    @Test
    void validTransferCheckTeams_Ok() {
        player.setExperienceMonths(12);
        Mockito.when(playerRepository.getReferenceById(1L)).thenReturn(player);
        Mockito.when(teamRepository.getReferenceById(1L)).thenReturn(team1);
        Mockito.when(teamRepository.getReferenceById(2L)).thenReturn(team2);
        transferService.transfer(1L, 1L, 2L);
        Assertions.assertEquals(List.of(player), team2.getPlayers());
        Assertions.assertEquals(List.of(), team1.getPlayers());
    }
}
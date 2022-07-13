package com.example.footballmanager.util;

import com.example.footballmanager.exception.TransferRequestException;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;

class TransferValidatorTest {
    private static TransferValidator transferValidator;
    private static Player player1;
    private static Player player2;
    private static Team team1;
    private static Team team2;

    @BeforeAll
    static void beforeAll() {
        transferValidator = new TransferValidator();
        player1 = new Player();
        player1.setId(1L);
        player1.setName("Bob");
        player1.setAge(20);
        player1.setExperienceMonths(18);
        player2 = new Player();
        player2.setId(2L);
        player2.setName("Bill");
        player2.setAge(24);
        player2.setExperienceMonths(28);
        team1 = new Team();
        team1.setPlayers(List.of(player1));
        team2 = new Team();
        team2.setPlayers(List.of(player2));
        team1.setBudget(BigDecimal.valueOf(100));
        team2.setBudget(BigDecimal.valueOf(200));
    }

    @Test
    void validateProperTransfer_Ok() {
        transferValidator.validate(BigDecimal.valueOf(99), team1, team2, player1);
    }

    @Test
    void validateBadTransferNotEnoughMoney_NotOk() {
        Assert.assertThrows(TransferRequestException.class, () -> {
            transferValidator.validate(BigDecimal.valueOf(201), team1, team2, player1);
        });
    }

    @Test
    void validateBadTransferNoPlayer_NotOk() {
        Assert.assertThrows(TransferRequestException.class, () -> {
            transferValidator.validate(BigDecimal.valueOf(199), team1, team2, player2);
        });
    }
}
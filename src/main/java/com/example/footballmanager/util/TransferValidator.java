package com.example.footballmanager.util;

import com.example.footballmanager.exception.TransferException;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class TransferValidator {
    public void validate(BigDecimal cost, Team teamFrom, Team teamTo, Player player) {
        if (teamTo.getBudget().compareTo(cost) < 0) {
            throw new TransferException("Not enough money in receiving team");
        }
        if (!teamFrom.getPlayers().contains(player)) {
            throw new TransferException("No such player in team " + teamFrom.getTitle());
        }
        if (teamTo.getPlayers().contains(player)) {
            throw new TransferException("Player " + player.getName() + " is already in team "
                    + teamTo.getTitle());
        }
    }
}

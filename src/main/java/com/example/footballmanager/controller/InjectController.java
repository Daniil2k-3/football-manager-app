package com.example.footballmanager.controller;

import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.service.PlayerService;
import com.example.footballmanager.service.TeamService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InjectController {
    private final PlayerService playerService;
    private final TeamService teamService;

    public InjectController(PlayerService playerService, TeamService teamService) {
        this.playerService = playerService;
        this.teamService = teamService;
    }

    @GetMapping("/inject")
    public void inject() {
        Player player1 = new Player();
        player1.setAge(29);
        player1.setName("Bob Shevchenko");
        player1.setExperienceMonths(60);
        playerService.add(player1);

        Player player2 = new Player();
        player2.setAge(25);
        player2.setName("John Konoplyanka");
        player2.setExperienceMonths(35);
        playerService.add(player2);

        Player player3 = new Player();
        player3.setAge(29);
        player3.setName("Bill Shovkovskiy");
        player3.setExperienceMonths(48);
        playerService.add(player3);

        Player player4 = new Player();
        player4.setAge(20);
        player4.setName("Stan Aliev");
        player4.setExperienceMonths(12);
        playerService.add(player4);

        Player player5 = new Player();
        player5.setAge(31);
        player5.setName("George Yarmolenko");
        player5.setExperienceMonths(88);
        playerService.add(player5);

        Player player6 = new Player();
        player6.setAge(23);
        player6.setName("Mike Vazovsky");
        player6.setExperienceMonths(35);
        playerService.add(player6);

        Player player7 = new Player();
        player7.setAge(30);
        player7.setName("Sam Beckham");
        player7.setExperienceMonths(55);
        playerService.add(player7);

        Player player8 = new Player();
        player8.setAge(27);
        player8.setName("Rick Ronaldo");
        player8.setExperienceMonths(77);
        playerService.add(player8);

        Player player9 = new Player();
        player9.setAge(35);
        player9.setName("Alex Maradona");
        player9.setExperienceMonths(107);
        playerService.add(player9);

        Player player10 = new Player();
        player10.setAge(25);
        player10.setName("Sam Messi");
        player10.setExperienceMonths(67);
        playerService.add(player10);

        Team team1 = new Team();
        team1.setTitle("Blue team");
        team1.setCommissionPercentage(5);
        team1.setBudget(BigDecimal.valueOf(500000));
        List<Player> blueList = new ArrayList<>();
        blueList.add(player1);
        blueList.add(player2);
        blueList.add(player3);
        blueList.add(player4);
        blueList.add(player5);
        team1.setPlayers(blueList);
        teamService.add(team1);

        Team team2 = new Team();
        team2.setTitle("Red team");
        team2.setCommissionPercentage(7);
        team2.setBudget(BigDecimal.valueOf(580000));
        List<Player> redList = new ArrayList<>();
        redList.add(player6);
        redList.add(player7);
        redList.add(player8);
        redList.add(player9);
        redList.add(player10);
        team2.setPlayers(redList);
        teamService.add(team2);
    }
}

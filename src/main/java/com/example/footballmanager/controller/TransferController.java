package com.example.footballmanager.controller;

import com.example.footballmanager.service.TeamService;
import com.example.footballmanager.service.TransferService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {
    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PutMapping("/transfer")
    public void transfer(@RequestParam Long playerId,
                         @RequestParam Long teamFromId,
                         @RequestParam Long teamToId) {
        transferService.transfer(playerId, teamFromId, teamToId);
    }
}

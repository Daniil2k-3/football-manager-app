package com.example.footballmanager.service;

public interface TransferService {
    void transfer(Long playerId, Long teamFromId, Long teamToId);
}

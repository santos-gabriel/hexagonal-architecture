package com.example.hexagonalarchitecture.application.domain.services;

import com.example.hexagonalarchitecture.application.domain.entities.Client;
import com.example.hexagonalarchitecture.application.ports.outbound.ClientRepository;

import java.util.List;
import java.util.Optional;

public class AllClients {
    private ClientRepository clientRepository;

    public AllClients(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> execute(Optional<Integer> page, Optional<Integer> size) {
        int validPage = page.isPresent() && page.get() >= 0 ? page.get() : 0;
        int validSize = size.isPresent() && size.get() <= 50 && size.get() > 0 ? size.get() : 10;
        return clientRepository.findAll(validPage, validSize);
    }
}

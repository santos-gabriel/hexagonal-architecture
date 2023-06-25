package com.example.hexagonalarchitecture.adapters.outbound.db;

import com.example.hexagonalarchitecture.application.domain.entities.Client;
import com.example.hexagonalarchitecture.application.domain.valueObjects.Email;
import com.example.hexagonalarchitecture.application.ports.outbound.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository {
    @Autowired
    private ClientJpaRepository clientJpaRepository;

    @Override
    public Client save(Client client) {
        return clientJpaRepository.save(client);
    }

    @Override
    public Client findByEmail(Email email) {
        return clientJpaRepository.findByEmail(email);
    }

    @Override
    public List<Client> findAll(int page, int size) {
        Page<Client> clients = clientJpaRepository.findAll(PageRequest.of(page, size));
        return clients.toList();
    }
}

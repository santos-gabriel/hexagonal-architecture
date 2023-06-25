package com.example.hexagonalarchitecture.application.ports.outbound;

import com.example.hexagonalarchitecture.application.domain.entities.Client;
import com.example.hexagonalarchitecture.application.domain.valueObjects.Email;

import java.util.List;

public interface ClientRepository {
    public Client save(Client client);
    public Client findByEmail(Email email);
    public List<Client> findAll(int page, int size);
}

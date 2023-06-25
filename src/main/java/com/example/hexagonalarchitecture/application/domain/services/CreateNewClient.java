package com.example.hexagonalarchitecture.application.domain.services;

import com.example.hexagonalarchitecture.application.domain.entities.Client;
import com.example.hexagonalarchitecture.application.domain.exceptions.EmailAlreadyRegisteredException;
import com.example.hexagonalarchitecture.application.ports.outbound.ClientRepository;

import java.util.Objects;

public class CreateNewClient {
    private ClientRepository clientRepository;

    public CreateNewClient(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public Client execute(Client client) {
        Client clientFromDb = clientRepository.findByEmail(client.getEmail());
        if (Objects.nonNull(clientFromDb)) {
            throw new EmailAlreadyRegisteredException();
        }
        /* TODO
        *   - Validate atributes
        * */
        return clientRepository.save(client);
    }
}

package com.example.hexagonalarchitecture.adapters.inbound.api.dto;

import com.example.hexagonalarchitecture.application.domain.entities.Client;

import java.util.UUID;

public class ClientDTO {
    private UUID id;
    private String name;
    private String email;
    private String cpf;

    public ClientDTO() {}
    public ClientDTO(Client client) {
        this(client.getId(), client.getName().getValue(), client.getEmail().getValue(), client.getCpf().getValue());
    }
    public ClientDTO(String name, String email, String cpf) {
        this(null, name, email, cpf);
    }

    public ClientDTO(UUID id, String name, String email, String cpf) {
        setId(id);
        setName(name);
        setEmail(email);
        setCpf(cpf);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {return email;}
    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Client toClient() {
        return new Client(id, name, email, cpf);
    }

}

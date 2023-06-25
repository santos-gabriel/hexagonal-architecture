package com.example.hexagonalarchitecture.application.domain.entities;

import com.example.hexagonalarchitecture.application.domain.valueObjects.Cpf;
import com.example.hexagonalarchitecture.application.domain.valueObjects.Email;
import com.example.hexagonalarchitecture.application.domain.valueObjects.Name;

import java.util.UUID;

public class Client {
    private UUID id;
    private Name name;
    private Cpf cpf;
    private Email email;

    Client() {}

    public Client(UUID id, String name, String email, String cpf) {
        this(id, new Name(name), new Email(email), new Cpf(cpf));
    }

    public Client(UUID id, Name name, Email email, Cpf cpf) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

    public Client getClient() {return this;}
    public UUID getId() {return this.id;}
    public Name getName() {return this.name;}
    public Email getEmail() {return this.email;}
    public Cpf getCpf() {return this.cpf;}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Client other = (Client) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    public void identifyByCpf() {

    }
    public void register(Name name, Email email) {
        this.name = name;
        this.email = email;
    }
    public boolean validateIdentification() {
        return getCpf().isInvalid() || getName().isInvalid() || getEmail().isInvalid();
    }
}

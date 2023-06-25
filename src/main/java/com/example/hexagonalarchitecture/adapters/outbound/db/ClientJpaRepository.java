package com.example.hexagonalarchitecture.adapters.outbound.db;

import com.example.hexagonalarchitecture.application.domain.entities.Client;
import com.example.hexagonalarchitecture.application.domain.valueObjects.Email;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientJpaRepository extends JpaRepository<Client, UUID> {
    public Client findByEmail(Email email);
    public Page<Client> findAll(Pageable pageable);

}

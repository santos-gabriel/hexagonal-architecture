package com.example.hexagonalarchitecture.adapters.inbound.api;

import com.example.hexagonalarchitecture.adapters.inbound.api.dto.ClientDTO;
import com.example.hexagonalarchitecture.application.domain.entities.Client;
import com.example.hexagonalarchitecture.application.domain.services.AllClients;
import com.example.hexagonalarchitecture.application.domain.services.CreateNewClient;
import com.example.hexagonalarchitecture.application.ports.outbound.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @PostMapping
    public ClientDTO save(@RequestBody ClientDTO clientDTO) {
        CreateNewClient createNewClient = new CreateNewClient(clientRepository);
        Client savedClient = createNewClient.execute(clientDTO.toClient());
        return new ClientDTO(savedClient);
    }

    @GetMapping({"", "/{page}", "/{page}/{size}"})
    public List<ClientDTO> all(@PathVariable("page")Optional<Integer> page, @PathVariable("size")Optional<Integer> size) {
        AllClients allClients = new AllClients(clientRepository);
        List<Client> clients = allClients.execute(page, size);
        Stream<ClientDTO> clientsDTO = clients.stream().map(client -> new ClientDTO(client));
        return clientsDTO.collect(Collectors.toList());
    }
}

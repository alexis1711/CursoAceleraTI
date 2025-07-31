package com.enyoi.ms_clients.service;

import com.enyoi.ms_clients.dto.SaveNewClientDto;
import com.enyoi.ms_clients.model.Client;
import com.enyoi.ms_clients.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client saveNewClient(SaveNewClientDto dto){
        Client client = mapDtoToClient(dto);
        return clientRepository.save(client);
    }

    public Client getClientByEmail(String email){
        return clientRepository.findByEmail(email);
    }


    public Client mapDtoToClient(SaveNewClientDto saveNewClientDto){
        Client client = new Client();
        client.setEmail(saveNewClientDto.getEmail());
        client.setName(saveNewClientDto.getName());
        return client;
    }

}

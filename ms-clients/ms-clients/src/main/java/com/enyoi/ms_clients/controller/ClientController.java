package com.enyoi.ms_clients.controller;

import com.enyoi.ms_clients.dto.SaveNewClientDto;
import com.enyoi.ms_clients.model.Client;
import com.enyoi.ms_clients.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> saveClient(@RequestBody SaveNewClientDto dto){
        Client response = clientService.saveNewClient(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Client> getClientByEmail(@PathVariable("email") String email){
        Client response = clientService.getClientByEmail(email);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

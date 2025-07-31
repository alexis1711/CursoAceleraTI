package com.enyoi.ms_clients.repository;

import com.enyoi.ms_clients.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, String> {
    Client findByEmail(String email);
}

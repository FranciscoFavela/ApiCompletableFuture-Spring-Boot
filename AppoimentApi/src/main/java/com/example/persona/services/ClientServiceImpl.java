package com.example.persona.services;

import com.example.persona.entities.Client;
import com.example.persona.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends BaseServiceImpl<Client,Long> implements ClientService {

    public ClientServiceImpl(BaseRepository<Client, Long> baseRepository) {
        super(baseRepository);
    }
}

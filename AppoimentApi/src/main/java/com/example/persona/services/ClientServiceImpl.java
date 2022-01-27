package com.example.persona.services;

import com.example.persona.entities.Client;
import com.example.persona.repositories.BaseRepository;
import com.example.persona.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends BaseServiceImpl<Client, Long> implements ClientService {

    public ClientServiceImpl(BaseRepository<Client, Long> baseRepository) {
        super(baseRepository);
    }

}

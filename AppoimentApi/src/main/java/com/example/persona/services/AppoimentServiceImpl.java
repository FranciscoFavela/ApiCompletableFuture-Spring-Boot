package com.example.persona.services;

import com.example.persona.entities.Appoiment;
import com.example.persona.repositories.AppoimentRepository;
import com.example.persona.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;


@Service
public class AppoimentServiceImpl extends BaseServiceImpl<Appoiment, Long> implements AppoimentService {

    @Autowired
    private AppoimentRepository appoimentRepository;

    public AppoimentServiceImpl(BaseRepository<Appoiment, Long> baseRepository) {
        super(baseRepository);
    }


    @Override
    public CompletableFuture<List<Appoiment>> pruebaGetall() {
        return CompletableFuture.completedFuture(appoimentRepository.findAll());
    }
}

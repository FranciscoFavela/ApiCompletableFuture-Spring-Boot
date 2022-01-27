package com.example.persona.services;

import com.example.persona.Dtos.AppoimentDto;
import com.example.persona.Dtos.BaseMapperDTO;
import com.example.persona.entities.Appoiment;
import com.example.persona.repositories.AppoimentRepository;
import com.example.persona.repositories.BaseRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;


@Service
public class AppoimentServiceImpl extends BaseServiceImpl<Appoiment, Long> implements AppoimentService {

    @Autowired
    private AppoimentRepository appoimentRepository;
    static BaseMapperDTO baseMapperDTO = BaseMapperDTO.singleInstance();

    public AppoimentServiceImpl(BaseRepository<Appoiment, Long> baseRepository) {
        super(baseRepository);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseServiceImpl.class);

    @Async("taskExecutor")
    @Transactional
    public CompletableFuture<List<AppoimentDto>> getAllDTO(){
        System.out.println("Current Thread" + Thread.currentThread().getName());
        LOGGER.info("Request to Get ALL Dto");
        System.out.println(Thread.currentThread().getName());
        List<Appoiment> entities =appoimentRepository.findAll();
        List<AppoimentDto> dtos = new ArrayList<>();
        for(Appoiment appoiment: entities){
            AppoimentDto appoimentDto;
            appoimentDto = baseMapperDTO.mapToAppoimentDto(appoiment);
            dtos.add(appoimentDto);
        }
        return CompletableFuture.completedFuture(dtos);
    }

    @Async("taskExecutor")
    @Transactional
    public CompletableFuture<AppoimentDto> getOneAppoimentDTO(Long id){
        System.out.println("Current Thread" + Thread.currentThread().getName());
        LOGGER.info("Request to Get OneDto");
        Optional<Appoiment> existingUser = appoimentRepository.findById(id);
        ModelMapper modelMapper = new ModelMapper();
        AppoimentDto userDTO = modelMapper.map(existingUser,AppoimentDto.class);
        return CompletableFuture.completedFuture(userDTO);
    }

    @Async("taskExecutor")
    @Override
    public CompletableFuture<List<Appoiment>> pruebaGetall() {
        System.out.println("Current Thread" + Thread.currentThread().getName());
        LOGGER.info("Request to Get ALL");
        return CompletableFuture.completedFuture(appoimentRepository.findAll());
    }

}

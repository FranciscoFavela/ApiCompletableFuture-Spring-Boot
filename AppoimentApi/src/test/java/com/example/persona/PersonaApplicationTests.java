package com.example.persona;

import com.example.persona.controllers.AppoimentController;
import com.example.persona.controllers.BaseController;
import com.example.persona.controllers.ClientController;
import com.example.persona.entities.Appoiment;
import com.example.persona.entities.Base;
import com.example.persona.entities.Client;
import com.example.persona.repositories.AppoimentRepository;
import com.example.persona.repositories.BaseRepository;
import com.example.persona.repositories.ClientRepository;
import com.example.persona.services.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class PersonaApplicationTests {
/*
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @InjectMocks
    private ClientController clientController;

    @Mock
    private ClientService clientService;

    @Autowired
    private ClientServiceImpl clientServiceImpl;;

    @MockBean
    private ClientRepository clientRepository;

    @BeforeAll
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
    }
    Client c1 = new Client("NAME","LASTNAME",1,"DNI","MAIL",4333);
    Appoiment c2 = new Appoiment("reason",1,1,1,c1);
    List<Appoiment> record = new ArrayList(Arrays.asList(c2));

    @Test
    public void getAllRecords_success() throws Exception {
        List<Client> records = new ArrayList<>(Arrays.asList(c1));

        Mockito.when(clientRepository.findAll()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("http://localhost:9090/api/v1/clients")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", hasSize(1)))
                .andExpect((ResultMatcher) jsonPath("$[2].name", is("NAME")));
    }

    @Test
    public void GetOneByIDTest() {
        int id=1;
        Mockito.when(clientRepository.findById(Long.valueOf(id))).thenReturn(Optional.of((c1)));
        assertEquals(Optional.of(c1),clientRepository.findById(Long.valueOf(id)));
    }

    @Test
    public void PutMappingSucess() throws Exception {

        Mockito.when(clientService.update(null,c1)).thenReturn(c1);

        String content = objectWriter.writeValueAsString(c1);

        System.out.println(content);

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/v1/clients/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.name", is(c1.getName())));
    }
    */
    }

package com.example.persona;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import com.example.persona.controllers.ClientController;
import com.example.persona.entities.Client;
import com.example.persona.services.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(ClientController.class)
class PersonaApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientServiceImpl usrSrv;
    Client mockClient = new Client( "Zamira", "Fonseca", 965, "sda5224", "Zamira@gmail.com", 43310033);
    Client mockClient2  = new Client("Zamira", "Fonseca2", 232, "s1d2d311", "Zamira2@gmail.com", 43310443);

    @Test
    @Description("ASYNC one get Client ")
    public void getUserTest() throws Exception {
        //given
        given(usrSrv.findByIdAsync(Mockito.anyLong()))
                .willReturn(
                        CompletableFuture.<Optional<Client>>completedFuture(Optional.ofNullable(mockClient))
                );
        //when

        ObjectMapper mapr = new ObjectMapper();

        String body = mapr.writeValueAsString(mockClient);

        String expected = "";
        MvcResult response =
                this.mockMvc.perform(get("http://localhost:9090/api/v1/clients/16").accept(MediaType.APPLICATION_JSON) )
                        .andExpect(request().asyncStarted())
                        .andExpect(status().is2xxSuccessful())
                        .andReturn();

        this.mockMvc.perform(asyncDispatch(response))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(body))
        ;
}
    @Test
    @Description("ASYNC save Client ")
    public void saveUserTest() throws Exception {
        //given
        given(usrSrv.save(Mockito.any()))
                .willReturn(
                        CompletableFuture.completedFuture(mockClient)
                );
        //when

        ObjectMapper mapr = new ObjectMapper();

        String body = mapr.writeValueAsString(mockClient);

        String expected = "";
        MvcResult response =
                this.mockMvc.perform(
                                post("http://localhost:9090/api/v1/clients/")
                                        .accept(MediaType.APPLICATION_JSON)
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .content(body)
                        )

                        .andExpect(request().asyncStarted())
                        .andExpect(status().is2xxSuccessful())
                        .andReturn();

        this.mockMvc.perform(asyncDispatch(response))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(body,false ))
        ;


    }
    @Test
    @Description("All Clients")
    public void allUserTest() throws Exception {

        List<Client> all = new ArrayList<Client>();
        all.add(mockClient);
        all.add(mockClient2);

        given(usrSrv.pruebaGetall())
                .willReturn(
                        CompletableFuture.completedFuture(all)
                );
        //when


        String expected = "";

        this.mockMvc.perform(get("http://localhost:9090/api/v1/clients/").accept(MediaType.APPLICATION_JSON) )
                .andDo(print())
                .andExpect(content().string(expected))
                .andExpect(status().is2xxSuccessful())
        ;
        //then

    }

    @Test
    @Description("delete a Client")
    public void delUserTest() throws Exception {


        given(usrSrv.delete(Mockito.anyLong()))
                .willReturn(
                        CompletableFuture.completedFuture(true)
                );
        //when

        String expected = "";
        this.mockMvc.perform(delete("http://localhost:9090/api/v1/clients/52") )
                .andDo(print())
                .andExpect(content().string(expected))
                .andExpect(status().is2xxSuccessful())
        ;
        //then

        }

}

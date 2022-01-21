package com.example.persona.controllers;

import com.example.persona.entities.Client;
import com.example.persona.services.ClientServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/clients")
public class ClientController extends BaseControllerImpl<Client, ClientServiceImpl>{


}

package com.creative.cours.controllers;

import com.creative.cours.models.Client;
import com.creative.cours.repositories.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "client")
public class ClientController {
    @Autowired
    ClientRepo clientRepo;

    @GetMapping(value = "/")
    public List<Client> getAllClients(){
        return clientRepo.findAll();
    }

    @GetMapping(value = "{id}")
    public Client getClientById(@PathVariable Long id){
        Optional<Client> client = clientRepo.findById(id);
        if (client.isPresent())
            return client.get();
        return null;
    }

    @PostMapping(value = "/")
    public void createClient(@RequestBody Client client){
        clientRepo.save(client);
    }
}

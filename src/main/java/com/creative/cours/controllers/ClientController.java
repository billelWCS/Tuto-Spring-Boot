package com.creative.cours.controllers;

import com.creative.cours.models.Client;
import com.creative.cours.repositories.ClientRepo;
import com.creative.cours.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "client")
public class ClientController {
    @Autowired
    ClientService clientService;

//    @GetMapping(value = "/")
//    public ResponseEntity<List<Client>> getAllClients(){
//        return new ResponseEntity<List<Client>>(
//                clientService.get(),
//                HttpStatus.OK
//        );
//    }

//    @GetMapping(value = "{id}")
//    public ResponseEntity<?> getClientById(@PathVariable Long id){
//        Optional<Client> client = clientRepo.findById(id);
//        Map<String, String> body = new HashMap<>();
//        if (client.isPresent())
//            return new ResponseEntity<>(
//                    client.get(),
//                    HttpStatus.OK
//            );
//            body.put("message", "Client not found");
//            return new ResponseEntity<>(
//                    body,
//                    HttpStatus.NOT_FOUND
//            );
//    }

    @PostMapping(value = "/")
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        return new ResponseEntity<Client>(
                clientService.createClient(client),
                HttpStatus.CREATED
        );
    }
}

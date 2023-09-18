package com.creative.cours.services;

import com.creative.cours.models.Client;
import com.creative.cours.repositories.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepo clientRepo;



    public Client createClient(Client client){
        int anneeDeNaiss = client.getAnneeDeNaiss();
        int age = LocalDate.now().getYear() - anneeDeNaiss;
        client.setAge(age);
        return clientRepo.save(client);
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepo.findById(id);
    }

    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }
}

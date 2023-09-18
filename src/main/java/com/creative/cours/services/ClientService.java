package com.creative.cours.services;

import com.creative.cours.models.Client;
import com.creative.cours.repositories.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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
}

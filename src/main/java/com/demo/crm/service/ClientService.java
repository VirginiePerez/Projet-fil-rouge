package com.demo.crm.service;

import com.demo.crm.models.Client;
import com.demo.crm.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;


    public void add(Client c) {
        clientRepository.save(c);
    }


    public List<Client> getAll() {
        return clientRepository.findAll();
    }


    public Optional<Client> findById(Integer id) {
        return clientRepository.findById(id);
    }


    public void update(Client c) {
        clientRepository.save(c);
    }


    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }
}

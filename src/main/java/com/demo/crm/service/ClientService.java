package com.demo.crm.service;
import com.demo.crm.models.Client;
import com.demo.crm.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.demo.crm.models.ClientState.ACTIVE;
import static com.demo.crm.models.ClientState.INACTIVE;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> getById(Integer id) {
        return clientRepository.findById(id);
    }

    public void save(Client client) {
        clientRepository.save(client);
    }

    public void delete(Client client) {
        clientRepository.delete(client);
    }

    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }

    public void update(Client client) {
        clientRepository.save(client);
    }
    public int getClientStateValue(Client client) {
        return client.getState().ordinal();
    }
    }

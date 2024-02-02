package com.demo.crm.controller;

import com.demo.crm.models.Client;
import com.demo.crm.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("clients")
    public List<Client> getAllClients() {
        return clientService.getAll();
    }

    @PostMapping("clients")
    public ResponseEntity<?> save(@RequestBody Client client) {
        List<String> errors = getPostErrors(client);
        if(!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors.toString());
        }
        else {
            clientService.save(client);
            return ResponseEntity.ok(client);
        }
    }

    @GetMapping("clients/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Integer id) {
        Optional<Client> optional = clientService.getById(id);

        if(optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }
        else {
            return ResponseEntity.badRequest().body("No existing client with id " + id + " !");
        }
    }

    @DeleteMapping("clients/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Integer id) {
        Optional<Client> optional = clientService.getById(id);

        if(optional.isPresent()) {
            clientService.delete(optional.get());
            return ResponseEntity.ok("Successfully deleted the client with id " + id + " !");
        }
        else {
            return ResponseEntity.badRequest().body("No existing client with id " + id + " !");
        }
    }


    private List<String> getPostErrors(Client client) {
        List<String> errors = new ArrayList<>();

        if(client.getFirstName() == null || client.getFirstName().isBlank()) {
            errors.add("complete First Name !");
        }

        if(client.getLastName() == null || client.getLastName().isBlank()) {
            errors.add("complete Last Name !");
        }

        if(client.getEmail() == null || client.getEmail().isBlank()) {
            errors.add("complte Email !");
        }

        if(clientService.getAll().stream()
                .anyMatch(c -> client.getEmail().equals(c.getEmail()))) {
            errors.add(" this email address already exists !");
        }

        return errors;
    }

}
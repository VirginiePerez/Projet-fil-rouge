package com.demo.crm.controller;

import com.demo.crm.models.Client;
import com.demo.crm.models.ClientState;
import com.demo.crm.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    ClientService clientService;
    // POST (Created)
    private static final Map<String, ClientState> STATE_MAP = new HashMap<>();

    static {
        STATE_MAP.put("ACTIVE", ClientState.ACTIVE);
        STATE_MAP.put("INACTIVE", ClientState.INACTIVE);}


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Client c) {
        clientService.add(c);
    }

    // GET (Read all)
    @GetMapping
    public List<Client> getList() {
        return clientService.getAll();
    }

    // GET (Read by id)
    @GetMapping("/{id}")
    public ResponseEntity<Client> getById(@PathVariable("id") Integer id) {
        Optional<Client> opt = clientService.findById(id);
        if (opt.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            Client client = opt.get();
            return ResponseEntity.ok(client);
        }
    }

    // PUT (Update)
    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@RequestBody Client client,
                                         @PathVariable("id") Integer id) {
        if (!client.getId().equals(id)) {
            return ResponseEntity.notFound().build();
        } else {
            clientService.update(client);
            return ResponseEntity.ok().build();
        }
    }

    // DELETE (Delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<Client> delete(@PathVariable("id") Integer id) {
        if(clientService.findById(id).isPresent()){
            clientService.delete(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

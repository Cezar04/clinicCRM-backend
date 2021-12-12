package com.crm.clinicCrm.client;

import com.crm.clinicCrm.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/all-clients")
    public List<ClientDAO> getAllClients() {
        return clientService.findAll();
    }

    @GetMapping("/{clientId}")
    public ClientDAO getClient(@PathVariable UUID clientId){
        return clientService.findByClientId(clientId);
    }

    @PostMapping("/add-client")
    private ResponseEntity<?> addClient(@RequestBody ClientDAO clientDAO){
        return clientService.addClient(clientDAO);
    }

}

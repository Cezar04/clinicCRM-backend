package com.crm.clinicCrm.client;

import com.crm.clinicCrm.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
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
        if(clientService.existsEmail(clientDAO.getEmail())){
            return ResponseEntity.badRequest().body("Email is already taken");
        }
        return clientService.addClient(clientDAO);
    }

    @DeleteMapping("/delete/{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable UUID clientId){
        return clientService.deleteClient(clientId);
    }

    @PutMapping("/edit/{clientId}")
    public ResponseEntity<?> updateClient(@RequestBody ClientDAO clientDAO, @PathVariable UUID clientId){
        return clientService.updateClient(clientDAO,clientId);
    }

}

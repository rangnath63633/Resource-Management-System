package com.rms.resourceManagementApplication.controller;

import com.rms.resourceManagementApplication.dto.ClientDTO;
import com.rms.resourceManagementApplication.entity.Client;
import com.rms.resourceManagementApplication.entity.Employee;
import com.rms.resourceManagementApplication.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rms/client")
@RequiredArgsConstructor

public class ClientController {
    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody ClientDTO clientDTO) {
        Client client = clientService.createClient(clientDTO);
        return ResponseEntity.ok(client);
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }

    @GetMapping("/{clientName}")
    public ResponseEntity<Client> findByClientName(@PathVariable String clientName){
        return new ResponseEntity<>(clientService.findByClientName(clientName), HttpStatus.OK);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> findByClientId(@PathVariable Long clientId) {

        return new ResponseEntity<>(clientService.findByClientId(clientId), HttpStatus.OK);
    }
}

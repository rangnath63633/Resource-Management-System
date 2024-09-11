package com.rms.resourceManagementApplication.controller;

import com.rms.resourceManagementApplication.dto.ClientDTO;
import com.rms.resourceManagementApplication.entity.Client;
import com.rms.resourceManagementApplication.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}

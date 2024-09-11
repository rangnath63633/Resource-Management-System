package com.rms.resourceManagementApplication.service;

import com.rms.resourceManagementApplication.Mapper.ClientMapper;
import com.rms.resourceManagementApplication.dto.ClientDTO;
import com.rms.resourceManagementApplication.entity.Client;
import com.rms.resourceManagementApplication.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public Client createClient(ClientDTO clientDTO){
        Client client=clientMapper.toClient(clientDTO);
        return clientRepository.save(client);
    }
}

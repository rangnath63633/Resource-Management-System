package com.rms.resourceManagementApplication.service;

import com.rms.resourceManagementApplication.Mapper.ClientMapper;
import com.rms.resourceManagementApplication.dto.ClientDTO;
import com.rms.resourceManagementApplication.dto.DepartmentDTO;
import com.rms.resourceManagementApplication.entity.Client;
import com.rms.resourceManagementApplication.entity.Department;
import com.rms.resourceManagementApplication.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public Client createClient(ClientDTO clientDTO){
        Client client=clientMapper.toClient(clientDTO);
        return clientRepository.save(client);
    }

    public Client findByClientId(Long clientId) {

        return clientRepository.findById(clientId).orElse(null);
//        return department != null ? getMapper().departmentToDepartmentDTOs(department) : null;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client findByClientName(String clientName){
        return clientRepository.findByClientName(clientName);
    }
}

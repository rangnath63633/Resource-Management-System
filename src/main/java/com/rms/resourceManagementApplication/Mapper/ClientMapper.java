package com.rms.resourceManagementApplication.Mapper;

import com.rms.resourceManagementApplication.dto.ClientDTO;
import com.rms.resourceManagementApplication.entity.Client;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ClientMapper {
    public Client toClient(ClientDTO clientDTO){
        return Client.builder().clientName(clientDTO.getClientName()).build();
    }
}

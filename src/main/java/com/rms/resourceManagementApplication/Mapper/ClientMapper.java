package com.rms.resourceManagementApplication.Mapper;

import com.rms.resourceManagementApplication.dto.ClientDTO;
import com.rms.resourceManagementApplication.dto.DepartmentDTO;
import com.rms.resourceManagementApplication.entity.Client;
import com.rms.resourceManagementApplication.entity.Department;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ClientMapper {
    public Client toClient(ClientDTO clientDTO){
        return Client.builder().clientName(clientDTO.getClientName()).build();
    }

    public ClientDTO clientToClientDTOs(Client client)
    {
        return ClientDTO.builder().clientName(client.getClientName())
                //.employees(department.getEmployees())
                .build();
    }
}

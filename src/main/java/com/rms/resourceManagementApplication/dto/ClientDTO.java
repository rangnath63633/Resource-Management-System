package com.rms.resourceManagementApplication.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDTO {
    private Long clientId;
    private String clientName;
}

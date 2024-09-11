package com.rms.resourceManagementApplication.repository;

import com.rms.resourceManagementApplication.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClientRepository extends JpaRepository<Client, Long> {

}

package com.demo.crm.repositories;


import com.demo.crm.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,  Integer> {

}

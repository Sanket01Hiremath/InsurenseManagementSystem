package com.application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.Model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
}

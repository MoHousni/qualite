package com.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.beans.Client;

public interface ClientDao extends JpaRepository<Client, Long> {

}

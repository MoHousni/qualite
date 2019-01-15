package com.sid.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.beans.Voiture;

public interface VoitureDao extends JpaRepository<Voiture, String> {
	List<Voiture> findByEtat(boolean etat);
}

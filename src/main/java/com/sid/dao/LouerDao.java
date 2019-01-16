package com.sid.dao;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sid.beans.Louer;
import com.sid.beans.Louer_PK;
import com.sid.beans.Voiture;

public interface LouerDao extends JpaRepository<Louer, Louer_PK> {
	
	@Query("select l from Louer l where l.calendrie.dateFin < :x and l.etatDeRent = true")
	public Set<Louer> findOutTimeRent(@Param("x") LocalDate date);
	
	public Set<Louer> findByEtatDeRent(boolean etat);
	
	@Query("select l from Louer l where l.pk.voiture = :x and l.etatDeRent = true")
	public Louer findByEtatDeRentEtVoiture(@Param("x") Voiture voiture);

}

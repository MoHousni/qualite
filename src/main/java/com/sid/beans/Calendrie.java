package com.sid.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Calendrie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private long idCalendrie;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	@OneToMany(mappedBy="calendrie")
	private Set<Louer> locations =new HashSet<>();
	
	
	public Set<Louer> getLocations() {
		return locations;
	}

	public void setLocations(Set<Louer> locations) {
		this.locations = locations;
	}

	public Calendrie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Calendrie(LocalDate dateDebut, LocalDate dateFin) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public long getIdCalendrie() {
		return idCalendrie;
	}

	public void setIdCalendrie(long idCalendrie) {
		this.idCalendrie = idCalendrie;
	}
	
	
	
	
}

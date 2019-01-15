package com.sid.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Agence implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private long idAgence;
	private String adresse;
	private String numeroTele;
	
	@OneToMany(mappedBy="agence")
	private List<Personnel> personnels = new ArrayList<>();
	
	public Agence(long idAgence, String adresse, String numeroTele) {
		super();
		this.idAgence = idAgence;
		this.adresse = adresse;
		this.numeroTele = numeroTele;
	}

	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getIdAgence() {
		return idAgence;
	}

	public void setIdAgence(long idAgence) {
		this.idAgence = idAgence;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNumeroTele() {
		return numeroTele;
	}

	public void setNumeroTele(String numeroTele) {
		this.numeroTele = numeroTele;
	}

	public List<Personnel> getPersonnels() {
		return personnels;
	}

	public void setPersonnels(List<Personnel> personnels) {
		this.personnels = personnels;
	}

	
	
	
}

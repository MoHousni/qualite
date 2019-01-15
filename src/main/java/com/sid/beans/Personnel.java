package com.sid.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Personnel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long IdPersonnel;
private String NomPersonnel;
private String Fonction;

@ManyToOne
@JoinColumn(name="idAgence")
private Agence agence;

public Personnel() {
	super();
	// TODO Auto-generated constructor stub
}

public Personnel(Long idPersonnel, String nomPersonnel, String fonction) {
	super();
	IdPersonnel = idPersonnel;
	NomPersonnel = nomPersonnel;
	Fonction = fonction;
}

public Long getIdPersonnel() {
	return IdPersonnel;
}

public void setIdPersonnel(Long idPersonnel) {
	IdPersonnel = idPersonnel;
}

public String getNomPersonnel() {
	return NomPersonnel;
}

public void setNomPersonnel(String nomPersonnel) {
	NomPersonnel = nomPersonnel;
}

public String getFonction() {
	return Fonction;
}

public void setFonction(String fonction) {
	Fonction = fonction;
}

public Agence getAgence() {
	return agence;
}

public void setAgence(Agence agence) {
	this.agence = agence;
}



}

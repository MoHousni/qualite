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
private Long idPersonnel;
private String nomPersonnel;
private String fonction;

@ManyToOne
@JoinColumn(name="idAgence")
private Agence agence;

public Personnel() {
	super();
	// TODO Auto-generated constructor stub
}

public Personnel(Long idPersonnel, String nomPersonnel, String fonction) {
	super();
	this.idPersonnel = idPersonnel;
	this.nomPersonnel = nomPersonnel;
	this.fonction = fonction;
}

public Long getIdPersonnel() {
	return idPersonnel;
}

public void setIdPersonnel(Long idPersonnel) {
	this.idPersonnel = idPersonnel;
}

public String getNomPersonnel() {
	return nomPersonnel;
}

public void setNomPersonnel(String nomPersonnel) {
	this.nomPersonnel = nomPersonnel;
}

public String getFonction() {
	return fonction;
}

public void setFonction(String fonction) {
	this.fonction = fonction;
}

public Agence getAgence() {
	return agence;
}

public void setAgence(Agence agence) {
	this.agence = agence;
}



}

package com.sid.beans;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Louer_PK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="cniClient")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="matVoiture")
	private Voiture voiture;
	
	
	public Louer_PK(Client client, Voiture voiture) {
		super();
		this.client = client;
		this.voiture = voiture;
	}
	
	public Louer_PK() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Voiture getVoiture() {
		return voiture;
	}
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	
	
}

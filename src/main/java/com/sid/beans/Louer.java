package com.sid.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Louer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Louer_PK pk;
	private double prixTT;
	private int nbrJour;
	private String scanBank;
	private boolean etatDeRent=true; // par ce champ on peut savoir si le client posséde en cour la voiture
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idCalendrie")
	private Calendrie calendrie;
	
	public Louer(Client client, Voiture voiture, double prixTT, int nbrJour, String scanBank) {
		super();
		this.pk = new Louer_PK(client, voiture);
		this.prixTT = prixTT;
		this.nbrJour = nbrJour;
		this.scanBank = scanBank;
	}

	public Louer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Louer_PK getPk() {
		return pk;
	}

	public void setPk(Louer_PK pk) {
		this.pk = pk;
	}

	public double getPrixTT() {
		return prixTT;
	}

	public void setPrixTT(double prixTT) {
		this.prixTT = prixTT;
	}

	public int getNbrJour() {
		return nbrJour;
	}

	public void setNbrJour(int nbrJour) {
		this.nbrJour = nbrJour;
	}

	public String getScanBank() {
		return scanBank;
	}

	public void setScanBank(String scanBank) {
		this.scanBank = scanBank;
	}
	
	public Client getClient() {
		return this.pk.getClient();
	}
	public void setClient(Client client) {
		this.pk.setClient(client);
	}
	public Voiture getVoiture() {
		return this.pk.getVoiture();
	}
	public void setVoiture(Voiture voiture) {
		this.pk.setVoiture(voiture);
	}

	public Calendrie getCalendrie() {
		return calendrie;
	}

	public void setCalendrie(Calendrie calendrie) {
		this.calendrie = calendrie;
	}

	public boolean isEtatDeRent() {
		return etatDeRent;
	}

	public void setEtatDeRent(boolean etatDeRent) {
		this.etatDeRent = etatDeRent;
	}
	
	
}

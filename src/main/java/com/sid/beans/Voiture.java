package com.sid.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Voiture implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String matVoiture;
	private String model;
	private String carburant;
	private String boiteVitesse;
	private String nomVoiture;
	private double prix;
	private double prixParJour;
	private boolean etat;
	private String image;
	
	@JsonIgnore
	@OneToMany(mappedBy="pk.voiture")
	private List<Louer> locations = new ArrayList<>();
	
	
	public Voiture(String matVoiture, String model, String carburant, String boiteVitesse, String nomVoiture, double prix,
			double prixParJour, boolean etat, String image) {
		super();
		this.matVoiture = matVoiture;
		this.model = model;
		this.carburant = carburant;
		this.boiteVitesse = boiteVitesse;
		this.nomVoiture = nomVoiture;
		this.prix = prix;
		this.prixParJour = prixParJour;
		this.etat = etat;
		this.image = image;
	}
	
	public Voiture() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getMatVoiture() {
		return matVoiture;
	}
	
	public void setMatVoiture(String matVoiture) {
		this.matVoiture = matVoiture;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getCarburant() {
		return carburant;
	}
	
	public void setCarburant(String carburant) {
		this.carburant = carburant;
	}
	
	public String getBoiteVitesse() {
		return boiteVitesse;
	}
	
	public void setBoiteVitesse(String boiteVitesse) {
		this.boiteVitesse = boiteVitesse;
	}
	
	public String getNomVoiture() {
		return nomVoiture;
	}
	
	public void setNomVoiture(String nomVoiture) {
		this.nomVoiture = nomVoiture;
	}
	
	public double getPrix() {
		return prix;
	}
	
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public double getPrixParJour() {
		return prixParJour;
	}
	
	public void setPrixParJour(double prixParJour) {
		this.prixParJour = prixParJour;
	}
	
	public boolean isEtat() {
		return etat;
	}
	
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public List<Louer> getLocations() {
		return locations;
	}
	
	public void setLocations(List<Louer> locations) {
		this.locations = locations;
	}
	

}

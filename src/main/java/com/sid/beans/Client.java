package com.sid.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long cinClt;
	private String nomClt;
	private String villeClt;
	private String telClt;
	private String scanId;
	
	@JsonIgnore
	@OneToMany(mappedBy="pk.client")
	private List<Louer> locations = new ArrayList<>();
	
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Client(long cinClt, String nomClt, String villeClt, String telClt, String scanId) {
		super();
		this.cinClt = cinClt;
		this.nomClt = nomClt;
		this.villeClt = villeClt;
		this.telClt = telClt;
		this.scanId = scanId;
	}
	
	public long getCinClt() {
		return cinClt;
	}
	
	public void setCinClt(long cinClt) {
		this.cinClt = cinClt;
	}
	
	public String getNomClt() {
		return nomClt;
	}
	
	public void setNomClt(String nomClt) {
		this.nomClt = nomClt;
	}
	
	public String getVilleClt() {
		return villeClt;
	}
	
	public void setVilleClt(String villeClt) {
		this.villeClt = villeClt;
	}
	
	public String getTelClt() {
		return telClt;
	}
	
	public void setTelClt(String telClt) {
		this.telClt = telClt;
	}
	
	public String getScanId() {
		return scanId;
	}
	
	public void setScanId(String scanId) {
		this.scanId = scanId;
	}
	
	public List<Louer> getLocations() {
		return locations;
	}
	
	public void setLocations(List<Louer> locations) {
		this.locations = locations;
	}
	

}

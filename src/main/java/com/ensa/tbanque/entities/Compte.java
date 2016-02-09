package com.ensa.tbanque.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Compte implements Serializable{
	@Id
	@GeneratedValue
	private Long idCompte;
	private String dateCreation;
	private double solde;
	
	//Gestion Des Relations
	@ManyToOne
	private Client client;
	@OneToMany(mappedBy = "compte")
	private Collection<Transaction> tansaction;
	
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(String  dateCreation, double solde) {
		super();
		this.dateCreation = dateCreation;
		this.solde = solde;
	}
	
	
	public Compte(double solde) {
		super();
		this.solde = solde;
	}
	public Long getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Collection<Transaction> getOperations() {
		return tansaction;
	}
	public void setOperations(Collection<Transaction> operations) {
		if(operations ==null)
			operations = new ArrayList<Transaction>();
		this.tansaction = operations;
	}

	
	
	

}

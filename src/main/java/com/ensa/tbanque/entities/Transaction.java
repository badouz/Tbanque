package com.ensa.tbanque.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transaction implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long idOp;
	private String datetransaction;
	private double montant;
	private boolean statut;
	private String DTYPE;
	
	public String getDTYPE() {
		return DTYPE;
	}
	public void setDTYPE(String dTYPE) {
		DTYPE = dTYPE;
	}
	//Gestion Des Relations
	@ManyToOne
	private Compte compte;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(String dateOperation, double montant, boolean statut) {
		super();
		this.datetransaction = dateOperation;
		this.montant = montant;
		this.statut = statut;
	}
	
	
	public Transaction(double montant, boolean statut) {
		super();
		this.montant = montant;
		this.statut = statut;
	}
	public Long getIdOp() {
		return idOp;
	}
	public void setIdOp(Long idOp) {
		this.idOp = idOp;
	}
	public String getdatetransaction() {
		return datetransaction;
	}
	public void setdatetransaction(String dateOperation) {
		this.datetransaction = dateOperation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public boolean isStatut() {
		return statut;
	}
	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}


	
	

}

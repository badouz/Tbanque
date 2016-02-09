package com.ensa.tbanque.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import com.ensa.tbanque.entities.*;



@Entity
public class Clients implements Serializable {

	@Id
	@GeneratedValue
	private Long idPersonne;
	private String nomPersonne;
	private String prenomPersonne;

	// Gestion Des Relations
	@OneToOne
	private User user;

	public Clients() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Clients(String nomPersonne, String prenomPersonne,
			String telePersonne, String adressePersonne, String emailPersonne) {
		super();
		this.nomPersonne = nomPersonne;
		this.prenomPersonne = prenomPersonne;
	}

	public Long getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(Long idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getNomPersonne() {
		return nomPersonne;
	}

	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}

	public String getPrenomPersonne() {
		return prenomPersonne;
	}

	public void setPrenomPersonne(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Personne [idPersonne=" + idPersonne + ", nomPersonne="
				+ nomPersonne + ", prenomPersonne=" + prenomPersonne
								+ ", user=" + user + "]";
	}

	
	
}

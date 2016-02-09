package com.ensa.tbanque.dao;

import java.util.List;

import com.ensa.tbanque.entities.Client;
import com.ensa.tbanque.entities.Compte;

import com.ensa.tbanque.entities.Transaction;
import com.ensa.tbanque.entities.Clients;
import com.ensa.tbanque.entities.Role;
import com.ensa.tbanque.entities.User;

public interface IBanqueDao {
	
	//Gestion Des Clientss
	public Clients getClientsById(Long idClients);
	public List<Clients> getAllClients();



	public Client getClientById(Long idClient);
	public List<Client> getClients();
	public List<Client> consultClients(String keyWord);


	


	public void updateAccount(Compte c);
	public void deleteAccount(Long idCompte);
	public Compte getAccountById(Long idCompte);
	public List<Compte> getAccountsByClient(Long idClient);
	public List<Compte> getAccountsByEmpl(Long idEmpl);
	public List<Compte> getAllAccount();
	

	public Transaction addTransaction(Transaction op, Long idCompte);
	public void updateTransaction(Transaction op);
	public Transaction getTransactionById(Long idOp);
	public List<Transaction> getTransactionsByClient(Long idClient);
	public List<Transaction> getTransactionsByAccount(Long idCompte);
	public List<Transaction> getTransactionsByEmployee(Long idEmpl);
	public List<Transaction> getTransactionsByFailed(Long idCompte );
	public List<Transaction> getAllTransactions();
	public List<Transaction> getAllTransactionsByFailed();
	
	//Gestion Des Roles
	public void attributeRole(String name, Long userID);
	public Role getRoleByRoleName(String roleName);
	public Role getRoleById(Long idRole);
	public List<Role> getRolesByUser(Long idUser);
	public List<Role> getAllRoles();

	public User addUser(User u);
	public User getUserById(Long idUser);
	public User getUserByClients(Long idClients);
	public Clients getClientsByUser(Long idUser);
	public User getUserByUserName(String name);

}

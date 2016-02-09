package com.ensa.tbanque.service;

import java.util.List;

import com.ensa.tbanque.entities.Client;
import com.ensa.tbanque.entities.Compte;
import com.ensa.tbanque.entities.Transaction;
import com.ensa.tbanque.entities.Clients;
import com.ensa.tbanque.entities.Role;
import com.ensa.tbanque.entities.User;

public interface IBanqueService {
	
	
	

		public Clients readClientsById(Long idClients);
		public List<Clients> readAllClients();

		
		

		public Client readClientById(Long idClient);
		public List<Client> readClients();
		public List<Client> readClientsByKeyWord(String keyWord);

		
	
		

		
		

		public Compte readAccountById(Long idCompte);
		public List<Compte> readAccountsByClient(Long idClient);
		public List<Compte> readAccountsByEmpl(Long idEmpl);
		public List<Compte> readAllAccount();
		

		public Transaction saveTransaction(Transaction op, Long idCompte);
		public void mergeTransaction(Transaction op);
		public void removeTransaction(Long idOp);
		public Transaction readTransactionById(Long idOp);
		public List<Transaction> readTransactionsByClient(Long idClient);
		public List<Transaction> readTransactionsByAccount(Long idCompte);
		public List<Transaction> readTransactionsByEmployee(Long idEmpl);
		public List<Transaction> readTransactionsByFailed(Long idCompte );
		public List<Transaction> readAllTransactions();
		
		public List<Transaction> readAllTransactionsByFailed();
		

		public Role saveRole(Role r);
		public void attributRole(String name, Long userID);
		public Role readRoleByRoleName(String roleName);
		public Role readRoleById(Long idRole);
		public void removeRole(Long idRole);
		public List<Role> readRolesByUser(Long idUser);
		public List<Role> readAllRoles();
		


		public User readUserById(Long idUser);
		public User readUserByClients(Long idClients);
		public Clients readClientsByUser(Long idUser);
		public User readUserByUserName(String name);
	
	
	

	
	

}

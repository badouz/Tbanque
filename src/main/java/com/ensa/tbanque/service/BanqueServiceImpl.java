package com.ensa.tbanque.service;

import java.util.List;

import com.ensa.tbanque.dao.IBanqueDao;
import com.ensa.tbanque.entities.Client;
import com.ensa.tbanque.entities.Compte;
import com.ensa.tbanque.entities.Transaction;
import com.ensa.tbanque.entities.Clients;
import com.ensa.tbanque.entities.Role;
import com.ensa.tbanque.entities.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("banqueService")
@Transactional
public class BanqueServiceImpl implements IBanqueService {

	@Autowired
	public IBanqueDao dao;


	@Override
	public Clients readClientsById(Long idClients) {
		// TODO Auto-generated method stub
		return dao.getClientsById(idClients);
	}

	@Override
	public List<Clients> readAllClients() {
		// TODO Auto-generated method stub
		return dao.getAllClients();
	}


	@Override
	public Client readClientById(Long idClient) {
		// TODO Auto-generated method stub
		return dao.getClientById(idClient);
	}

	@Override
	public List<Client> readClients() {
		// TODO Auto-generated method stub
		return dao.getClients();
	}

	@Override
	public List<Client> readClientsByKeyWord(String keyWord) {
		// TODO Auto-generated method stub
		return dao.consultClients(keyWord);
	}








	@Override
	public Compte readAccountById(Long idCompte) {
		// TODO Auto-generated method stub
		return dao.getAccountById(idCompte);
	}

	@Override
	public List<Compte> readAccountsByClient(Long idClient) {
		// TODO Auto-generated method stub
		return dao.getAccountsByClient(idClient);
	}

	@Override
	public List<Compte> readAllAccount() {
		// TODO Auto-generated method stub
		return dao.getAllAccount();
	}

	@Override
	public Transaction saveTransaction(Transaction op, Long idCompte) {
		// TODO Auto-generated method stub
		return dao.addTransaction(op, idCompte);
	}

	@Override
	public void mergeTransaction(Transaction op) {
		// TODO Auto-generated method stub
		dao.updateTransaction(op);
	}

	@Override
	public void removeTransaction(Long idOp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Transaction readTransactionById(Long idOp) {
		// TODO Auto-generated method stub
		return dao.getTransactionById(idOp);
	}

	@Override
	public List<Transaction> readTransactionsByClient(Long idClient) {
		// TODO Auto-generated method stub
		return dao.getTransactionsByClient(idClient);
	}

	@Override
	public List<Transaction> readTransactionsByAccount(Long idCompte) {
		// TODO Auto-generated method stub
		return dao.getTransactionsByAccount(idCompte);
	}

	@Override
	public List<Transaction> readTransactionsByEmployee(Long idEmpl) {
		// TODO Auto-generated method stub
		return dao.getTransactionsByEmployee(idEmpl);
	}

	@Override
	public List<Transaction> readTransactionsByFailed(Long idCompte) {
		// TODO Auto-generated method stub
		return dao.getTransactionsByFailed(idCompte);
	}

	@Override
	public List<Transaction> readAllTransactions() {
		// TODO Auto-generated method stub
		return dao.getAllTransactions();
	}



	@Override
	public void attributRole(String name, Long userID) {
		// TODO Auto-generated method stub
		dao.attributeRole(name, userID);
	}

	@Override
	public Role readRoleByRoleName(String roleName) {
		// TODO Auto-generated method stub
		return dao.getRoleByRoleName(roleName);
	}

	@Override
	public Role readRoleById(Long idRole) {
		// TODO Auto-generated method stub
		return dao.getRoleById(idRole);
	}



	@Override
	public List<Role> readRolesByUser(Long idUser) {
		// TODO Auto-generated method stub
		return dao.getRolesByUser(idUser);
	}

	@Override
	public List<Role> readAllRoles() {
		// TODO Auto-generated method stub
		return dao.getAllRoles();
	}


	@Override
	public User readUserById(Long idUser) {
		// TODO Auto-generated method stub
		return dao.getUserById(idUser);
	}


	@Override
	public User readUserByClients(Long idClients) {
		// TODO Auto-generated method stub
		return dao.getUserByClients(idClients);
	}

	@Override
	public Clients readClientsByUser(Long idUser) {
		// TODO Auto-generated method stub
		return dao.getClientsByUser(idUser);
	}

	@Override
	public User readUserByUserName(String name) {
		// TODO Auto-generated method stub
		return dao.getUserByUserName(name);
	}

	@Override
	public List<Compte> readAccountsByEmpl(Long idEmpl) {
		// TODO Auto-generated method stub
		return dao.getAccountsByEmpl(idEmpl);
	}

	@Override
	public List<Transaction> readAllTransactionsByFailed() {
		// TODO Auto-generated method stub
		return dao.getAllTransactionsByFailed();
	}

	@Override
	public Role saveRole(Role r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeRole(Long idRole) {
		// TODO Auto-generated method stub
		
	}



}

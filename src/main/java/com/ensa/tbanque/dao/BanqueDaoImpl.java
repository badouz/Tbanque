package com.ensa.tbanque.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.ensa.tbanque.entities.Clients;
import com.ensa.tbanque.utilities.IApplicationManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ensa.tbanque.entities.Client;
import com.ensa.tbanque.entities.Compte;
import com.ensa.tbanque.entities.Transaction;
import com.ensa.tbanque.entities.Role;
import com.ensa.tbanque.entities.User;

@Repository("banqueDao")
public class BanqueDaoImpl implements IBanqueDao {

	// @PersistenceContext
	// private EntityManager em;

	@Autowired
	public IApplicationManager managementUtil;
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Clients getClientsById(Long idPersonne) {
		// TODO Auto-generated method stub
		return (Clients) getSession().get(Clients.class, idPersonne);
	}

	public List<Clients> getAllClients() {
		return getSession().createQuery("from Clients p").list();
	}

	@Override
	public Client getClientById(Long idClient) {
		return (Client) getSession().get(Client.class, idClient);
	}

	@Override
	public List<Client> getClients() {
		return getSession().createQuery("from Client").list();
	}

	@Override
	public List<Client> consultClients(String keyWord) {
		Query req = (Query) getSession()
				.createQuery(
						"select c from Client c where c.nomPersonne like :x or c.prenomPersonne like :x  or c.emailPersonne like :x");
		req.setParameter("x", "%" + keyWord + "%");
		return req.list();
	}







	@Override
	public void updateAccount(Compte c) {
		getSession().update(c);
	}



	@Override
	public Compte getAccountById(Long idCompte) {
		return (Compte) getSession().get(Compte.class, idCompte);
	}

	@Override
	public List<Compte> getAccountsByClient(Long idClient) {
		Query req = (Query) getSession().createQuery(
				"select c from Compte c where c.client.idPersonne = :x");
		req.setParameter("x", idClient);
		return req.list();
	}

	@Override
	public List<Compte> getAccountsByEmpl(Long idEmpl) {
		Query req = (Query) getSession().createQuery(
				"select c from Compte c where c.employe.idPersonne = :x order by c.idCompte desc");
		req.setParameter("x", idEmpl);
		return req.list();
	}

	@Override
	public List<Compte> getAllAccount() {
		Query req = (Query) getSession().createQuery("select c from Compte c order by c.idCompte desc");
		return req.list();
	}


	@Override
	public Transaction addTransaction(Transaction op, Long idCompte) {
		Compte cp = getAccountById(idCompte);
			String formatedDate = managementUtil.dateCaster(new Date());
		op.setdatetransaction(formatedDate);
		op.setCompte(cp);
		getSession().persist(op);
		return op;
	}

	@Override
	public void updateTransaction(Transaction op) {
		getSession().merge(op);

	}


	@Override
	public Transaction getTransactionById(Long idOp) {
		return (Transaction) getSession().get(Transaction.class, idOp);
	}

	@Override
	public List<Transaction> getTransactionsByClient(Long idClient) {
		Query req = getSession()
				.createQuery(
						"select o from Transaction o where o.compte.client.idPersonne = :x ");
		req.setParameter("x", idClient);
		return req.list();
	}

	@Override
	public List<Transaction> getTransactionsByAccount(Long idCompte) {
		Query req = getSession()
				.createQuery(
						"select o from Transaction o where o.compte.idCompte = :x order by o.idOp desc");
		req.setParameter("x", idCompte);
		return req.list();
	}

	@Override
	public List<Transaction> getTransactionsByEmployee(Long idEmpl) {
		Query req = getSession().createQuery(
				"select o from Transaction o where o.employe.idPersonne = :x order by o.idOp desc");
		req.setParameter("x", idEmpl);
		return req.list();
	}

	@Override
	public List<Transaction> getAllTransactions() {
		Query req = getSession().createQuery("select o from Transaction o order by o.idOp desc");
		return req.list();
	}

	@Override
	public List<Transaction> getTransactionsByFailed(Long idCompte) {
		Query req = getSession()
				.createQuery(
						"select o from Transaction o where o.compte.idCompte = :x and o.statut=:y order by o.idOp");
		req.setParameter("x", idCompte);
		req.setParameter("y", false);
		return req.list();
		
	}
	
	
	@Override
	public List<Transaction> getAllTransactionsByFailed() {
		Query req = getSession()
				.createQuery(
						"select o from Transaction o where  o.statut=:y order by o.idOp");
		req.setParameter("y", false);
		return req.list();
	}


	@Override
	public List<Role> getAllRoles() {
		Query req = getSession().createQuery("select r from Role r ");
		return req.list();
	}






	@Override
	public List<Role> getRolesByUser(Long idUser) {
		Query req = getSession().createQuery(
				"select roles from User u where u.idUser = :x");
		req.setParameter("x", idUser);
		return req.list();
	}

	@Override
	public Role getRoleById(Long idRole) {
		return (Role) getSession().get(Role.class, idRole);
	}

	@Override
	public Role getRoleByRoleName(String roleName) {
		Query req = getSession().createQuery(
				"select r from Role r where r.roleName = :x");
		req.setParameter("x", roleName);
		return (Role) req.list().get(0);
	}

	@Override
	public User addUser(User u) {
		getSession().persist(u);
		return u;
	}

	@Override
	public User getUserById(Long idUser) {
		// TODO Auto-generated method stub
		return (User) getSession().get(User.class, idUser);
	}



	@Override
	public User getUserByClients(Long idPersonne) {
		Query req = getSession().createQuery(
				"select user from Clients p where p.idPersonne = :x");
		req.setParameter("x", idPersonne);
		return (User) req.list().get(0);
	}

	@Override
	public Clients getClientsByUser(Long idUser) {
		Query req = getSession().createQuery(
				"select p from Clients p where p.user.idUser = :x");
		req.setParameter("x", idUser);
		return (Clients) req.list().get(0);
	}

	@Override
	public User getUserByUserName(String name) {
		Query req = getSession().createQuery(
				"select u from User u where u.userName = :x");
		req.setParameter("x", name);
		return (User) req.list().get(0);
	}

	@Override
	public void deleteAccount(Long idCompte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeRole(String name, Long userID) {
		// TODO Auto-generated method stub
		
	}




}

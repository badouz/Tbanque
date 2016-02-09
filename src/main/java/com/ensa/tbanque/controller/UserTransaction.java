package com.ensa.tbanque.controller;

import java.util.List;

import com.ensa.tbanque.entities.Client;
import com.ensa.tbanque.entities.Compte;
import com.ensa.tbanque.entities.Transaction;
import com.ensa.tbanque.service.IBanqueService;
import com.ensa.tbanque.utilities.Filecontrole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserTransaction {

	@Autowired
	public IBanqueService service;

	
	@RequestMapping(value = "/transaction")
	public String transactionClient(Model model) {
		User userS = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String name = userS.getUsername();
		com.ensa.tbanque.entities.User user = service
				.readUserByUserName(name);
		Client c = service.readClientById(service.readClientsByUser(
				user.getIdUser()).getIdPersonne());
		
		Compte cpt = service.readAccountsByClient(c.getIdPersonne()).get(
				0);
		return "user/transaction";
	}

	@RequestMapping(value = "/retrait")
	public String retraitClient(Model model,@RequestParam("montant") String montant,@RequestParam(required = false) String retracted) {
		User userS = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String name = userS.getUsername();
		com.ensa.tbanque.entities.User user = service
				.readUserByUserName(name);
		Client c = service.readClientById(service.readClientsByUser(
				user.getIdUser()).getIdPersonne());
		
		Compte cpt = service.readAccountsByClient(c.getIdPersonne()).get(
				0);
		 boolean rec;
		if (retracted == null) 
			rec= true;
		else{
			
			rec = false;
						
		}
		Filecontrole fc = new Filecontrole();
		Transaction t=new Transaction() ;
	
		t.setMontant(Integer.parseInt(montant));
		t.setStatut(rec);
		t.setDTYPE("Retrait");
		service.saveTransaction(t, user.getIdUser());
		System.out.println("**************////////****************"+ t.getIdOp());
		fc.addInFile(t);
		
		List<Transaction> ops = service.readTransactionsByAccount(
				cpt.getIdCompte()).subList(0, 5);
		List<Transaction> failedOps = service.readTransactionsByFailed(cpt
				.getIdCompte());
		model.addAttribute("solde", cpt.getSolde());
		model.addAttribute("operations", ops);
		model.addAttribute("nom", c.getNomPersonne());
		
		float retractc=0;
		for(Transaction ooo:failedOps){
			retractc+=ooo.getMontant();
						}
		model.addAttribute("cashR", retractc);
			
			
	
		return "user/home";
	}
	
	
	
	@RequestMapping(value = "/versement")
	public String versementclient(Model model,@RequestParam("montant") String montant) {
		User userS = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String name = userS.getUsername();
		com.ensa.tbanque.entities.User user = service
				.readUserByUserName(name);
		Client c = service.readClientById(service.readClientsByUser(
				user.getIdUser()).getIdPersonne());
		
		Compte cpt = service.readAccountsByClient(c.getIdPersonne()).get(
				0);
		
	Transaction t=new Transaction() ;

	t.setMontant(Integer.parseInt(montant));
	t.setStatut(true);
	t.setDTYPE("Versement");
	service.saveTransaction(t, user.getIdUser());

	List<Transaction> ops = service.readTransactionsByAccount(
			cpt.getIdCompte()).subList(0, 5);
	List<Transaction> failedOps = service.readTransactionsByFailed(cpt
			.getIdCompte());
	model.addAttribute("solde", cpt.getSolde());
	model.addAttribute("operations", ops);
	model.addAttribute("nom", c.getNomPersonne());
	
	float retractc=0;
	for(Transaction ooo:failedOps){
		retractc+=ooo.getMontant();
					}
	model.addAttribute("cashR", retractc);
			
	
	return "user/home";
	}

	

}
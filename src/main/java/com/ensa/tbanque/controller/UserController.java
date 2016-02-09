package com.ensa.tbanque.controller;

import java.util.List;
import com.ensa.tbanque.entities.Client;
import com.ensa.tbanque.entities.Compte;
import com.ensa.tbanque.entities.Transaction;
import com.ensa.tbanque.service.IBanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	public IBanqueService service;

	
	@RequestMapping(value = "/home")
	public String homeClient(Model model) {
		User userS = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String name = userS.getUsername();
		com.ensa.tbanque.entities.User user = service
				.readUserByUserName(name);
		Client c = service.readClientById(service.readClientsByUser(
				user.getIdUser()).getIdPersonne());
		
		Compte cpt = service.readAccountsByClient(c.getIdPersonne()).get(
				0);
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
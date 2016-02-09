package com.ensa.tbanque.controller;

import java.util.List;
import com.ensa.tbanque.entities.Client;
import com.ensa.tbanque.entities.Compte;
import com.ensa.tbanque.entities.Transaction;
import com.ensa.tbanque.model.BanqueForm;
import com.ensa.tbanque.service.IBanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IBanqueService service;
	

	@RequestMapping(value = "/home")
	public String gettransactions(Model model) {
		User userS = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String name = userS.getUsername();
		List<Transaction> opts1 = service.readAllTransactions();
		float retractc=0;
		for(Transaction ooo:opts1){
			if (!ooo.isStatut())
			retractc+=ooo.getMontant();
						}
		model.addAttribute("allTransactions", opts1);
		model.addAttribute("cashR", retractc);
		model.addAttribute("nom", name);
		return "admin/home";
	}
	
	
	
	
	

	public BanqueForm chargerCpte(BanqueForm bf, Long idCli) {
		try {
			
			Client c = service.readClientById(idCli);
			System.out.println(c.getNomPersonne()+"*********************************************");
			Compte cpt = service.readAccountsByClient(idCli).get(0);
			List<Transaction> ops = service.readTransactionsByAccount(cpt.getIdCompte());
			bf.setClient(c);
			bf.setCompte(cpt);
			bf.setOperations(ops);
			// int pos = bf.getNbLignes() * bf.getPage();
			// List<Operation> ops = metier.consulterOperations(bf.getCode(),
			// pos,
			// bf.getNbLignes());
			// bf.setOperations(ops);
			// long nbOp = metier.getNombreOperations(bf.getCode());
			// bf.setNombrePages((int) (nbOp / bf.getNbLignes()) + 1);
		} catch (Exception e) {
			bf.setException(e.getMessage());
		}
		return bf;
	}

}

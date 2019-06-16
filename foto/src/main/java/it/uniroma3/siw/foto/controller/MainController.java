package it.uniroma3.siw.foto.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.siw.foto.model.Dipendente;
import it.uniroma3.siw.foto.service.DipendenteService;
import it.uniroma3.siw.foto.service.FotografoService;

@Controller
public class MainController {
	
	@Autowired
	private DipendenteService dipendenteService;
	
	@Autowired
	private FotografoService fotografoService;
	
	@RequestMapping("/")
	public String getFotografi(Model model) {
		model.addAttribute("fotografi", fotografoService.tutti());
		return "fotografi.html";
	}


	@RequestMapping("/login")
	public String loginDipendente() {
		return "dipendenteLogin";
	}

	@RequestMapping("/accedi")
	public String accedi(Model model,HttpSession session) {
		
		//accedo all'email del dipendente
		UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email = details.getUsername();
		
		//trovo e metto in sessione l'oggetto dipendente
		Dipendente dipendenteCorrente = this.dipendenteService.getDipendentePerEmail(email);
        session.setAttribute("dipendenteCorrente", dipendenteCorrente);
        
        model.addAttribute("fotografi", this.fotografoService.tutti());
		return "fotografi";
	}
	
	
}

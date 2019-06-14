package it.uniroma3.siw.foto.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.uniroma3.siw.foto.model.Fotografia;
import it.uniroma3.siw.foto.model.Richiesta;
import it.uniroma3.siw.foto.service.RichiestaService;

@Controller
@SessionAttributes("richiesta")
public class RichiestaController {

	@Autowired
	private RichiestaService richiestaService;

	@Autowired
	private RichiestaValidator richiestaValidator;

	@Autowired
	private Carrello carrello;

	@RequestMapping(value = "/richiesta", method = RequestMethod.POST)
	public String newRichiesta(@Valid @ModelAttribute("richiesta") Richiesta richiesta, Model model,
			BindingResult bindingResult) {
		// controllo se la richiesta è valida:
		// se è valida lo mando alla conferma per la persistenza nel db
		// se non è valida lo rimando alla pagina di richiestaInoltrata
		List<Fotografia> fotografie = new ArrayList<>(this.carrello.getFotografie().values());
		richiesta.setFotografie(fotografie);
		this.richiestaValidator.validate(richiesta, bindingResult);
		if (!bindingResult.hasErrors()) {
			return "confermaRichiesta.html";
		} else {
			return "richiestaForm.html";
		}

	}

	@RequestMapping(value = "/confermaRichiesta", method = RequestMethod.GET)
	public String getRichiesta(@Valid @ModelAttribute("richiesta") Richiesta richiesta, Model model) {
		this.richiestaService.inserisci(richiesta);
		this.carrello.svuota(); //svuoto il carrello dopo l'invio della richiesta
		return "richiestaInoltrata.html";

	}
	
	@RequestMapping("/inviaRichiesta")
	public String inviaRichiesta(Model model) {
		model.addAttribute("richiesta", new Richiesta());
		return "richiestaForm.html";
	}

}

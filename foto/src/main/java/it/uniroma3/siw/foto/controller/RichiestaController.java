package it.uniroma3.siw.foto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.foto.model.Richiesta;
import it.uniroma3.siw.foto.service.RichiestaService;

@Controller
@Scope("session")
public class RichiestaController {

	@Autowired
	private RichiestaService richiestaService;

	@Autowired
	private RichiestaValidator richiestaValidator;

	@RequestMapping(value = "/richiesta", method = RequestMethod.POST)
	public String newRichiesta(@Valid @ModelAttribute("richiesta") Richiesta richiesta, Model model,
			BindingResult bindingResult) {
		// controllo se la richiesta è valida:
		// se è valida lo mando alla conferma per la persistenza nel db
		// se non è valida lo rimando alla pagina di richiesta
		this.richiestaValidator.validate(richiesta, bindingResult);
		if (bindingResult.hasErrors()) {
			return "richiesta.html";
		} else {
			return "confermaRichiesta.html";
		}

	}

	@RequestMapping(value = "/confermaRichiesta", method = RequestMethod.GET)
	public String getRichiesta(@Valid @ModelAttribute("richiesta") Richiesta richiesta, Model model) {
		this.richiestaService.inserisci(richiesta);
		return "richiestaInoltrata.html";

	}

}

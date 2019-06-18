package it.uniroma3.siw.foto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import it.uniroma3.siw.foto.model.Album;
import it.uniroma3.siw.foto.service.FotografiaService;

@Controller
public class FotografiaController {

	@Autowired
	private FotografiaService fotografiaService;

	@Autowired
	private Carrello carrello;

	@RequestMapping(value = "/fotografia/{id}", method = RequestMethod.GET)
	public String getFotografia(@PathVariable("id") Long id, Model model) {
		model.addAttribute("fotografia", fotografiaService.getFotografiaPerId(id));
		model.addAttribute("carrello", this.carrello);
		return "fotografia.html";
	}

	@RequestMapping(value = "/aggiungiFotografia/{id}")
	public String aggiungiFotografiaAlCarrello(@PathVariable("id") Long id,
			Model model,@SessionAttribute("album") Album album) {
		if (this.carrello.contains(id)) {
			carrello.remove(id);
		} else {
			this.carrello.add(this.fotografiaService.getFotografiaPerId(id));
		}
		return "redirect:/album/"+album.getId();
	}

}

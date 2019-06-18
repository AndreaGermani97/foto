package it.uniroma3.siw.foto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.uniroma3.siw.foto.model.Album;
import it.uniroma3.siw.foto.model.Fotografia;
import it.uniroma3.siw.foto.service.FotografiaService;

@Controller
@SessionAttributes("fotografia")
public class FotografiaController {
	
	@Autowired
	private FotografiaValidator fotografiaValidator;

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
	
	@RequestMapping(value = "/fotografia", method = RequestMethod.POST)
	public String newFotografia(@Valid @ModelAttribute("fotografia") Fotografia fotografia,Model model, BindingResult bindingResult) {
		this.fotografiaValidator.validate(fotografia, bindingResult);
		if (!bindingResult.hasErrors()) {
			this.fotografiaService.inserisci(fotografia);
			model.addAttribute("album", fotografia.getAlbum());
			return "fotografie.html";
		} else {
			return "fotografiaForm.html";
		}
	}

	@RequestMapping("/aggiungiFotografia")
	public String aggiungiFotografo(Model model, @SessionAttribute("album") Album album) {
		Fotografia fotografia = new Fotografia();
		fotografia.setAlbum(album);
		model.addAttribute("fotografia", fotografia);
		return "fotografiaForm.html";
	}

}

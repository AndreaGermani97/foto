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
import it.uniroma3.siw.foto.model.Fotografo;
import it.uniroma3.siw.foto.service.AlbumService;

@Controller
@SessionAttributes("album")
public class AlbumController {

	@Autowired
	private AlbumService albumService;

	@Autowired
	private AlbumValidator albumValidator;
	
	@Autowired
	private Carrello carrello;

	@RequestMapping(value = "/album/{id}", method = RequestMethod.GET)
	public String getAlbum(@PathVariable("id") Long id, Model model) {
		model.addAttribute("album", albumService.getAlbumPerId(id));
		model.addAttribute("carrello", this.carrello);
		return "fotografie.html";
	}

	@RequestMapping(value = "/album", method = RequestMethod.POST)
	public String newAlbum(@Valid @ModelAttribute("album") Album album,Model model, BindingResult bindingResult) {
		this.albumValidator.validate(album, bindingResult);
		if (!bindingResult.hasErrors()) {
			this.albumService.inserisci(album);
			return "redirect:fotografo/"+album.getFotografo().getId();
		} else {
			return "albumForm";
		}
	}

	@RequestMapping("/aggiungiAlbum")
	public String aggiungiFotografo(Model model, @SessionAttribute("fotografo") Fotografo fotografo) {
		Album album = new Album();
		album.setFotografo(fotografo);
		model.addAttribute("album", album);
		return "albumForm";
	}
}

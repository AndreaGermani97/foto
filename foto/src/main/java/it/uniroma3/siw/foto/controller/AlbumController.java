package it.uniroma3.siw.foto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.foto.service.AlbumService;

@Controller
public class AlbumController {
	
	@Autowired
	private AlbumService albumService;
	
	@RequestMapping(value="/album/{id}",method=RequestMethod.GET)
	public String getAlbum(@PathVariable("id") Long id,Model model) {
		model.addAttribute("album", albumService.getAlbumPerId(id));
		return "fotografie.html";
	}

}

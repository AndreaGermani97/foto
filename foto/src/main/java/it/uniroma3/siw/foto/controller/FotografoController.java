package it.uniroma3.siw.foto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.foto.service.FotografoService;

@Controller
public class FotografoController {
	
	@Autowired
	private FotografoService fotografoService;
	
	@RequestMapping(value="/fotografo/{id}",method=RequestMethod.GET)
	public String getFotografo(@PathVariable("id") Long id,Model model) {
		if(id!=null) { // accedo a pagina fotografo
			model.addAttribute("fotografo", fotografoService.getFotografoPerId(id));
			return "album.html";
		}
		else { // accedo a 
			model.addAttribute("fotografi", fotografoService.tutti());
			return "fotografi.html";
		}
	}
	
	@RequestMapping("/")
	public String GetFotografi(Model model) {
		model.addAttribute("fotografi", fotografoService.tutti());
		return "fotografi.html";
	}

}

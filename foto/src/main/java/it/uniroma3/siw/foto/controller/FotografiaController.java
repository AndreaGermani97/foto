package it.uniroma3.siw.foto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.foto.service.FotografiaService;

@Controller
public class FotografiaController {
	
	@Autowired
	private FotografiaService fotografiaService;
	
	@RequestMapping(value="/fotografia/{id}",method=RequestMethod.GET)
	public String getFotografia(@PathVariable("id") Long id,Model model) {
		model.addAttribute("fotografia", fotografiaService.getFotografiaPerId(id));
		return "fotografia.html";
	}

}

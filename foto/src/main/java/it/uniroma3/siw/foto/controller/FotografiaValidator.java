package it.uniroma3.siw.foto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.foto.model.Fotografia;
import it.uniroma3.siw.foto.service.FotografiaService;

@Component
public class FotografiaValidator implements Validator{

	@Autowired
	private FotografiaService fotografiaService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Fotografia.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		Fotografia fotografia = (Fotografia)target;
		if(this.fotografiaService.esisteFotografiaDellAlbumConStessoNome(fotografia.getAlbum(),fotografia.getNome())) {
			errors.rejectValue("nome", "duplicate");
		}
	}

}

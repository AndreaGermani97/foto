package it.uniroma3.siw.foto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.foto.model.Album;
import it.uniroma3.siw.foto.service.AlbumService;

@Component
public class AlbumValidator implements Validator {
	
	@Autowired
	private AlbumService albumService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Album.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		Album album = (Album)target;
		if(albumService.esisteAlbumDelFotografoConStessoNome(album.getFotografo(),album.getNome())) {
			errors.rejectValue("nome", "duplicate");;
		}
		
	}

}

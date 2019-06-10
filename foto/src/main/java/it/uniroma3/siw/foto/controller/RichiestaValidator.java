package it.uniroma3.siw.foto.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.foto.model.Richiesta;

public class RichiestaValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Richiesta.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "indirizzoConsegna", "required");
		
	}

}

package it.uniroma3.siw.foto.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.foto.model.Richiesta;

@Component
public class RichiestaValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Richiesta.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cliente.nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cliente.cognome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cliente.email", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cliente.indirizzo", "required");
		
		Richiesta richiesta= (Richiesta) target;
		if(richiesta.getFotografie().isEmpty()) {
			errors.rejectValue("fotografie", "required");
		}
	}

}

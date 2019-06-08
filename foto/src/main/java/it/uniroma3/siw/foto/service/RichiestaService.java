package it.uniroma3.siw.foto.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.foto.model.Richiesta;
import it.uniroma3.siw.foto.repository.RichiestaRepository;

@Service
public class RichiestaService {
	
	@Autowired
	private RichiestaRepository richiestaRepository;

	public void inserisci(@Valid Richiesta richiesta) {
		// TODO Auto-generated method stub
		
	}

}

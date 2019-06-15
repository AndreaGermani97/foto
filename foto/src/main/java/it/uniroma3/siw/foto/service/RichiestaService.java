package it.uniroma3.siw.foto.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.foto.model.Richiesta;
import it.uniroma3.siw.foto.repository.RichiestaRepository;

@Service
public class RichiestaService {
	
	@Autowired
	private RichiestaRepository richiestaRepository;

	@Transactional
	public Richiesta inserisci(@Valid Richiesta richiesta) {
		return this.richiestaRepository.save(richiesta);
		
	}
	@Transactional
	public List<Richiesta> trovaTutteRichieste() {
		return (List<Richiesta>) this.richiestaRepository.findAll();
	}

}

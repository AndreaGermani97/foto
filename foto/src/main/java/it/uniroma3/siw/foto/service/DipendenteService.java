package it.uniroma3.siw.foto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.foto.model.Dipendente;
import it.uniroma3.siw.foto.repository.DipendenteRepository;

@Service
public class DipendenteService {
	
	@Autowired
	private DipendenteRepository dipendenteRepository;

	@Transactional
	public Dipendente getDipendentePerEmail(String email) {
		return this.dipendenteRepository.findById(email).get();
	}
	
}

package it.uniroma3.siw.foto.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.foto.model.Fotografia;
import it.uniroma3.siw.foto.repository.FotografiaRepository;

@Service
public class FotografiaService {
	
	@Autowired
	private FotografiaRepository fotografiaRepository;

	@Transactional
	public Fotografia getFotografiaPerId(Long id) {
		return fotografiaRepository.findById(id).get();
	}

}

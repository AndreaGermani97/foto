package it.uniroma3.siw.foto.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.foto.model.Fotografo;
import it.uniroma3.siw.foto.repository.FotografoRepository;

@Service
public class FotografoService {

	@Autowired
	private FotografoRepository fotografoRepository;

	@Transactional
	public Fotografo getFotografoPerId(Long id) {
		return fotografoRepository.findById(id).get();
	}

	@Transactional
	public List<Fotografo> tutti() {
		return (List<Fotografo>)fotografoRepository.findAll();
	}

	public void inserisci(@Valid Fotografo fotografo) {
		this.fotografoRepository.save(fotografo);
		
	}
}

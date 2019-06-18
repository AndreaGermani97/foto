package it.uniroma3.siw.foto.service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.foto.model.Album;
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

	@Transactional
	public void inserisci(@Valid Fotografia fotografia) {
		fotografia.getAlbum().addFotografia(fotografia);
		this.fotografiaRepository.save(fotografia);
		
	}

	@Transactional
	public boolean esisteFotografiaDellAlbumConStessoNome(Album album, String nome) {
		return this.fotografiaRepository.existsByAlbumAndNome(album, nome);
	}

}

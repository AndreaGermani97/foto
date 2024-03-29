package it.uniroma3.siw.foto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.foto.model.Album;
import it.uniroma3.siw.foto.model.Fotografo;
import it.uniroma3.siw.foto.repository.AlbumRepository;

@Service
public class AlbumService {
	
	@Autowired
	private AlbumRepository albumRepository;
	

	@Transactional
	public Album getAlbumPerId(Long id) {
		return albumRepository.findById(id).get();
	}

	@Transactional
	public void inserisci(Album album) {
		album.getFotografo().addAlbum(album);
		this.albumRepository.save(album);
	}

	@Transactional
	public boolean esisteAlbumDelFotografoConStessoNome(Fotografo fotografo, String nome) {
		return this.albumRepository.existsByFotografoAndNome(fotografo, nome);
	}

}

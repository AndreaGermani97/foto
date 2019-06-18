package it.uniroma3.siw.foto.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.foto.model.Album;
import it.uniroma3.siw.foto.model.Fotografia;

public interface FotografiaRepository extends CrudRepository<Fotografia,Long> {

	public boolean existsByAlbumAndNome(Album album, String nome);

}

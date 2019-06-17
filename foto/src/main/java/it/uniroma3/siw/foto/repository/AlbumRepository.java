package it.uniroma3.siw.foto.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.foto.model.Album;
import it.uniroma3.siw.foto.model.Fotografo;

public interface AlbumRepository extends CrudRepository<Album,Long>{
	
	public boolean existsByFotografoAndNome(Fotografo fotografo,String nome);

}

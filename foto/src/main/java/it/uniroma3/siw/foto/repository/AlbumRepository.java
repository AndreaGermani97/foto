package it.uniroma3.siw.foto.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.foto.model.Album;

public interface AlbumRepository extends CrudRepository<Album,Long>{

}

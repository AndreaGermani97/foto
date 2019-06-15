package it.uniroma3.siw.foto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.foto.model.Richiesta;

public interface RichiestaRepository extends CrudRepository<Richiesta,Long> {
	
	public List<Richiesta> findAllByOrderByIdAsc();

}

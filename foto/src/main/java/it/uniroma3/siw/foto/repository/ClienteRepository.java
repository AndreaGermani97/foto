package it.uniroma3.siw.foto.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.foto.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente,Long> {

}

package it.uniroma3.siw.foto.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DBPopulation implements ApplicationRunner{
	
	@Autowired
	private AlbumRepository albumRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private DipendenteRepository dipendenteRepository;
	
	@Autowired
	private FotografiaRepository fotografiaRepository;
	
	@Autowired
	private FotografoRepository fotografoRepository;
	
	@Autowired
	private RichiestaRepository richiestaRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		this.deleteAll();
		this.addAll();
	}

	private void addAll() {
		// TODO Auto-generated method stub
		
	}

	private void deleteAll() {
		System.out.print("cancello tutto");
		albumRepository.deleteAll();
		clienteRepository.deleteAll();
		dipendenteRepository.deleteAll();
		fotografiaRepository.deleteAll();
		fotografoRepository.deleteAll();
		richiestaRepository.deleteAll();
	}

}

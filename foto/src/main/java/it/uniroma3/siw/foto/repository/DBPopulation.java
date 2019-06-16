package it.uniroma3.siw.foto.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.foto.model.Album;
import it.uniroma3.siw.foto.model.Cliente;
import it.uniroma3.siw.foto.model.Dipendente;
import it.uniroma3.siw.foto.model.Fotografia;
import it.uniroma3.siw.foto.model.Fotografo;
import it.uniroma3.siw.foto.model.Richiesta;

@Component
public class DBPopulation implements ApplicationRunner{
	
	@Autowired
	private DipendenteRepository dipendenteRepository;
	
	@Autowired
	private FotografoRepository fotografoRepository;
	
	@Autowired
	private RichiestaRepository richiestaRepository;
	
	private List<Fotografo> fotografi = new ArrayList<>();
	private List<Dipendente> dipendenti = new ArrayList<>();
	private List<Richiesta> richieste = new ArrayList<>();
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.deleteAll();
		this.addAll();
	}
	
	private void creatoreFotografi() {
		Fotografo putin = new Fotografo("Vladimir", "Putin");
		
		Album albumUnoFotografoPutin = new Album("album uno Putin", "album uno di putin");
		putin.addAlbum(albumUnoFotografoPutin);
		Album albumDueFotografoPutin = new Album("album due Putin","album due di putin");
		putin.addAlbum(albumDueFotografoPutin);
		
		Fotografia fotoUnoAlbumUnoPutin = new Fotografia("foto uno album uno putin", "");
		Fotografia fotoDueAlbumUnoPutin = new Fotografia("foto due album uno putin", "");
		albumUnoFotografoPutin.addFotografia(fotoUnoAlbumUnoPutin);
		albumUnoFotografoPutin.addFotografia(fotoDueAlbumUnoPutin);
		
		Fotografia fotoUnoAlbumDuePutin = new Fotografia("foto uno album due putin", "");
		Fotografia fotoDueAlbumDuePutin = new Fotografia("foto due album due putin", "");
		albumDueFotografoPutin.addFotografia(fotoUnoAlbumDuePutin);
		albumDueFotografoPutin.addFotografia(fotoDueAlbumDuePutin);
		
		Fotografo trump = new Fotografo("Donald", "Trump");

		Album albumUnoFotografoTrump = new Album("album uno trump", "album uno di trump");
		trump.addAlbum(albumUnoFotografoTrump);
		Album albumDueFotografoTrump = new Album("album due trump", "album due di trump");
		trump.addAlbum(albumDueFotografoTrump);

		Fotografia fotoUnoAlbumUnoTrump = new Fotografia("foto uno album uno trump", "");
		Fotografia fotoDueAlbumUnoTrump = new Fotografia("foto due album uno trump", "");
		albumUnoFotografoTrump.addFotografia(fotoUnoAlbumUnoTrump);
		albumUnoFotografoTrump.addFotografia(fotoDueAlbumUnoTrump);	
		
		Fotografia fotoUnoAlbumDueTrump = new Fotografia("foto uno album due trump", "");
		Fotografia fotoDueAlbumDueTrump = new Fotografia("foto due album due trump", "");
		albumDueFotografoTrump.addFotografia(fotoUnoAlbumDueTrump);
		albumDueFotografoTrump.addFotografia(fotoDueAlbumDueTrump);
		
		
		Dipendente dipendenteEnzo = new Dipendente("enzotongxing.chou@gmail.com", new BCryptPasswordEncoder().encode("bananabanana"), "Enzo", "Chou", "DIPENDENTE");
		Dipendente dipendenteAndrea = new Dipendente("andreaGermani@gmail.com", new BCryptPasswordEncoder().encode("melamela"), "Andrea", "Germani", "DIPENDENTE");
		
		Cliente obama = new Cliente("Barack", "Obama", "BarackObama@gmail.com", "casa bianca");
		Cliente clinton	= new Cliente("Bill", "Clinton", "clintonBill@gmail.com", "casa bianca");
		List<Fotografia> richiestaObama = new ArrayList<>();
		richiestaObama.add(fotoUnoAlbumUnoPutin);
		List<Fotografia> richiestaClinton = new ArrayList<>();
		richiestaClinton.add(fotoDueAlbumUnoPutin);
		Richiesta richiestaUno = new Richiesta(obama, richiestaObama);
		Richiesta richiestaDue = new Richiesta(clinton, richiestaClinton);
		
		fotografi.add(trump);
		fotografi.add(putin);
		dipendenti.add(dipendenteEnzo);
		dipendenti.add(dipendenteAndrea);
		richieste.add(richiestaUno);
		richieste.add(richiestaDue);
	}

	private void addAll() {
		creatoreFotografi();
		fotografoRepository.saveAll(fotografi);
		dipendenteRepository.saveAll(dipendenti);
		richiestaRepository.saveAll(richieste);
	}

	private void deleteAll() {
		System.out.print("cancello tutto");
		dipendenteRepository.deleteAll();
		fotografoRepository.deleteAll();
		richiestaRepository.deleteAll();
	}

}

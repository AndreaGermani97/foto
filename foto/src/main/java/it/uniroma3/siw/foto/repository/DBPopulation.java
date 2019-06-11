package it.uniroma3.siw.foto.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.foto.model.Album;
import it.uniroma3.siw.foto.model.Dipendente;
import it.uniroma3.siw.foto.model.Fotografia;
import it.uniroma3.siw.foto.model.Fotografo;

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
	
	private List<Fotografo> fotografi = new ArrayList<>();
	private List<Album> album = new ArrayList<>();
	private List<Fotografia> fotografie = new ArrayList<>();
	private List<Dipendente> dipendenti = new ArrayList<>();
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		this.deleteAll();
		this.addAll();
	}
	
	private void creatoreFotografi() {
		Fotografo putin = new Fotografo("Vladimir", "Putin");
		
		Album albumUnoFotografoPutin = new Album("album uno Putin", "album uno di putin");	
		Album albumDueFotografoPutin = new Album("album due Putin","album due di putin");
		
		Fotografia fotoUnoAlbumUnoPutin = new Fotografia("foto uno album uno putin", "");
		Fotografia fotoDueAlbumUnoPutin = new Fotografia("foto due album uno putin", "");
		Fotografia fotoUnoAlbumDuePutin = new Fotografia("foto uno album due putin", "");
		Fotografia fotoDueAlbumDuePutin = new Fotografia("foto due album due putin", "");
		
		Fotografo trump = new Fotografo("Donald", "Trump");

		Album albumUnoFotografoTrump = new Album("album uno trump", "album uno di trump");
		Album albumDueFotografoTrump = new Album("album due trump", "album due di trump");

		Fotografia fotoUnoAlbumUnoTrump = new Fotografia("foto uno album uno trump", "");
		Fotografia fotoDueAlbumUnoTrump = new Fotografia("foto due album uno trump", "");
		Fotografia fotoUnoAlbumDueTrump = new Fotografia("foto uno album due trump", "");
		Fotografia fotoDueAlbumDueTrump = new Fotografia("foto due album due trump", "");
		
		Dipendente dipendenteEnzo = new Dipendente("enzotongxing.chou@gmail.com", "bananabanana", "Enzo", "Chou", "dipendente");
		Dipendente dipendenteAndrea = new Dipendente("andreaGermani@gmail.com", "dipendente", "Andrea", "Germani", "dipendente");
		
		fotografi.add(trump);
		fotografi.add(putin);
		album.add(albumUnoFotografoTrump);
		album.add(albumDueFotografoTrump);
		album.add(albumUnoFotografoPutin);
		album.add(albumDueFotografoPutin);
		fotografie.add(fotoUnoAlbumUnoPutin);
		fotografie.add(fotoUnoAlbumDuePutin);
		fotografie.add(fotoDueAlbumUnoPutin);
		fotografie.add(fotoDueAlbumDuePutin);
		fotografie.add(fotoUnoAlbumUnoTrump);
		fotografie.add(fotoDueAlbumUnoTrump);
		fotografie.add(fotoUnoAlbumDueTrump);
		fotografie.add(fotoDueAlbumDueTrump);
		dipendenti.add(dipendenteEnzo);
		dipendenti.add(dipendenteAndrea);
	}

	private void addAll() {
		creatoreFotografi();
		fotografoRepository.saveAll(fotografi);
		albumRepository.saveAll(album);
		fotografiaRepository.saveAll(fotografie);
		dipendenteRepository.saveAll(dipendenti);
		
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

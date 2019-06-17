package it.uniroma3.siw.foto.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "fotografo_id", "nome" }))
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String nome;

	private String descrizione;

	@ManyToOne
	private Fotografo fotografo;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinColumn(name = "album_id")
	List<Fotografia> fotografie;

	public Album() {
	}

	public Album(String nome, String descrizione, Fotografo fotografo) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.fotografie = new ArrayList<>();
		this.fotografo = fotografo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Fotografo getFotografo() {
		return fotografo;
	}

	public void setFotografo(Fotografo fotografo) {
		this.fotografo = fotografo;
	}

	public List<Fotografia> getFotografie() {
		return fotografie;
	}

	public void setFotografie(List<Fotografia> fotografie) {
		this.fotografie = fotografie;
	}

	public void addFotografia(Fotografia fotografia) {
		this.fotografie.add(fotografia);
	}

}

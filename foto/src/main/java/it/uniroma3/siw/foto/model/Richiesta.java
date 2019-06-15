package it.uniroma3.siw.foto.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Richiesta implements Comparable<Richiesta>{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private LocalDate data;

	@OneToOne(cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
	private Cliente cliente;

	@ManyToMany
	private List<Fotografia> fotografie;

	private int numeroDiFoto;

	public Richiesta() {
	}

	public Richiesta(Cliente cliente, List<Fotografia> fotografie) {
		this.data=LocalDate.now();
		this.cliente = cliente;
		this.fotografie = fotografie;
		this.numeroDiFoto = fotografie.size();
	}
	
	@Override
	public boolean equals(Object o) {
		Richiesta r = (Richiesta) o;
		return r.getId()==this.getId();
	}
	
	@Override
	public int hashCode() {
		return (int) this.getId()+this.getCliente().hashCode()+this.getData().hashCode();
	}
	
	@Override
	public int compareTo(Richiesta r) {
		if(this.getData()==r.getData()) {
			return this.getCliente().getCognome().compareTo(r.getCliente().getCognome());
		} else {
			return this.getData().hashCode()-r.getData().hashCode();
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Fotografia> getFotografie() {
		return fotografie;
	}

	public void setFotografie(List<Fotografia> fotografie) {
		this.fotografie = fotografie;
	}

	public int getNumeroDiFoto() {
		return numeroDiFoto;
	}

	public void setNumeroDiFoto(int numeroDiFoto) {
		this.numeroDiFoto = numeroDiFoto;
	}

}

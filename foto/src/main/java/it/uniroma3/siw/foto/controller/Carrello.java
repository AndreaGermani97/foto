package it.uniroma3.siw.foto.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.foto.model.Fotografia;

@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Carrello {
	
	private Map<Long, Fotografia> fotografie;

	public Carrello() {
		this.fotografie = new HashMap<>();
	}

	public Map<Long, Fotografia> getFotografie() {
		return fotografie;
	}

	public void setFotografie(Map<Long, Fotografia> fotografie) {
		this.fotografie = fotografie;
	}

	public void add(Fotografia fotografia) {
		this.fotografie.put(fotografia.getId(), fotografia);
	}

	public void svuota() {
		fotografie.clear();
	}

	public boolean contains(Long fotoId) {
		return this.fotografie.containsKey(fotoId);
	}

	public void remove(Long fotoId) {
		this.fotografie.remove(fotoId);
	}


}

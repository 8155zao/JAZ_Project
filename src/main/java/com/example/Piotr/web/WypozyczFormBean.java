package com.example.Piotr.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.Piotr.domain.Film;
import com.example.Piotr.domain.Osoba;
import com.example.Piotr.service.ObslugaOsoby;
import com.example.Piotr.service.ObslugaWypozyczalni;

@SessionScoped
@Named("wypozyczBean")
public class WypozyczFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ObslugaWypozyczalni ow;

	@Inject
	private ObslugaOsoby oo;

	private Long filmId;
	private Long osobaId;
	
	public Long getFilmId() {
		return filmId;
	}
	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}
	public Long getOsobaId() {
		return osobaId;
	}
	public void setOsobaId(Long osobaId) {
		this.osobaId = osobaId;
	}

	public List<Film> getDostepneFilmy() {
		return ow.getDostepneFilmy();
	}

	public List<Osoba> getWszystkieOsoby() {
		return oo.getWszystkieOsoby();
	}

	public String wypozyczFilm() {
		ow.wypozyczFilm(osobaId, filmId);
		return null;
	}
}

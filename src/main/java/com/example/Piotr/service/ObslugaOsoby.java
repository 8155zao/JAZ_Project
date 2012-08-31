package com.example.Piotr.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.Piotr.domain.Film;
import com.example.Piotr.domain.Osoba;

@Stateless
public class ObslugaOsoby {

	@PersistenceContext
	EntityManager em;

	public void dodajOsobe(Osoba osoba) {
		osoba.setId(null);
		em.persist(osoba);
	}

	public void usunOsobe(Osoba osoba) {
		osoba = em.find(Osoba.class, osoba.getId());
		em.remove(osoba); 
	}

	@SuppressWarnings("unchecked")
	public List<Osoba> getWszystkieOsoby() {
		return em.createNamedQuery("osoba.all").getResultList();
	}

	public List<Film> getOsobaWypFilm(Osoba osoba) {
		osoba = em.find(Osoba.class, osoba.getId());
	
		List<Film> film = new ArrayList<Film>(osoba.getFilm());
		return film;
	}

}


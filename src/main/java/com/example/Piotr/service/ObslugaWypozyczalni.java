package com.example.Piotr.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.Piotr.domain.Film;
import com.example.Piotr.domain.Osoba;


/* 
 * This is a Stateless EJB Bean
 * All its methods are transactional
 */
@Stateless
public class ObslugaWypozyczalni {

	@PersistenceContext
	EntityManager em;

	public void wypozyczFilm(Long osobaId, Long filmId) {

		Osoba osoba = em.find(Osoba.class, osobaId);
		Film film = em.find(Film.class, filmId);
		film.setWypoz(true);

		osoba.getFilm().add(film);
	}

	@SuppressWarnings("unchecked")
	public List<Film> getDostepneFilmy() {
		return em.createNamedQuery("film.dostepny").getResultList();
	}

	public void osobaWypFilm(Osoba osoba, Film film) {

		osoba = em.find(Osoba.class, osoba.getId());
		film = em.find(Film.class, film.getId());

		Film usun = null;
		// lazy loading here (person.getCars)
		for (Film filmy : osoba.getFilm())
			if (filmy.getId().compareTo(film.getId()) == 0) {
				usun = filmy;
				break;
			}

		if (usun != null)
			osoba.getFilm().remove(usun);
		
		film.setWypoz(false);
	}
}

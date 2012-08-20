package com.example.Piotr.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.Piotr.domain.Film;
import com.example.Piotr.domain.Osoba;
import com.example.Piotr.service.ObslugaOsoby;
import com.example.Piotr.service.ObslugaWypozyczalni;

@SessionScoped
@Named("osobaBean")
public class OsobaFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Osoba osoba = new Osoba();
	private ListDataModel<Osoba> osoby = new ListDataModel<Osoba>();
	
	private Osoba pokazOsobe = new Osoba();
	private ListDataModel<Film> osobaWypFilm = new ListDataModel<Film>();


	@Inject
	private ObslugaOsoby oo;
	
	@Inject
	private ObslugaWypozyczalni ow;

	public Osoba getOsoba() {
		return osoba;
	}
	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}
	
	public ListDataModel<Osoba> getWszystkieOsoby() {
		osoby.setWrappedData(oo.getWszystkieOsoby());
		return osoby;
	}

	public ListDataModel<Film> OsobaWypFilm() {
		osobaWypFilm.setWrappedData(oo.getOsobaWypFilm(pokazOsobe));
		return osobaWypFilm;
	}
	
	// Actions
	public String dodajOsobe() {
		oo.dodajOsobe(osoba);
		return "pokazOsobe";
		//return null;
	}

	public String usunOsobe() {
		Osoba osobaDoUsuniecia = osoby.getRowData();
		oo.usunOsobe(osobaDoUsuniecia);
		return null;
	}
	
	public String pokazSzczegoly() {
		pokazOsobe = osoby.getRowData();
		return "szczegoly";
	}
	
	public String dostepnyFilm(){
			Film filmDostepny = osobaWypFilm.getRowData();
			ow.dostepnyFilm(pokazOsobe, filmDostepny);
			return null;
		}
}

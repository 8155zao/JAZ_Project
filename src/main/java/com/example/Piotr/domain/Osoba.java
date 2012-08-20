package com.example.Piotr.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "osoba.all", query = "Select o from Osoba o")
})
public class Osoba {

	private Long id;
	private String imie = "imie";
	private String nazwisko = "nazwisko";
	private String pin = "pesel";
	private Date dataRejestracji = new Date();

	private List<Film> film = new ArrayList<Film>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Size(min = 2, max = 20)
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	@Size(min = 2, max = 20)
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	@Size(min = 2)
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}

	@Temporal(TemporalType.DATE)
	public Date getDataRejestracji() {
		return dataRejestracji;
	}
	public void setDataRejestracji(Date dataRejestracji) {
		this.dataRejestracji = dataRejestracji;
	}

	// Be careful here, both with lazy and eager fetch type
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Film> getFilm() {
		return film;
	}
	public void setFilm(List<Film> film) {
		this.film = film;
	}
}

package com.example.Piotr.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "film.dostepny", query = "Select f from Film f where f.wypoz = false")
public class Film {
	
	private Long id;
	private String stworz;
	private String tytul;
	private Boolean wypoz = false;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStworz() {
		return stworz;
	}
	public void setStworz(String stworz) {
		this.stworz = stworz;
	}
	public String getTytul() {
		return tytul;
	}
	public void setTytul(String tytul) {
		this.tytul = tytul;
	}
	public Boolean getWypoz() {
		return wypoz;
	}
	public void setWypoz(Boolean wypoz) {
		this.wypoz = wypoz;
	}
}

package com.ifindstuff.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "catalogue")
public class Catalogue {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="catalogue")
	private int id;
	
	@Column(name="name")
	@NotEmpty(message = "*Please provide catalogue name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@OneToMany(mappedBy = "catalogue", cascade = CascadeType.ALL)
	private List<Categorie> categorie;

	

	public Catalogue() {
		super();
	}

	public Catalogue(int id, String name, String description, List<Categorie> categorie) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.categorie = categorie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Categorie> getCategorie() {
		return categorie;
	}

	public void setCategorie(List<Categorie> categorie) {
		this.categorie = categorie;
	}
	
	
	
	
}

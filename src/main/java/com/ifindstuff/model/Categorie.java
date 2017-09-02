package com.ifindstuff.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "categorie")
public class Categorie {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="categorie_id")
	private int id;
	
	@Column(name="name")
	@NotEmpty(message = "*Please provide categorie name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "catalogue_id")
	private Catalogue catalogue;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinTable(name = "produit_categorie", joinColumns = @JoinColumn(name = "categorie_id"), inverseJoinColumns = @JoinColumn(name = "produit_id"))
	private Set<Produit> produit;

	@Column(name = "banner")
	private String banner;
	
	
	
	public Categorie() {
		super();
	}

	

	public Categorie(int id, String name, String description, Catalogue catalogue, Set<Produit> produit,
			String banner) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.catalogue = catalogue;
		this.produit = produit;
		this.banner = banner;
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

	public Catalogue getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}

	public Set<Produit> getProduit() {
		return produit;
	}

	public void setProduit(Set<Produit> produit) {
		this.produit = produit;
	}



	public String getBanner() {
		return banner;
	}



	public void setBanner(String banner) {
		this.banner = banner;
	}
	
	
	
	
	
}

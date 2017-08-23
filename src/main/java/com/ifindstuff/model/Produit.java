package com.ifindstuff.model;

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
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "produit")
public class Produit {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="produit_id")
	private int id;
	
	@Column(name="name")
	@NotEmpty(message = "*Please provide produit name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	@NotEmpty(message = "*Please provide produit price")
	private float price;
	
	@Column(name="amount")
	@NotEmpty(message = "*Please provide produit amount")
	private double amount;
	
	@ManyToOne
    @JoinColumn(name = "store_id")
	private Store store;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "produit_categorie", joinColumns = @JoinColumn(name = "produit_id"), inverseJoinColumns = @JoinColumn(name = "categorie_id"))
	private Set<Categorie> categorie;

	
	
	
	public Produit() {
		super();
	}

	public Produit(int id, String name, String description, float price, double amount, Store store,
			Set<Categorie> categorie) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.amount = amount;
		this.store = store;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Set<Categorie> getCategorie() {
		return categorie;
	}

	public void setCategorie(Set<Categorie> categorie) {
		this.categorie = categorie;
	}
	
	
	
	
}

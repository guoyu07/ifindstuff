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
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "store")
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "store_id")
	private int id;
	
	@Column(name = "name")
	@NotEmpty(message = "*Please provide store name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "latitude")
	@DecimalMax("100.0")
	@DecimalMin("-100.0")
	@NotNull(message ="contrainst no respected")
	private float latitude;
	
	@Column(name = "longitude")
	@DecimalMax("100.0")
	@DecimalMin("-100.0")
	@NotNull(message ="contrainst no respected")
	private float longitude;
	
	@Column(name = "adresse")
	@NotEmpty(message = "*Please provide store adresse")
	private String adresse;
	
	@Column(name = "telephone")
	private String telephone;
	
	
	@Column(name = "active")
	private boolean active = false;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
	private Set<Produit> produit;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "store_city", joinColumns = @JoinColumn(name = "store_id"), inverseJoinColumns = @JoinColumn(name = "city_id"))
	private Set<City> city;
	
	
	
	
	public Store() {
		super();
	}
	
	
	public Store(int id, String name, String description, float latitude, float longitude, String adresse,
			String telephone, boolean active, User user, Set<Produit> produit, Set<City> city) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.latitude = latitude;
		this.longitude = longitude;
		this.adresse = adresse;
		this.telephone = telephone;
		this.active = active;
		this.user = user;
		this.produit = produit;
		this.city = city;
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public Set<Produit> getProduit() {
		return produit;
	}


	public void setProduit(Set<Produit> produit) {
		this.produit = produit;
	}


	public Set<City> getCity() {
		return city;
	}


	public void setCity(Set<City> city) {
		this.city = city;
	}


	public Set<City> getVille() {
		return city;
	}
	public void setVille(Set<City> city) {
		this.city = city;
	}
	
	
}

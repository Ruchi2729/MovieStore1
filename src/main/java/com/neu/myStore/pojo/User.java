package com.neu.myStore.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usertable")
public class User implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="favGenre")
	private String favGenre;
	
	
	
	@OneToOne(fetch=FetchType.LAZY,  cascade=CascadeType.ALL)
	 private Email email;
	 
		@Column(name="lastname")
	 private String lastname;
	 
		@Column(name="address")
	 private String address;
	 
	 @Enumerated(EnumType.STRING)
	 private AccountType acountType;
	 
	 @Column(name="isblocked")
	 private boolean isBlockedFlag;
	 
	 @OneToMany(fetch = FetchType.EAGER, mappedBy = "reviewer",cascade=CascadeType.ALL)
	 private Set<Review> myreviews=new HashSet<Review>() ;
	 
	 

	 
	 public Set<Movie> getMovieslikedbyusers() {
		return movieslikedbyusers;
	}




	public void setMovieslikedbyusers(Set<Movie> movieslikedbyusers) {
		this.movieslikedbyusers = movieslikedbyusers;
	}




	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersgenre",cascade=CascadeType.ALL)
	 private Set<Genre> favgenres=new HashSet<Genre>();
	 
	 
		@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		@JoinTable(name = "UsersLikedMovies",
		joinColumns = { @JoinColumn(name = "id") },
		inverseJoinColumns = { @JoinColumn(name = "movieid") })
	 private Set<Movie> movieslikedbyusers=new HashSet<Movie>();
	 	 
	 
	 



	public Set<Genre> getFavgenres() {
		return favgenres;
	}




	public void setFavgenres(Set<Genre> favgenres) {
		this.favgenres = favgenres;
	}




	




	public Set<Review> getMyreviews() {
		return myreviews;
	}




	public void setMyreviews(Set<Review> myreviews) {
		this.myreviews = myreviews;
	}




	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getFirstname() {
		return firstname;
	}




	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}




	public Email getEmail() {
		return email;
	}




	public void setEmail(Email email) {
		this.email = email;
	}




	public String getLastname() {
		return lastname;
	}




	public void setLastname(String lastname) {
		this.lastname = lastname;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public AccountType getAcountType() {
		return acountType;
	}




	public void setAcountType(AccountType acountType) {
		this.acountType = acountType;
	}




	public boolean isBlockedFlag() {
		return isBlockedFlag;
	}




	public void setBlockedFlag(boolean isBlockedFlag) {
		this.isBlockedFlag = isBlockedFlag;
	}




	public enum AccountType {
		    Admin,AccountHolder
		}
	 
	public String getFavGenre() {
		return favGenre;
	}

	public void setFavGenre(String favGenre) {
		this.favGenre = favGenre;
	}

}

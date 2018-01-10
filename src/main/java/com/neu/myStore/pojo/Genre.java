package com.neu.myStore.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="genretable")
public class Genre {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="genreid")
	 private int genreid;
	 
	@Column(name="genreName")
	 private String genreName;
	 
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "genres")
	 private Set<Movie> movies=new HashSet<Movie>();
	 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	 private User usersgenre;

	public User getUsersgenre() {
		return usersgenre;
	}


	@Override
	public String toString() {
		return Integer.toString(genreid);
	}


	public void setUsersgenre(User usersgenre) {
		this.usersgenre = usersgenre;
	}


	public Set<Movie> getMovies() {
		return movies;
	}

	 
	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

	

	public int getGenreid() {
		return genreid;
	}

	public void setGenreid(int genreid) {
		this.genreid = genreid;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	 
	 

}

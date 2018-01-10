package com.neu.myStore.pojo;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.stat.Statistics;

import antlr.collections.List;

@Entity
@Table(name="movietable")
//@Cacheable
//@Cache(usage=CacheConcurrencyStrategy.READ_ONLY, region="Movie")
public class Movie {
	
	@Column(name="title")
	private String title;
	
	@Column(name="actor")
	private String actor;
	
	@Column(name="director")
	private String director;
	
	@Column(name="year")
	private String year;
	
	@Column(name="writer")
	private String writer;
	
	@Column(name="poster")
	private String poster;
	
	@Column(name="imdbid")
	private String imdbid;
	
	
	
	@Column(name="availability")
	private boolean availability ;
	
	
	
	

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public String getImdbid() {
		return imdbid;
	}

	public void setImdbid(String imdbid) {
		this.imdbid = imdbid;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "movie_genre", joinColumns = { 
			@JoinColumn(name = "movieid", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "genreid", 
					nullable = false, updatable = false) })
	private Set<Genre> genres=new HashSet<Genre>();
		
	@Column(name="plot")
	private String plot;
	
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="movieid")
	private long movieid;
	
	@Column(name="price")
	private int price;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
	private Set<Review> reviews=new HashSet<Review>();
	
//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "ratedmovie")
//	private Set<Rating> rating=new HashSet<Rating>();
	
	
	
	@Column(name="imdbrating")
	private String IMDBrating;
	
	

	public Set<User> getUserswholike() {
		return userswholike;
	}

	public void setUserswholike(Set<User> userswholike) {
		this.userswholike = userswholike;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "movieslikedbyusers")
private Set<User> userswholike=new HashSet<User>();


	
	
	
	

	

//	public Set<Rating> getRating() {
//		return rating;
//	}
//
//	public void setRating(Set<Rating> rating) {
//		this.rating = rating;
//	}

	public String getIMDBrating() {
		return IMDBrating;
	}

	public void setIMDBrating(String iMDBrating) {
		IMDBrating = iMDBrating;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}


	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	

	

	public long getMovieid() {
		return movieid;
	}

	public void setMovieid(long movieid) {
		this.movieid = movieid;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
  
	
	
	
	
	

}

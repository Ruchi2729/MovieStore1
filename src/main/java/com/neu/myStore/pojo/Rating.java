//package com.neu.myStore.pojo;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Parameter;
//
//@Entity
//@Table(name="ratingtable")
//public class Rating {
//	
//	@Id
//	@GeneratedValue(strategy =GenerationType.IDENTITY)
//	@Column(name="ratingmovieid")
//	private long ratingmovieid;
//	
//	@Column(name="numberratings")
//	private int ratingno;
//	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "movieid")
//	private Movie ratedmovie;
//
//
//
//	public long getRatingmovieid() {
//		return ratingmovieid;
//	}
//
//	public void setRatingmovieid(long ratingmovieid) {
//		this.ratingmovieid = ratingmovieid;
//	}
//
//	public int getRatingno() {
//		return ratingno;
//	}
//
//	public void setRatingno(int ratingno) {
//		this.ratingno = ratingno;
//	}
//
//	public Movie getRatedmovie() {
//		return ratedmovie;
//	}
//
//	public void setRatedmovie(Movie ratedmovie) {
//		this.ratedmovie = ratedmovie;
//	}
//
//
//	
//
//}

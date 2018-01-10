package com.neu.myStore.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="requestedmovietable")
public class RequestedMovie {

	
	@Column(name="title")
	private String title;
	
	@Column(name="imdbid")
	private String imdbid;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="rmovieid")
	private long rmovieid;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImdbid() {
		return imdbid;
	}

	public void setImdbid(String imdbid) {
		this.imdbid = imdbid;
	}

	public long getRmovieid() {
		return rmovieid;
	}

	public void setRmovieid(long rmovieid) {
		this.rmovieid = rmovieid;
	}
	
	
}

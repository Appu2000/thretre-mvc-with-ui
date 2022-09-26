package com.theatre.entity;

public class Movie {
	private Long mId;
	private String genera;
	private String movieName;
	private String duration;
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(Long mId, String genera, String movieName, String duration) {
		super();
		this.mId = mId;
		this.genera = genera;
		this.movieName = movieName;
		this.duration = duration;
	}
	public Long getmId() {
		return mId;
	}
	public void setmId(Long mId) {
		this.mId = mId;
	}
	public String getGenera() {
		return genera;
	}
	public void setGenera(String genera) {
		this.genera = genera;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	

}

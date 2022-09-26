package com.theatre.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Theatre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long theatreId;
	private String theatreName;
	private String address;
	private String password;
	private Long curMov;
	public Theatre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Theatre(Long theatreId, String theatreName, String address, String password, Long curMov) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.address = address;
		this.password = password;
		this.curMov = curMov;
	}
	public Long getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(Long theatreId) {
		this.theatreId = theatreId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getCurMov() {
		return curMov;
	}
	public void setCurMov(Long curMov) {
		this.curMov = curMov;
	}
	
	
}

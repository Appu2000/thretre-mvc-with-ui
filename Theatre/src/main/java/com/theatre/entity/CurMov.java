package com.theatre.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CurMov {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cmId;
	private Long mId;
	private Long theatreId;
	public CurMov() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CurMov(Long cmId, Long mId, Long theatreId) {
		super();
		this.cmId = cmId;
		this.mId = mId;
		this.theatreId = theatreId;
	}
	public Long getCmId() {
		return cmId;
	}
	public void setCmId(Long cmId) {
		this.cmId = cmId;
	}
	public Long getmId() {
		return mId;
	}
	public void setmId(Long mId) {
		this.mId = mId;
	}
	public Long getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(Long theatreId) {
		this.theatreId = theatreId;
	}

}

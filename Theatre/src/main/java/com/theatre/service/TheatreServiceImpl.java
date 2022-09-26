package com.theatre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theatre.entity.CurMov;
import com.theatre.entity.Theatre;
import com.theatre.repository.CurMovRepository;
import com.theatre.repository.TheatreRepository;

@Service
public class TheatreServiceImpl{
	
	@Autowired
	private TheatreRepository theRepo;
	
	@Autowired
	private CurMovRepository CurRepo;
	
	private Long theatreId=0L;
	
    private String name="";
    
    private String address="";
    
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Long getTheatreId() {
		return theatreId;
	}


	public void setTheatreId(Long theatreId) {
		this.theatreId = theatreId;
	}


	public String authenticate(String user, String password) {
		// TODO Auto-generated method stub
		
		List<Theatre> the=theRepo.findAll();
		System.out.println("at service line no 22");
		int n=the.size();
		System.out.println("at control line no 25");
        for(int i=0;i<n;i++) {
        	Theatre t=the.get(i);
        	if(t.getTheatreName().toLowerCase().equals(user.toLowerCase())) {
        	 if(t.getPassword().equals(password)) {
     	    	
        		theatreId=t.getTheatreId();
        		name=t.getTheatreName();
        		address=t.getAddress();
     	    	System.out.println(".................passed authentication"+name);
     	    	return "no";
     	    }
        }
        }
	   
	    return null;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int addCurMovId() {
		// TODO Auto-generated method stub

		List<Theatre> the=theRepo.findAll();
		
		List<CurMov> cm=CurRepo.findAll();
		int l=cm.size();
		System.out.println("at service line no 76");
		int n=the.size();
		System.out.println("at control line no 78");
		
        for(int i=0;i<n;i++) {
        	Theatre t=the.get(i);
        	if(t.getTheatreId()==theatreId) {
        		for(int j=0;j<l;j++) {
        			CurMov c=cm.get(i);
        			{
        				if(c.getTheatreId()==theatreId) {
        					
        					t.setCurMov(c.getCmId());
        					return 0;
        					
        				}
        			}
        		}
        		
        }
	}
		
		return 1;
	}

}

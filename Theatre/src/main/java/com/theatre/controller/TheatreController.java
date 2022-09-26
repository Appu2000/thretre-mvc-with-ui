package com.theatre.controller;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.theatre.entity.CurMov;
import com.theatre.entity.Movie;

import com.theatre.entity.Theatre;
import com.theatre.repository.CurMovRepository;
import com.theatre.repository.TheatreRepository;
import com.theatre.service.TheatreServiceImpl;


@RestController
@RequestMapping("/theatre")
public class TheatreController {
	
	Movie[] mov= {};
	String name;
	String status;
	
	@Autowired
	private TheatreRepository theRepo;
	
	@Autowired
	private CurMovRepository curMovRepo;
	
	@Autowired
	private TheatreServiceImpl theSer;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	int k=0;
	
	@PostMapping("/add")
	public ResponseEntity<Theatre> addAll(@RequestBody Theatre the)
	{
		return ResponseEntity.ok(((CrudRepository<Theatre, Long>) theRepo).save(the));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Theatre> update(@RequestBody Theatre the) {
		return ResponseEntity.ok(((CrudRepository<Theatre, Long>) theRepo).save(the));
	}

	@RequestMapping("/testing")
	public String test() {
		return "testing...........";
	}
	
	@RequestMapping("/index")
	public ModelAndView Index() {
		
		System.out.println(".........................at index");
		return new ModelAndView("index");
		
	}
	
	@RequestMapping("/main")
	public ModelAndView main(ModelMap mod) {
		
		Movie[] mov=new Movie[20];
		try {
		System.out.println(".........................at main");	    
		
		ResponseEntity <Movie[]> response=restTemplate.getForEntity("http://Movie/movie/getRepo",Movie[].class);
        
		mov=response.getBody();
		
        System.out.println("..........at main"+mov);
       
		}catch(Exception e) {
			System.out.print(e);
		}
        HashMap<String,Movie[]> model=new HashMap<>();
		System.out.println(model);
		
		model.put("list", mov);
		name=theSer.getName();
		
//		mod.put("status",status);
		mod.put("name",name);
		return new ModelAndView("main",model);
		
		
//		return new ModelAndView("main");
		
	}
	

	@RequestMapping("/login")
	public ModelAndView check(ModelMap model,@RequestParam("user") String user,@RequestParam("pass") String password) {
		
		System.out.println("......................."+user+password);
		System.out.println("at control line no 73");
		String err=theSer.authenticate(user,password);
		System.out.println("at control line no 75");
		if(err=="no") {
			name=theSer.getName();
			model.put("name",name);
			return new ModelAndView("landing");
		}

		return new ModelAndView("index");
		
	}
	
	@RequestMapping("/signup")
	public ModelAndView signup() {
		
		System.out.println(".........................at signup");
		return new ModelAndView("signup");
		
	}
	
	@RequestMapping("/adduser")
	public ModelAndView addUser(ModelMap model,@RequestParam("user") String user,@RequestParam("pass") String password,@RequestParam("add") String address) {
		
		System.out.println(".........................at adduser");
		
		Theatre the=new Theatre();
		the.setTheatreName(user);
		the.setAddress(address);
		the.setPassword(password);
		the.setCurMov(0l);
		theRepo.save(the);
		return new ModelAndView("index");
		
	}
	
	@RequestMapping("/{id}")
	public ModelAndView addmov(@PathVariable("id") Long mId )
	{
		CurMov cm=new CurMov();
		cm.setmId(mId);
		Long TID=theSer.getTheatreId();
		cm.setTheatreId(TID);
		curMovRepo.save(cm);
		
		int flag=theSer.addCurMovId();
		if(flag==1) {
			status="error";
			
		}
		else {
			status="added";
		 
		}
		return new ModelAndView("main");
		
	}
	
	@RequestMapping("/cur")
	public ModelAndView currentMovies() {
		
		List curMov=new ArrayList();
		try {
		List<CurMov> cur=curMovRepo.findAll();
		int n=mov.length;
		
		int l=cur.size();
		for(int j=0;j<l;j++) {
			CurMov c=cur.get(j);
			if(c.getTheatreId().equals(theSer.getTheatreId())) {
				
			    Movie mov=this.restTemplate.getForObject("http://Movie/movie/"+c.getmId(),Movie.class);
			    curMov.add(mov);
			    k=curMov.size();

			}
		}
		}catch(Exception e) {
			System.out.print(e);
		}
		System.out.println(".....................@@.."+curMov);
		
		 HashMap<String,List<Book>> model=new HashMap<>();
			System.out.println(model);
			model.put("list", curMov);
		
		return new ModelAndView("cur",model) ;
		
	}
     
	@RequestMapping("/landing")
	public ModelAndView landing() {
		return new ModelAndView ("landing");
		
	}
	
	@RequestMapping("/det")
	public ModelAndView details(ModelMap model) {
		model.put("name",theSer.getName());
		model.put("address",theSer.getAddress());
		model.put("id",theSer.getTheatreId());
		model.put("cur",k);
		model.put("rate",4.5);
		
		return new ModelAndView ("det");
		
	}

	
	
}

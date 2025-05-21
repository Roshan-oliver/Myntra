package com.example.Myntra.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.example.Myntra.exception.Userexistexception;
import com.example.Myntra.json.UserJson;
import com.example.Myntra.model.UserDetails;
import com.example.Myntra.repository.UserRepository;

@Service

public class UserService {
	
	@Autowired
	private UserRepository urepo;

	public UserJson add(UserJson userjson) throws HttpMediaTypeNotAcceptableException  {
		UserJson ujson = new UserJson();
		Optional<UserDetails> details = urepo.findbymob(userjson.getMobilenumber());
		if(details.isPresent()) {
			
			
		}
		else {
			UserDetails udetail = new UserDetails();
			udetail.setMobilenumber(userjson.getMobilenumber());
			udetail.setEmail(userjson.getEmail());
			udetail.setDob(userjson.getDob());
			udetail.setName(userjson.getName());
			udetail.setPassword(userjson.getPassword());
			urepo.save(udetail);
		}
		
		
		return ujson;
	}

	public List<UserJson> get1() {
		List<UserJson> js = new ArrayList<UserJson>();
		Collection<UserDetails> detail = urepo.findAll();
		for (UserDetails userDetails : detail) {
			UserJson user = new UserJson();
			user.setId(userDetails.getId());
			user.setEmail(userDetails.getEmail());
			user.setMobilenumber(userDetails.getMobilenumber());
			user.setDob(userDetails.getDob());
			user.setName(userDetails.getName());
			js.add(user);
			
		}
		return js;
	}
	

	public List<UserJson> getdata(String mobilenumber) {
		List<UserJson> jsop = new ArrayList<UserJson>();
		Collection<UserDetails> detai = urepo.findby(mobilenumber);
		for (UserDetails ude : detai) {
			UserJson j = new UserJson();
		j.setDob(ude.getDob());
		j.setEmail(ude.getEmail());
		j.setMobilenumber(ude.getMobilenumber());
		jsop.add(j);
		
		}
		
		return jsop;
	}

	public UserJson addth(UserJson ujson) {
		UserJson uj = new UserJson();
		Optional<UserDetails> det = urepo.findbymob(ujson.getMobilenumber());
		if(det.isPresent()) {
		UserDetails model = det.get();
		model.setEmail(ujson.getEmail());
		model.setPassword(ujson.getPassword());
		urepo.save(model);
		}
		else {
			
		}
		return uj;
	}

	public UserJson delete(String mob) {
		UserJson jso = new UserJson();
		Optional<UserDetails> ud = urepo.findbymob12(mob);
		if(ud.isPresent()) {
			urepo.delete(mob);
		}
		return jso;
	}



}

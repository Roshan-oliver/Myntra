package com.example.Myntra.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Myntra.json.UserJson;
import com.example.Myntra.service.UserService;

@RestController
@RequestMapping("gat")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("postthedata")
	public @ResponseBody ResponseEntity<UserJson> add(@RequestBody UserJson userjson) throws HttpMediaTypeNotAcceptableException{
		UserJson UJ = new UserJson();
		UJ = service.add(userjson);
		
		return new ResponseEntity<UserJson>(UJ, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("getalldata")
	public ResponseEntity<List<UserJson>> get(){
		List<UserJson> jso = new ArrayList<UserJson>();
		jso = service.get1();
		return new ResponseEntity<List<UserJson>>(jso,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("getbyid")
	public ResponseEntity<List<UserJson>> getby(@RequestParam (value="email",required = true)String mobilenumber){
		List<UserJson> js = new ArrayList<UserJson>();
		js = service.getdata(mobilenumber);
		return new ResponseEntity<List<UserJson>>(js,HttpStatus.OK);
		
	}
	
	@PutMapping("add")
	public @ResponseBody ResponseEntity<UserJson> addthe(@RequestBody UserJson ujson){
		UserJson uj = new UserJson();
		uj = service.addth(ujson);
		return new ResponseEntity<UserJson>(uj,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("delete")
	public @ResponseBody ResponseEntity<UserJson> dele(@RequestParam (value = "mobilenumber",required = true)String mob){
		UserJson js = new UserJson();
		js= service.delete(mob);
		return new ResponseEntity<UserJson>(js,HttpStatus.OK);
		
	}

}

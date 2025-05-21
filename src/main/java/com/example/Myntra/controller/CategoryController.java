package com.example.Myntra.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Myntra.json.Aljson;
import com.example.Myntra.json.CategoryJson;
import com.example.Myntra.json.UserJson;
import com.example.Myntra.json.messagejson;
import com.example.Myntra.model.CategoryModel;
import com.example.Myntra.service.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping("getall")
	public ResponseEntity<List<CategoryJson>> getdata(){
		
	
	List<CategoryJson> json = new ArrayList<CategoryJson>();
	json = service.getthe();
	return new ResponseEntity<List<CategoryJson>>(json,HttpStatus.OK);
	
	}
	
	@GetMapping("getbyid")
	public ResponseEntity<List<CategoryJson>> getby(@RequestParam(value ="categoryname",required = true)String name){
		List<CategoryJson> jso = new ArrayList<CategoryJson>();
		jso = service.getall(name);
		return new ResponseEntity<List<CategoryJson>>(jso,HttpStatus.OK);
		
	}
	
	@PostMapping("post")
	public @ResponseBody ResponseEntity<messagejson> addthe(@RequestBody Aljson json){
		messagejson js = new messagejson();
		js = service.addthdata(json);
		return new ResponseEntity<messagejson>(js,HttpStatus.ACCEPTED);
	
		
	}
	
	@PostMapping("postbyid")
	public @ResponseBody ResponseEntity<messagejson> ad(@RequestBody Aljson alson){
		messagejson json = new messagejson();
		json = service.find(alson);
		return new ResponseEntity<messagejson>(json,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("postall")
	public @ResponseBody ResponseEntity<messagejson> add(@RequestBody CategoryJson catjson){
		messagejson js = new messagejson();
		js = service.addall(catjson);
		return new ResponseEntity<messagejson>(js,HttpStatus.ACCEPTED);
	}
	
	
}

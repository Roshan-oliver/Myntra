package com.example.Myntra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


public class Userexistexception extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int statuscode;
	private String message;
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Userexistexception(int statuscode, String message) {
		super();
		this.statuscode = statuscode;
		this.message = message;
	}
	public Userexistexception(HttpStatus accepted, String message2) {
		// TODO Auto-generated constructor stub
	}
	public Userexistexception(String string, HttpStatus accepted) {
		// TODO Auto-generated constructor stub
	}
	
	
	

}

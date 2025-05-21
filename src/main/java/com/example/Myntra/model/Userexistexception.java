package com.example.Myntra.model;

public class Userexistexception extends RuntimeException{
	
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
	public Userexistexception() {
		super();
	}
	
	

}

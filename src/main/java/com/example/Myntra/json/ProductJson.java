package com.example.Myntra.json;



public class ProductJson {
	
	private int id;
	private String productname;
	private String producttype;
	private Boolean isactive;
	private CategoryJson json;
	public ProductJson() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProducttype() {
		return producttype;
	}
	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}
	public Boolean getIsactive() {
		return isactive;
	}
	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}
	public CategoryJson getJson() {
		return json;
	}
	public void setJson(CategoryJson json) {
		this.json = json;
	}
	
	
	

}

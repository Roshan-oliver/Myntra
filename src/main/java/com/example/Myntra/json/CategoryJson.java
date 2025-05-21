package com.example.Myntra.json;

import java.util.Date;
import java.util.List;

public class CategoryJson {
	
	private int categoryid;
	private String categoryname;
	private Boolean isactive;
	private String catdescription;
	private Date createdOn;
	List<ProductJson> productjson;
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public Boolean getIsactive() {
		return isactive;
	}
	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}
	public String getCatdescription() {
		return catdescription;
	}
	public void setCatdescription(String catdescription) {
		this.catdescription = catdescription;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	
	public List<ProductJson> getProductjson() {
		return productjson;
	}
	public void setProductjson(List<ProductJson> productjson) {
		this.productjson = productjson;
	}
	public CategoryJson() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

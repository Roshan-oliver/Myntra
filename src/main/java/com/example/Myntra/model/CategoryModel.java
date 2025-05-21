package com.example.Myntra.model;


import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Category")
public class CategoryModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryid;
	private String categoryname;
	private Boolean isactive;
	private String catdescription;
	private Date createdOn;
	@OneToMany(mappedBy = "categorymodel")
	private List<ProductModel> productmodel;
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
	public List<ProductModel> getProductmodel() {
		return productmodel;
	}
	public void setProductmodel(List<ProductModel> productmodel) {
		this.productmodel = productmodel;
	}
	public CategoryModel() {
		super();
	}
	
	
	
	
	
	
	
	
	
	
	

}

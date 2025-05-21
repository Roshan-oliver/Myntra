package com.example.Myntra.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="products")
public class ProductModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String productname;
	private String producttype;
	private Boolean isactive;
	@ManyToOne
	@JoinColumn(name = "categoryid")
	private CategoryModel categorymodel;
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
	public CategoryModel getCategorymodel() {
		return categorymodel;
	}
	public void setCategorymodel(CategoryModel categorymodel) {
		this.categorymodel = categorymodel;
	}
	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}

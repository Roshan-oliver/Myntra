package com.example.Myntra.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Myntra.json.Aljson;
import com.example.Myntra.json.CategoryJson;
import com.example.Myntra.json.ProductJson;
import com.example.Myntra.json.messagejson;
import com.example.Myntra.model.CategoryModel;
import com.example.Myntra.model.ProductModel;
import com.example.Myntra.repository.CategoryRepo;
import com.example.Myntra.repository.productrepo;

import jakarta.transaction.Transactional;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepo crepo;
	
	@Autowired
	private productrepo prepo;

	public List<CategoryJson> getthe() {
		List<CategoryJson> json = new ArrayList<CategoryJson>();
		Collection<CategoryModel> mode = crepo.findAll();
		for (CategoryModel categoryModel : mode) {
			CategoryJson js = new CategoryJson();
			js.setCategoryname(categoryModel.getCategoryname());
			js.setCatdescription(categoryModel.getCatdescription());
			js.setCreatedOn(categoryModel.getCreatedOn());
			js.setIsactive(true);
			json.add(js);
			
			
			List<ProductJson> pjson = new ArrayList<ProductJson>();
			List<ProductModel> pmode = categoryModel.getProductmodel();
			for (ProductModel model : pmode) {
				ProductJson jso = new ProductJson();
				jso.setId(model.getId());
				jso.setIsactive(true);
				jso.setProductname(model.getProductname());
				jso.setProducttype(model.getProducttype());
				pjson.add(jso);
				
				
				
				
			}
			js.setProductjson(pjson);
			
			
		}
		return json;
	}

	public List<CategoryJson> getall(String name) {
		List<CategoryJson> cjson = new ArrayList<CategoryJson>();
		CategoryJson js = new CategoryJson();
		Optional<CategoryModel> model = crepo.finbyname(name);
		if(model.isPresent()) {
			
			
			List<ProductModel> product = new ArrayList<ProductModel>();
			List<ProductJson> p = new ArrayList<ProductJson>();
			for (ProductModel productModel : product) {
				
			
			
				ProductJson pjs = new ProductJson();
				pjs.setId(productModel.getId());
				pjs.setIsactive(productModel.getIsactive());
				pjs.setProductname(productModel.getProductname());
				pjs.setProducttype(productModel.getProducttype());
				p.add(pjs);
				
				
			}	
			js.setProductjson(p);
			cjson.add(js);
			}
		
		return cjson;
	}

	public messagejson addthdata(Aljson json) {
		messagejson mg = new messagejson();
		Optional<CategoryModel> mode = crepo.finbyname1(json.getCategoryname());
		if(mode.isPresent()) {
			mg.setMessage("already present");
			
			
		}
		else
		{
			
		
			CategoryModel modea = new CategoryModel();
			modea.setCategoryname(json.getCategoryname());
			modea.setCatdescription(json.getCatdescription());
			modea.setCreatedOn(new Date());
			modea.setIsactive(true);
			crepo.save(modea);
			
			ProductModel model = new ProductModel();
			model.setProductname(json.getProductname());
			model.setProducttype(json.getProducttype());
			model.setIsactive(true);
			model.setCategorymodel(modea);
			prepo.save(model);
			mg.setMessage("added sucessfully");
			
		}
		return mg;
	}

	public messagejson find(Aljson alson) {
		messagejson mog = new messagejson();
		Optional<CategoryModel> model = crepo.finbyname1(alson.getCategoryname());
		if(model.isPresent()) {
			CategoryModel mod = model.get();
			ProductModel pmod = new ProductModel();
			pmod.setId(alson.getId());
			pmod.setIsactive(true);
			
			pmod.setProductname(alson.getProductname());
			pmod.setProducttype(alson.getProducttype());
			pmod.setCategorymodel(mod);
			prepo.save(pmod);
		}
		else {
			mog.setMessage("notavailable");
		}
		return mog;
	}

	@Transactional
	public messagejson addall(CategoryJson catjson) {
		messagejson jso = new messagejson();
		Optional<CategoryModel> model = crepo.finbyname123(catjson.getCategoryname());
		if(model.isPresent()) {
			jso.setMessage("data is present");
		}
		else {
			CategoryModel mod = new CategoryModel();
			mod.setCategoryname(catjson.getCategoryname());
			mod.setCatdescription(catjson.getCatdescription());
			mod.setCreatedOn(new Date());
			crepo.save(mod);
			
			
			 List<ProductJson> products = catjson.getProductjson();
			    for (ProductJson pjson : products) {
			        ProductModel product = new ProductModel();
			        product.setProductname(pjson.getProductname());
			        product.setProducttype(pjson.getProducttype());
			        product.setIsactive(true);
			        
			        product.setCategorymodel(mod);;  // Set the association
			        prepo.save(product);
			    }
			    
				
			}
		
		
		return jso;
	}

}

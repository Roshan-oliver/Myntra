package com.example.Myntra.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Myntra.model.CategoryModel;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryModel, Integer>{

	@Query(value = "select * from category where categoryname=:name",nativeQuery = true)
	Optional<CategoryModel> finbyname(String name);

	@Query(value = "select * from category where categoryname=:categoryname",nativeQuery = true)
    Optional<CategoryModel> finbyname1(String categoryname);

	@Query(value = "select * from category where categoryname=:categoryname",nativeQuery = true)
    Optional<CategoryModel> finbyname12(String categoryname);

	@Query(value = "select * from category where categoryname=:categoryname",nativeQuery = true)
    Optional<CategoryModel> finbyname123(String categoryname);

}

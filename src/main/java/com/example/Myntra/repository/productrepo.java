package com.example.Myntra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Myntra.model.ProductModel;

@Repository
public interface productrepo extends JpaRepository<ProductModel, Integer>{

}

package com.example.Myntra.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Myntra.model.UserDetails;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer>{

	@Query(value = "select * from user_details where mobilenumber=:mobilenumber",nativeQuery = true)
	Optional<UserDetails> findbymob(String mobilenumber);

	

	@Query(value = "select * from user_details where email=:mobilenumber",nativeQuery = true)
    Collection<UserDetails> findby(String mobilenumber);



	@Query(value = "select * from user_details where mobilenumber=:mobilenumber",nativeQuery = true)
    Optional<UserDetails> findbymob1(String mobilenumber);



	@Query(value = "select * from user_details where mobilenumber=:mob",nativeQuery = true)
	Optional<UserDetails> findbymob12(String mob);



	@Transactional
	@Modifying
	@Query(value = "delete from user_details where mobilenumber=:mob", nativeQuery = true)
	void delete(String mob);
	
	//@Query(value = "delete from user where mobno=:mobno", nativeQuery = true)

}

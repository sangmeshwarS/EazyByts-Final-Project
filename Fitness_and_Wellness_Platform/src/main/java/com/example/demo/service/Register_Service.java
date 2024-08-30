package com.example.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.pojo.Register_Pojo;

public interface Register_Service extends JpaRepository<Register_Pojo, Integer>{
	
	@Query("select u from Register_Pojo u where u.email = ?1 and u.password = ?2")
	public List<Register_Pojo> getByEmailAndPassword(@Param("email")String email,@Param("password") String password);
}

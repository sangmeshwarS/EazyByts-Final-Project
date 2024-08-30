package com.example.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Nutrition_Pojo;

public interface Nutrition_Service extends JpaRepository<Nutrition_Pojo, Integer>{

}

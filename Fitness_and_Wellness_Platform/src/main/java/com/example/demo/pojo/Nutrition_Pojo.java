package com.example.demo.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Nutrition_Pojo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String calories;
	private String protein;
	private String carbs;
	private String fat;
	public Nutrition_Pojo(String name, String calories, String protein, String carbs, String fat) {
		super();
		this.name = name;
		this.calories = calories;
		this.protein = protein;
		this.carbs = carbs;
		this.fat = fat;
	}
	public Nutrition_Pojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCalories() {
		return calories;
	}
	public void setCalories(String calories) {
		this.calories = calories;
	}
	public String getProtein() {
		return protein;
	}
	public void setProtein(String protein) {
		this.protein = protein;
	}
	public String getCarbs() {
		return carbs;
	}
	public void setCarbs(String carbs) {
		this.carbs = carbs;
	}
	public String getFat() {
		return fat;
	}
	public void setFat(String fat) {
		this.fat = fat;
	}
	@Override
	public String toString() {
		return "Nutrition_Pojo [id=" + id + ", name=" + name + ", calories=" + calories + ", protein=" + protein
				+ ", carbs=" + carbs + ", fat=" + fat + "]";
	}
	
	
	

}

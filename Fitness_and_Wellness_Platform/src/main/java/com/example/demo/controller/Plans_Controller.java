package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.pojo.Nutrition_Pojo;
import com.example.demo.service.Nutrition_Service;

@Controller
public class Plans_Controller {
	
	@Autowired
	private Nutrition_Service service;
	
	@RequestMapping("/workoutPlans")
	public String workoutPlans() {
		return "workoutPlans";
	}
	
	@RequestMapping("/pplWorkout")
	public String pplWorkout() {
		return "pplWorkout";
	}
	
	
	@RequestMapping("/profile")
	public String profile() {
		return "profileForm";
	}
	
	@RequestMapping("/processProfile")
	public String processProfile(@RequestParam("weight")double weight, @RequestParam("height")double height) {
		double heightMeters = height/100;
		double heightS = heightMeters*heightMeters;
		double bmi = weight/heightS;
		System.out.println(bmi);
		return "redirect:/BMIndexs";
	}
	
	@RequestMapping("/nutritionForm")
	public String nutrition() {
		return "nutritionForm";
	}
	
	@RequestMapping("/processNutrition")
	public String processNutrition(@ModelAttribute("n")Nutrition_Pojo n) {
		this.service.save(n);
		return "redirect:/index";
	}
	
	@RequestMapping("/getMeals")
	public String getMeals(Model m) {
		List<Nutrition_Pojo> li = this.service.findAll();
		m.addAttribute("mlist", li);
		return "getMeals";
	}

}

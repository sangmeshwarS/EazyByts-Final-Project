package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.pojo.Register_Pojo;
import com.example.demo.service.Register_Service;

import jakarta.servlet.http.HttpSession;

@Controller
public class Register_Controller {
	
	@Autowired
	private Register_Service service;
	
	@RequestMapping("/index")
	public String index(Model m) {
		Register_Pojo r = new Register_Pojo(1, "Sangam", "s@gmfail.com", "123");
//		r.setId(2);
		List<Register_Pojo> rli = new ArrayList<Register_Pojo>();
		rli.add(r);
		m.addAttribute("list", r);
		return "index";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping("/processRegister")
	public String processRegister(@ModelAttribute("r")Register_Pojo r, Model m){
		m.addAttribute("register", r);
		this.service.save(r);
		return "login";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession s) {
		s.removeAttribute("login");
		s.removeAttribute("email");
		return "redirect:/login";
	}
	
	@RequestMapping("/processLogin")
	public String processLogin(@RequestParam("email")String email, @RequestParam("password")String password, Model m, HttpSession s) {
	
		List<Register_Pojo> li =this.service.getByEmailAndPassword(email, password);
		
		m.addAttribute("userList", li);
		s.setAttribute("name", li.get(0).getName());
	
	 if(li.isEmpty()) {
		 return "redirect:/login";
	 }else {
		 s.setAttribute("login", "Login Successful");
		 s.setAttribute("email", email);
		 return "redirect:/index";
	 }
	}
	
}

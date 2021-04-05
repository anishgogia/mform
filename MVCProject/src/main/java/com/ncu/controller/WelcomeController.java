package com.ncu.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping("/hello")
	public String welcomemsg(Model model) {
		model.addAttribute("msg", "vaishali");
		return "index";
	}
}
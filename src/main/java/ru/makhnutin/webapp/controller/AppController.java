package ru.makhnutin.webapp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {


	@RequestMapping("/")
	String homePage(ModelMap modal) {
		modal.addAttribute("title","Web Security Application");
		return "index";
	}

	@RequestMapping("/admin")
	String adminPage(ModelMap modal) {
		modal.addAttribute("title","Admin Page");
		return "admin";
	}

	@RequestMapping("/list")
	String listPage() {
		return "list";
	}

	@RequestMapping("/login")
	String loginPage() {
		return "login";
	}

	@RequestMapping("/accessDenied")
	String accessDeniedPage() {
		return "403";
	}
}

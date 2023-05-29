package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	
	//화면 요청
	@RequestMapping("/quiz01")
	public String quiz01() {
		
		return "quiz/quiz01";
	}
	
	@RequestMapping("/sendBirth")
	public String sendBirth(Model model,
							@RequestParam(value="year", required=false) String year,
							@RequestParam(value="month", required=false) String month,
							@RequestParam(value="day", required=false) String day) {
		
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		System.out.println(year+ month+ day);
		return "/quiz/quiz01_ok;";
	}
	
	//////////////////////////////////////
	
	@RequestMapping("/quiz02")
	public String quiz02() {
		
		return "quiz/quiz02";
	}
	
	@RequestMapping("/join")
	public String join() {
		
		return "quiz/quiz02_ok";
	}
	
	/////////////////////////////////////////
	
	@RequestMapping("/quiz03")
	public String quiz03() {
		
		return "quiz/quiz03";
	}
	
	@RequestMapping("quiz03_ok")
	public String quiz03_ok() {
		
		
		return "quiz/quiz03_ok";
	}	
	

}

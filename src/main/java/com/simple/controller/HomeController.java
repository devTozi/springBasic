package com.simple.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	//로그 출력기능 - 패키지별로 등록을 log4j.xml에 등록, 다른 패키지에서도 사용하고 싶으면 logger태그에 패키지 추가해야 함
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//log기능 대신 sysout으로 출력 가능
		//logger.info("Welcome home! The client locale is {}.", locale);
		
	
		return "home";
	}
	
}

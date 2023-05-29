package com.simple.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.ReqVO;

@Controller
@RequestMapping("/response")
public class ResponseController {
	//1. 화면
	@RequestMapping("/ex01") //입력 경로
	public String ex01() {
		
		return "response/ex01"; //출력 경로
	}
	
	//result01 요청
	@RequestMapping("/result01")
	public String result01(Model model) {
		
		model.addAttribute("data", "홍길동"); //앞에가 키, 뒤에가 값
		model.addAttribute("serverTime", new Date());
		return "response/result01";
	}
	
	
	//result02 요청 - ModelAndView 객체
	@RequestMapping("/result02")
	public ModelAndView result02() {
		
		//뷰의 정보, 데이터 정보를 함께 저장할 수 있는 객체
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", "홍길동");
		mv.addObject("name", "이순신");
		mv.setViewName("response/result02");
		
		return mv;
	}
	
	//@ModelAttribute
	@RequestMapping("/result03")
	//num이라는 값을 받아서 aaa라는 변수에 저장하겠다
	public String result03(@ModelAttribute("num") String aaa) {
		
		System.out.println("화면 데이터: " +  aaa);
		
		return "response/result03";
	}
	
	@RequestMapping("/result04")
	public String result04(@ModelAttribute("article") ReqVO vo) {
		
		System.out.println("화면에서 넘어오는 데이터:" + vo.toString());
		
		return "response/result04";
	}
	
	//////////////////////////////////////////////////////////////
	
	//redirect 이동과 redirectAttribute
	//스프링에서 redirect는 다시 컨트롤러를 태우는 요청
	//redirectAttribute는 redirect시에 일회성 데이터를 저장할 수 있다
	
	//화면 요청
	@RequestMapping("/redirect_login")
	public String loginView() {
		
		return "response/redirect_login";
	}
	
	//로그인 요청
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String login(@RequestParam("id") String id,
						@RequestParam("pw") String pw,
						RedirectAttributes ra) {
		//로그인 성공 -> home 화면으로 
		if(id.equals(pw)) {
			//사용하고자 하는 데이터를 한 번만 사용할 수 있다
			ra.addFlashAttribute("msg", "할 수 있어");
			
			//redirect: 를 작성하면 redirect기능을 사용한다는 뜻
			return "redirect:/"; //다시 home컨트롤러(home화면: "/")를 태워 보냄 - model데이터를 사용할 순 없음(데이터를 다 버리기 때문)
		//로그인 실패
		}else {
			ra.addFlashAttribute("msg", "다시 하면 돼!");
			//redirect:/절대경로
			return "redirect:/response/redircet_login";
		}
	}
	
	
	
	
	
}

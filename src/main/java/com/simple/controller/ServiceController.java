package com.simple.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ScoreVO;
import com.simple.score.service.ScoreService;
import com.simple.score.service.ScoreServiceImpl;

@Controller
@RequestMapping("/service")
public class ServiceController {
	//1st 방법 - new연산자를 이용한 service 객체 생성
	//ScoreServiceImpl service = new ScoreServiceImpl();
	
	//2nd - service를 bean으로 생성한다. 의존객체 자동주입
//	@Autowired //적합한 타입을 찾는다 없으면 이름으로 찾음, 찾으면 주입
//	ScoreServiceImpl service;
	
	//3rd - @Service로 빈 생성하고 의존 객체 자동주입
	@Autowired //
	@Qualifier("이름")
//	ScoreServiceImpl service;
	//인터페이스 타입으로도 선언 가능
	private ScoreService service;

	//화면 출력
	@RequestMapping("/scoreRegist")
	public String registView() {

		return "service/scoreRegist";
	}

	//폼 요청
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String regist(ScoreVO vo) {
		//System.out.println(vo.toString());


		service.regist(vo);
		return "service/scoreResult";
	}
	
	//목록화면
	@RequestMapping("/scoreList")
	public String scoreList(Model model) {
		
		//data조회 작업
		ArrayList<ScoreVO> list = service.getList();
		model.addAttribute("list", list);
//		System.out.println(list.toString());
		
		return "service/scoreList";
	}
	
	//삭제요청
	@RequestMapping("/delete")
	public String delete(@RequestParam("num")int num) {
		
		//System.out.println(num);
		
		//호출
		service.delete(num);
		return "redirect:/service/scoreList"; //삭제 후에 목록으로
	}
}

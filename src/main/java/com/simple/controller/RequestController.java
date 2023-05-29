package com.simple.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ReqVO;

@Controller
@RequestMapping("/request") //메서드 앞에 공통으로 들어가는 요청 경로
public class RequestController {
	//String 메서드 - 출력 화면을 직접 지정
	//	@RequestMapping("/ex01") //요청 경로
	//	public String ex01() {
	//		return "request/ex01"; //출력 경로
	//		//return "/request/ex01"; //절대 경로
	//	}

	@RequestMapping("ex01")
	public void ex01() {}

	//@RequestMapping(value="/basic1", method = RequestMethod.GET)//get메서드만 허용
	@GetMapping("/basic1")
	public String basic1() {

		System.out.println("get만 허용");
		return null;
	}

	//@RequestMapping(value = "/basic2", method=RequestMethod.POST) //post만 허용
	@PostMapping("/basic2")
	public String basic2() {

		System.out.println("post만 허용");
		return null;
	}

	@RequestMapping("/basic3")
	public String basic3() {

		System.out.println("get, post 둘 다 허용");
		return null;
	}


	///////////////////////////////////////////

	@RequestMapping("ex02")
	public String ex02() {
		return "request/ex02";
	}

	//1st
	//	//2. doAction 컨트롤러를 태운다 (doAction url로 바뀜)
	//	@RequestMapping(value="/doAction", method=RequestMethod.POST)
	//	public String doAction(HttpServletRequest request) {
	//		
	//		//name 파람
	//		String name = request.getParameter("name");
	//		//age파람
	//		String age = request.getParameter("age");
	//		//inter - checkbox
	//		String[] inter = request.getParameterValues("inter");
	//		
	//		System.out.println(name);
	//		System.out.println(age);
	//		System.out.println(Arrays.toString(inter));
	//		
	//		return "request/ex02_ok"; //3. ex02_ok 결과페이지로 나간다
	//	}

	//2nd
	//	@RequestMapping("/doAction")
	//	public String doAction(@RequestParam(value="name", required=false, defaultValue="") String name,
	//							@RequestParam(value="age") int age,
	//							//체크박스에 체크를 안 했을 경우: NullPointException 발생, name과 age의 파라미터 값만 넘어옴, null.toString()을 한 것이라서
	//							@RequestParam(value="inter", required=false, defaultValue="") List<String> list) {
	//		
	//		//RequestParam은 공백과 null 데이터가 전달되면 요청을 거절하게 됨
	//		//필수가 아닌 파라미터는 required=false로 지정하면 된다
	//		//필수가 아닌 파라미터인 경우에 null이나 ""(공백)을 지정하게 되는데 defaultValue로 기본값을 지정할 수 있다
	//		
	//		
	//		System.out.println(name);
	//		System.out.println(age);
	//		System.out.println(list.toString());
	//		
	//		return"request/ex02_ok";
	//	}

	//3rd. 커맨드 객체를 통해서 맵핑 - 넘어오는 데이터의 name과 setter명이 같아야함(멤버변수가 같아야 함)
	//	@RequestMapping("/doAction")
	//	public String doAction(ReqVO vo) {
	//		
	//		System.out.println(vo.toString());
	//		
	//		return "request/ex02_ok";
	//	}
	
	
	/////////////////////////////////실습///////////////////////////////////
	
	//화면 처리
	@RequestMapping("req_quiz01")
	public String req_quiz01() {
		return "request/req_quiz01";
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(@RequestParam(value="id", required=false) String id,
			@RequestParam(value="pw", required=false) String pw){

				if(id.equals("abc123") && pw.equals("xxx123")) {
					return "request/req_quiz01_ok";
				} else {
					return "request/req_quiz01_no";
				}
			}

}

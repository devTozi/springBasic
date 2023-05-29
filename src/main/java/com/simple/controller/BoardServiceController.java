package com.simple.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.board.service.BoardService;
import com.simple.command.BoardVO;

@Controller
@RequestMapping("/service")
public class BoardServiceController {
	
	@Autowired
	@Qualifier("aaa")
	private BoardService board;
	
	@RequestMapping("/boardRegister")
	public String boardRegistView() {
		
		return "/service/boardRegister";
	}
	
	@RequestMapping(value="/b_regist", method = RequestMethod.POST)
	public String boardRegist(BoardVO vo) {
		
		board.boardRegist(vo);
		return "/service/boardResult";
	}
	
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		
		ArrayList<BoardVO> b_list = board.getList();
		model.addAttribute("b_list", b_list);
		return "/service/boardList";
	}
	
	@RequestMapping("boardDelete")
	public String boardDelete(@RequestParam("num")int num) {
		
		board.boardDelete(num);
		
		return "redirect:/service/boardList";
	}

}

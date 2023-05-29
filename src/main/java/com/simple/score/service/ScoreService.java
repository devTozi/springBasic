package com.simple.score.service;

import java.util.ArrayList;

import com.simple.command.ScoreVO;

public interface ScoreService {
	
	//service 구현체(ScoreServiceImpl)에서 사용할 추상메서드의 모형을 선언
	public void regist(ScoreVO vo);
	
	//목록은 단일값이 아니니 list타입으로 값 가져오기
	public ArrayList<ScoreVO> getList();

	public void delete(int num);
}

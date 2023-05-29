package com.simple.basic.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.simple.command.ScoreVO;

import java.util.*;

@Mapper //mybatis의 mapper라는 것을 알려주는 것 - 스프링에선 생략해도 결과는 똑같아서 생략 가능

public interface TestMapper { 
	
	public String getTime(); //1
	
	//vo클래스?
	public ArrayList<ScoreVO> getScore();
	
	//단일값
	public ScoreVO getOne(int a);
	
	//insert 단일값
	public int insertOne(String name);
	
	//insert 다중값
	public int insertTwo(ScoreVO vo);
	
	//insert 다중값- map
	public int insertThree(Map<String,String> map);
	
	//select - map을 통한 한 행 조회
	public Map<String, Object> selectMap(int num); //9번 키 값 조회
	
	//select - map을 통한 다중 행 조회
	public ArrayList<Map<String, Object>> selectMap2();
	
	//update
	public boolean updateOne(ScoreVO vo); //9번 업데이트
	
	public void insertFour(@Param("변수명1")String name, @Param("변수명2") int kor);
	
	
}

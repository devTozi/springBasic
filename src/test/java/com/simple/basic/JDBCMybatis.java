package com.simple.basic;

import java.util.*;
import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simple.basic.mapper.TestMapper;
import com.simple.command.ScoreVO;

@RunWith(SpringJUnit4ClassRunner.class) // junit으로 테스트 환경을 구성  
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml") // 동작시킬 스프링 설정 파일
public class JDBCMybatis {
	
//	@Autowired
//	SqlSessionFactoryBean sqlSessionFactory;
//	
//	@Test
//	public void testCode01() {
//		//mybatis 핵심 객체
//		System.out.println(sqlSessionFactory);
//	}

	@Autowired
	TestMapper testMapper;
	
//	@Test
//	public void testCode02() {
//		String time = testMapper.getTime();
//		System.out.println(time);
//	}
	
//	//select태그의 resultType
//	@Test
//	public void testCode03() {
//		ArrayList<ScoreVO> list = testMapper.getScore();
//		System.out.println(list.toString());
//		
//	}
	
//	//매개변수 - 단일값
//	@Test
//	public void testCode04() {
//		ScoreVO vo = testMapper.getOne(1);
//		System.out.println(vo.toString());
//		
//	}
	
	//insert - 단일 값
//	@Test
//	public void testCode05() {
//		int result = testMapper.insertOne("이순신");
//		System.out.println("성공 실패: " + result);
//	}
	
	//insert - 다중 값(vo) - setter가 파라미터가 된다
//	@Test
//	public void testCode06() {
//		ScoreVO vo = new ScoreVO(0, "테스트", "34", "100");
//		int result = testMapper.insertTwo(vo);
//		System.out.println("성공 실패 결과:" + result);
//	}
	
	//Map 타입을 사용하는 것은 부득이한 경우에만 사용하기
	//insert - 다중값(Map) - key값이 파라미터가 된다
//	@Test
//	public void testCode07() {
//		
//		Map<String, String> map = new HashMap<>();
//		map.put("name", "홍길자");
//		map.put("kor", "30");
//		map.put("eng", "40");
//		int result = testMapper.insertThree(map);
//		System.out.println("성공실패결과: "+ result);
//	}
	
	//select - map타입의 반환(단일 행)
//	@Test
//	public void testCode08() {
//		Map<String, Object> map = testMapper.selectMap(9);
//		System.out.println(map.toString());
//	}
	
	//select - map타입의 반환(다중 행)
//	@Test
//	public void testCode09() {
//		ArrayList<Map<String, Object>> list = testMapper.selectMap2();
//		System.out.println(list.toString());
//	}
	
	//update
//	@Test
//	public void testCode10() {
//		ScoreVO vo = new ScoreVO(9,"변경","100","100");
//		boolean result = testMapper.updateOne(vo);
//		System.out.println("성공실패:" + result);
//	}
	
	//delete는 update구문과 똑같이 사용하면 된다
	
	//insert 구문 @Param - 매개변수가 두 개 이상일 때 매개변수에 이름 붙이기
//	@Test
//	public void testCode11() {
//		
//		testMapper.insertFour("param테스트", 100);
//	}
}

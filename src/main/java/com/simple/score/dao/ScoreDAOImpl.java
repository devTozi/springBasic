package com.simple.score.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simple.command.ScoreVO;

@Repository("yyy")
public class ScoreDAOImpl implements ScoreDAO{
   
   @Autowired
   private DataSource dataSource; //커넥션 풀의 Connection을 관리하기 위한 객체
   
   @Override
   public void regist(ScoreVO vo) {
      
      String sql = "insert into score(name, kor, eng) values (?, ?, ?)";
      Connection conn = null;
      PreparedStatement pstmt = null;
      
      try {
         conn = dataSource.getConnection();
         pstmt =  conn.prepareStatement(sql);
         
         pstmt.setString(1, vo.getName());
         pstmt.setString(2, vo.getKor());
         pstmt.setString(3, vo.getEng());
         
         pstmt.executeUpdate(); //insert, update, delete
         
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
         try {
            if(conn != null) conn.close();
            if(pstmt != null) pstmt.close();
         } catch (Exception e2) {
         }
      }
      
   }

   @Override
   public ArrayList<ScoreVO> getList() {

      String sql = "select * from score order by num desc";
      
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      ArrayList<ScoreVO> list = new ArrayList<>();
      
      try {
         
         conn = dataSource.getConnection();
         pstmt = conn.prepareStatement(sql);
         
         rs = pstmt.executeQuery();
         
         // ORM
         while(rs.next()) {
            ScoreVO vo = new ScoreVO();
            vo.setNum(rs.getInt("num")); // column명, 대소문자 구분 필요
            vo.setName(rs.getString("name"));
            vo.setKor(rs.getString("kor"));
            vo.setEng(rs.getString("eng"));
            list.add(vo);
         }
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if(conn != null) conn.close();
            if(pstmt != null) pstmt.close();
            if(rs != null) rs.close();
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }
      
      return list;
   }

   @Override
   public void delete(int num) {
      String sql = "delete from score where num=?";
      
      Connection conn = null;
      PreparedStatement pstmt = null;
      
      try {
    	  conn = dataSource.getConnection(); //DB와 연결
    	  pstmt = conn.prepareStatement(sql);
    	  
    	  pstmt.setInt(1, num); //첫 번째 물음표에 num
    	  
    	  pstmt.executeUpdate(); //sql에 결과 넘기기
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if(conn != null) conn.close();
			if(pstmt != null) pstmt.close();
		} catch (Exception e2) {
		}
	}
    		  
   }
   
   /*
   // 데이터베이스 대용
   ArrayList<ScoreVO> list = new ArrayList<>();
   
   @Override
   public void regist(ScoreVO vo) {
      
      // System.out.println("DAO 영역: "+ vo.toString());
      list.add(vo); // DB insert임
      System.out.println(list.toString());
   }
    
   @Override
   public ArrayList<ScoreVO> getList() {
      
      // 데이터 조회
      return list;
   }

   @Override
   public void delete(int num) {
      
      // 데이터 삭제
      list.remove(num);
   }
   */
   
   
   
}
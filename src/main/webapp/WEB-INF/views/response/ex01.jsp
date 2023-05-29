<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>response ex01</h3>
	
	<a href="result01">Model 객체 사용</a>
	<a href="result02">ModelAndView 객체 사용</a>
	
	<!-- 화면에 num값 넘기기 -->
	<a href="result03?num=10">ModelAttribute 어노테이션 사용(단일값)</a>
	
	<form action="result04" method="post">
		<input type="text" name="name" /><br/>
		<input type="text" name="age" /><br/>
		<input type="submit" value="ModelAttribute객체" />
	</form>
		
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>게시글 목록</h2>

	<table>
		<tr>
			<td>번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>내용</td>
			<td>비고</td>
		</tr>

		<!-- 반복데이터처리 -->
		<c:forEach var="article2" varStatus="num" items="${b_list}">
			<tr>
				<td>${article2.num}</td>
				<td>${article2.name}</td>
				<td>${article2.title}</td>
				<td>${article2.content}</td><br/>
				<td><input type="button" value="삭제" onclick=""></td>
				
			</tr>
		</c:forEach>
		<!-- 
			1. boardDelete로 삭제 처리하세요. 
			2. 삭제 후엔 목록화면으로 리다이렉트 하세요.
			-->
	</table>

	<%--게시글 작성페이지로 이동시키세요. --%>
	<a href="boardRegister">게시글 작성</a>




</body>
</html>





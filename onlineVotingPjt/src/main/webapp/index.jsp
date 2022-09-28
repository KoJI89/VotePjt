<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<meta charset="UTF-8">
<title>King of animal</title>

<style type="text/css">
	#regbox{
		width: 300px;
	}

	#regbox label{
		display : block;
		width : 100 px;
		float : left;
	}
	
		#regbox input{
		float : right;
	}
</style>

</head>

<body>

<%
session.invalidate();
%>

<h1> 동물의 왕을 뽑아주세요! </h1><br/>
    <!--action : @RequestMapping으로  -->
	<form method="post" action="t1">
	<fieldset id="regbox">
		<legend>로그인</legend>
			
		<label for="id" > 아 이 디   </label>

		<input type="text" name="id"><br/><br/>
		  
		<label for="pwd" > 비밀번호  </label>
		<input type="password" name="pwd"><br/><br/>		  

		  
		<input type="submit" value="로그인">
		<input type="reset" value="취소">
  </fieldset>
</form> 
<br>
</br>

</body>


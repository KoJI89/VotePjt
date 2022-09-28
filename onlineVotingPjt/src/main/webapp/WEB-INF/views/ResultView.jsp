<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<% 
String Max_name = (String)request.getAttribute("Max_name");
String cnt = (String)request.getAttribute("result_cnt");
String cnt_Ho = (String)request.getAttribute("cnt_Ho");
String cnt_Co = (String)request.getAttribute("cnt_Co");
String cnt_Do = (String)request.getAttribute("cnt_Do");


%>
<body>

	<h1>투표결과</h1>
<% if(cnt.equals("16")){  %>
	<h3><%=cnt %>명이 투표에 참여하였습니다.</h3>
	   <hr />
	<h3><%=Max_name %>가 동물의 왕입니다.</h3>
<%  }else{  %>	
	<h3> 아직 투표가 진행중입니다.</h3>
<%  } %>


	
	<table class="table" style="width: 350px" border="1px black">
    <thead>
      <tr>
        <th>이름</th>
        <th>투표수</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>호랑이</td>
        <td>${cnt_Ho}</td>
      </tr>
      <tr>
        <td>코끼리</td>
        <td>${cnt_Co}</td>
      </tr>
      <tr>
        <td>독수리</td>
        <td>${cnt_Do}</td>
      </tr>
    </tbody>
  </table>

	<button type="button" onclick = "location.href='index.jsp'">홈으로</button><p/>

	
</body>
</html>
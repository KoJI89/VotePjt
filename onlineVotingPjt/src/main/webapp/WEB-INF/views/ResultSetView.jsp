<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
   int[] cnt = (int[])request.getAttribute("cnt");
   String winner = (String)request.getAttribute("winner");
   String max_value = (String)request.getAttribute("max_value");
%>
   <h1>투표 결과</h1>
   
   <% if(max_value.equals("16")){  %>
	<h3><%=max_value %>명이 투표에 참여하였습니다.</h3><hr/>
	   <h3>"${winner}"가 동물의 왕입니다.</h3>
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
        <td><%=cnt[0]%></td>
      </tr>
      <tr>
        <td>코끼리</td>
        <td>${cnt[1]}</td>
      </tr>
      <tr>
        <td>독수리</td>
        <td>${cnt[2]}</td>
      </tr>
    </tbody>
  </table><br/>
   <button type="button" onclick = "location.href='index.jsp'">홈으로</button><p/>
   
</body>
</html>
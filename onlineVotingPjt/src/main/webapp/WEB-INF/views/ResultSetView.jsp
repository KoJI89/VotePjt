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
   <h1>��ǥ ���</h1>
   
   <% if(max_value.equals("16")){  %>
	<h3><%=max_value %>���� ��ǥ�� �����Ͽ����ϴ�.</h3><hr/>
	   <h3>"${winner}"�� ������ ���Դϴ�.</h3>
<%  }else{  %>	
	<h3> ���� ��ǥ�� �������Դϴ�.</h3>
<%  } %>


   <table class="table" style="width: 350px" border="1px black">
    <thead>
      <tr>
        <th>�̸�</th>
        <th>��ǥ��</th>       
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>ȣ����</td>
        <td><%=cnt[0]%></td>
      </tr>
      <tr>
        <td>�ڳ���</td>
        <td>${cnt[1]}</td>
      </tr>
      <tr>
        <td>������</td>
        <td>${cnt[2]}</td>
      </tr>
    </tbody>
  </table><br/>
   <button type="button" onclick = "location.href='index.jsp'">Ȩ����</button><p/>
   
</body>
</html>
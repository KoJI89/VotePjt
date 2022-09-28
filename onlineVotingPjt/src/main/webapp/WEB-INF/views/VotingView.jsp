<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
       String id = (String)request.getAttribute("user_id");
      String pwd = (String)request.getAttribute("user_pwd");
      String isOK = (String)request.getAttribute("vote_ok");
      
   %>
   <!-- Controller에서 -->
   <h1><%=id %> 님! 로그인 되었습니다.</h1>
   <hr />
   <h3>동물의 왕은 누구일까요?</h3>   
   <form method="post" action="vt">
   <input type="hidden" name = "id" value="<%= id %>" />
   <input type="radio" name="chk_info" value="호랑이" required="required">호랑이
   <input type="radio" name="chk_info" value="코끼리" required="required">코끼리
   <input type="radio" name="chk_info" value="독수리" required="required">독수리
   
   <p><input type="submit" value="투표"> <input type="reset" value="취소"></p>
   </form>
</body>
</html>
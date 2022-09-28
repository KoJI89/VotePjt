package Pack01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckVote {
@RequestMapping( "/vt" )
public String chVote(Model model , HttpServletRequest request) {

      System.out.println( "VoteChcek" );
      
      int n = 0; 
      String id = request.getParameter("id");
      String voted = request.getParameter("chk_info");
      
      System.out.println(id);
      System.out.println(voted);

      PreparedStatement pstmt = null;      
      Connection connection = null;
      ResultSet resultSet = null;

      try {
         
         Class.forName("org.mariadb.jdbc.Driver");
         //connection = DriverManager.getConnection("jdbc:mariadb://192.168.0.2:13306/db02", "root", "1234");
         connection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/DB01", "root", "1234");
//			connection = DriverManager.getConnection("jdbc:mariadb://192.168.0.64:13306/DB01", "root", "1234");
         System.out.println(connection);
                  
//         String sql = "SELECT * FROM TABLE01 WHERE m_id=? and m_pwd=?";
         String sql = "UPDATE TABLE01 SET vote_info = ?, vote_ok='OK' WHERE m_id = ?";
         
         pstmt = connection.prepareStatement(sql);         
         pstmt.setString(1, voted);
         pstmt.setString(2, id);
         
         resultSet = pstmt.executeQuery();
         n=pstmt.executeUpdate();
         if(n > 0) {
            System.out.println("수정 성공");
         }else {
            System.out.println("수정 실패 : 아이디 값이 틀립니다.");
         }

      }catch(ClassNotFoundException e) {
            System.out.println("driver loading fail");
         }catch (SQLException e) {
            System.out.println(e);
      
         }finally {
            try {
               if (pstmt != null) pstmt.close();
               if (connection != null) connection.close();
               if (resultSet != null) resultSet.close();
               
            }catch(SQLException es) {
               System.out.println("SQL Excption_222");
            }
         }   
      return "DoneView";

}

}
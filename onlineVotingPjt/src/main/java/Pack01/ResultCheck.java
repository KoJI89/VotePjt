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
public class ResultCheck {
   @RequestMapping( "/list" )
   public String funcRs(Model model , HttpServletRequest request) {      
    

      String[] ar = {"호랑이","코끼리","독수리" };
      int[] cnt = new int[3];

                  

      PreparedStatement pstmt = null;      
      Connection connection = null;
      ResultSet resultSet = null;

      try {
         
         Class.forName("org.mariadb.jdbc.Driver");
         //connection = DriverManager.getConnection("jdbc:mariadb://192.168.0.2:13306/db02", "root", "1234");
         //connection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/DB01", "root", "1234");
		 connection = DriverManager.getConnection("jdbc:mariadb://192.168.0.64:13306/DB01", "root", "1234");
         for(int i=0; i<3; i++) {         
            String sql = "SELECT COUNT(*) FROM TABLE01 WHERE vote_info=? and vote_ok='OK'";
            
            pstmt = connection.prepareStatement(sql);         
            pstmt.setString(1, ar[i]);
            
            resultSet = pstmt.executeQuery();   
             int max = cnt[0];
             int num =0;
             String winner;            

             if (resultSet.next()) {   
               cnt[i] =Integer.parseInt( resultSet.getString("COUNT(*)"));      
                for (int j = 1; j < cnt.length; j++) {
                   if(max < cnt[j]) {
                        max = cnt[j];
                        num = j;
                     }               
                 }
               winner = ar[num];
               model.addAttribute("cnt", cnt);
               model.addAttribute("winner", winner);
             }  
             
			 sql = "SELECT COUNT(*) FROM TABLE01 WHERE vote_ok='OK'";

			 pstmt = connection.prepareStatement(sql);
			 resultSet = pstmt.executeQuery();
			
			if (resultSet.next()) {	
				String max_value =resultSet.getString("COUNT(*)");
				model.addAttribute("max_value", max_value);
				System.out.println("전체투표" + max_value);
			}

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
      return "ResultSetView";

}

}
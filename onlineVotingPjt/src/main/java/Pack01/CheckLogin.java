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
public class CheckLogin {
 		
	@SuppressWarnings("all")
	@RequestMapping("/t1")
	public String func01(Model model, HttpServletRequest request) {

		System.out.println("CheckLogin");
		System.out.println("login check start");

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		System.out.println("call check login" + id + pwd);
//			return "TigerView";	

		// request.setCharacterEncoding("UTF-8");

		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet resultSet = null;
		String cnt_Ho = null;
		String cnt_Co  = null;;
		String cnt_Do = null;
		String Max_name = null;
		

		try {

			Class.forName("org.mariadb.jdbc.Driver");
			//connection =  DriverManager.getConnection("jdbc:mariadb://192.168.0.2:13306/db02", "root", "1234");
			connection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/DB01", "root", "1234");
//			connection = DriverManager.getConnection("jdbc:mariadb://192.168.0.64:13306/DB01", "root", "1234");
			System.out.println(connection);

			String sql = "SELECT * FROM TABLE01 WHERE m_id=? and m_pwd=?";

			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);

			resultSet = pstmt.executeQuery();

			System.out.println(resultSet);

			if (resultSet.next()) {				 
				if (pwd.equals(resultSet.getString("m_pwd"))) {
					System.out.println("login ok ");

					String user_id = resultSet.getString("m_id");
					String vote_isok = resultSet.getString("vote_ok");
					System.out.println("vote_isok" + vote_isok);
					
					if	(vote_isok.equals("NOTOK")) {
						model.addAttribute("user_id", user_id);
						return "VotingView";
					}
					else 
					{												
						 sql = "SELECT COUNT(*) FROM TABLE01 WHERE vote_ok='OK'";

						pstmt = connection.prepareStatement(sql);
						resultSet = pstmt.executeQuery();
						
						if (resultSet.next()) {	
							String cnt =resultSet.getString("COUNT(*)");
							model.addAttribute("result_cnt", cnt);
							System.out.println("전체투표" + cnt);
						}
						
						String sql_Ho = "SELECT  COUNT(*) FROM TABLE01 WHERE vote_ok='OK' AND vote_info = '호랑이'";
						String sql_Co = "SELECT  COUNT(*) FROM TABLE01 WHERE vote_ok='OK' AND vote_info = '코끼리'";
						String sql_Do = "SELECT  COUNT(*) FROM TABLE01 WHERE vote_ok='OK' AND vote_info = '독수리'";

						pstmt = connection.prepareStatement(sql_Ho);
						resultSet = pstmt.executeQuery();
						if (resultSet.next()) {	
							 cnt_Ho =resultSet.getString("COUNT(*)");
							model.addAttribute("cnt_Ho", cnt_Ho);
							System.out.println("호랑이" + cnt_Ho);
						}
						
						pstmt = connection.prepareStatement(sql_Co);
						resultSet = pstmt.executeQuery();
						if (resultSet.next()) {	
							 cnt_Co =resultSet.getString("COUNT(*)");
							model.addAttribute("cnt_Co", cnt_Co);
							System.out.println("코끼리" + cnt_Co);
						}
						
						pstmt = connection.prepareStatement(sql_Do);
						resultSet = pstmt.executeQuery();
						if (resultSet.next()) {	
							 cnt_Do =resultSet.getString("COUNT(*)");
							model.addAttribute("cnt_Do", cnt_Do);
							System.out.println("독수리" + cnt_Do);
						}
						int numberHo = Integer.parseInt(cnt_Ho);
						int numberCo = Integer.parseInt(cnt_Co);
						int numberDo = Integer.parseInt(cnt_Do);
									
						if(numberHo > numberCo)
						{
							if( numberHo > numberDo) Max_name = "호랑이";	
							else Max_name = "독수리";
							System.out.println("1" + Max_name);
						}else if(numberCo > numberHo)
						{
							if( numberCo > numberDo) Max_name = "코끼리";
							else Max_name = "독수리";
							System.out.println("2" + Max_name);
						}else if(numberHo == numberCo)
						{
							if( numberHo > numberDo) Max_name = "호랑이 와 코끼리";	
							else Max_name = "독수리";	
							System.out.println("3" + Max_name);
						}
						else if(numberHo == numberDo)
						{
							if( numberHo > numberCo) Max_name = "호랑이 와 독수리";	
							else Max_name = "코끼리";	
							System.out.println("4" + Max_name);
						}
						else if(numberCo == numberDo)
						{
							if( numberCo > numberHo) Max_name = "코끼리 와 독수리";	
							else Max_name = "호랑이";	
							System.out.println("5" + Max_name);
						}
						
						model.addAttribute("Max_name", Max_name);
						System.out.println("Max_name" + Max_name);
						
						return "ResultView";						
					}
				}
			}
			else
    	    {
				System.out.println("id = null");
				return "NoMemberView";
    	    }
		} catch (ClassNotFoundException e) {
			System.out.println("driver loading fail");
		} catch (SQLException e) {
			System.out.println("id = null");
			return "NoMemberView";

		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (connection != null)
					connection.close();
				if (resultSet != null)
					resultSet.close();

			} catch (SQLException es) {
				System.out.println("SQL Excption_222");
			}
			
		}
		return "VotingView";

	}
}

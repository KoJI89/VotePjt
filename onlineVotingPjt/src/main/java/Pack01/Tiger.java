package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Controller
@Controller
public class Tiger {
	//@RequestMapping에 index파일에서 미리 설정해놓은 a태그의 herf를 지정하여 컨트롤러 진입을 확인한다
	/*@RequestMapping( "/t1" )
	public String func01() {
		System.out.println( " call 1" );
		// TigerView.jsp 로 이동해라
		
		//  Controller명 + View 명으로 하는것이 관례이다
		return "VotingView";
	}*/
	/*@RequestMapping( "/t2" )
	public String func02() {
		System.out.println( " call 2 " );
		// TigerView.jsp 로 이동해라
		
		//  Controller명 + View 명으로 하는것이 관례이다
		return "DoneView";
	}*/
//	@RequestMapping( "/t3" )
//	public String func03() {
//		System.out.println( " call 2 " );
//		// TigerView.jsp 로 이동해라
//		
//		//  Controller명 + View 명으로 하는것이 관례이다
//		return "ResultView";
//	}

}
